package org.clinicalontology.terminology.util;

import org.apache.commons.lang3.StringUtils;
import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.ConceptSet;
import org.clinicalontology.terminology.api.Oid;
import org.clinicalontology.terminology.impl.CodeSystemImpl;
import org.clinicalontology.terminology.impl.ConceptImpl;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class TerminologyUtils {

    private static final Map<String, CodeSystem> normalizedCodeSystemMap = new HashMap<>();

    private static final List<CodeSystem> codeSystems = new ArrayList<>();

    /**
     * Converts a collection of concepts to a query string fragment suitable for inclusion
     * in a query string.  Ensures that the codes are enumerated in a predictable order to
     * facilitate caching.
     *
     * @param concepts A collection of concepts.
     * @return A string consisting of comma-delimited code system|code pairs.
     */
    public static String conceptsToQueryParam(Collection<Concept> concepts) {
        return concepts == null ? null : concepts.stream()
                .map(Concept::getSystemAndCode)
                .sorted()
                .collect(Collectors.joining(","));
    }

    /**
     * Method returns true if concept reference set contains a concept reference that is equivalent to any of the
     * specified targets.
     *
     * @param conceptSet The concept reference set tested.
     * @param targets             The concept references we wish to locate in the set.
     * @return True if concept reference set contains a concept reference that is equivalent to any of the specified targets.
     */
    public static boolean containsConcept(
            ConceptSet conceptSet,
            List<Concept> targets) {
        return targets.stream().anyMatch(conceptSet::contains);
    }

    /**
     * Method returns true if concept reference set contains a concept reference that is equivalent to any of the
     * specified targets.
     *
     * @param conceptSet The concept reference set tested.
     * @param targets             The concept references we wish to locate in the set.
     * @return True if concept reference set contains a concept reference that is equivalent to any of the specified targets.
     */
    public static boolean containsConcept(
            ConceptSet conceptSet,
            Concept... targets) {
        return containsConcept(conceptSet, Arrays.asList(targets));
    }

    /**
     * Creates a new Concept from a system and code, unless either are null or empty, in which case it returns a null.
     *
     * @param system The code system.
     * @param code   The code.
     * @return The newly created Concept or null.
     */
    public static Concept newConcept(
            CodeSystem system,
            String code) {
        return newConcept(system == null ? null : system.getUrnAsString(), code, null);
    }

    /**
     * Creates a new Concept from a system and code, unless either are null or empty, in which case it returns a null.
     *
     * @param system The code system.
     * @param code   The code.
     * @return The newly created Concept or null.
     */
    public static Concept newConcept(
            String system,
            String code) {
        return newConcept(system, code, null);
    }

    /**
     * Creates a new Concept from a system and code, unless either are null or empty, in which case it returns a null.
     *
     * @param system        The code system.
     * @param code          The code.
     * @param preferredName The preferred name.
     * @return The newly created Concept or null.
     */
    public static Concept newConcept(
            String system,
            String code,
            String preferredName) {
        return StringUtils.isEmpty(system) || StringUtils.isEmpty(code) ? null : new ConceptImpl(system, code, preferredName);
    }

    /**
     * Returns true if the normalized forms of the two code systems are equivalent.
     *
     * @param source The source code system.
     * @param target The target code system.
     * @return True if the normalized forms of the two code systems are equivalent.
     */
    public static boolean areSystemsEquivalent(
            String source,
            String target
    ) {
        source = getNormalizedCodeSystem(source);
        target = getNormalizedCodeSystem(target);
        return source.equalsIgnoreCase(target);
    }

    /**
     * Registers a set of code systems to be used for lookup by URN or OID.
     *
     * @param codeSystems A list of code systems.
     */
    public static void registerCodeSystems(CodeSystem... codeSystems) {
        Collections.addAll(TerminologyUtils.codeSystems, codeSystems);
    }

    /**
     * Registers a set of code systems to be used for lookup by URN or OID.
     *
     * @param codeSystems A list of code systems.
     */
    public static void registerCodeSystems(Collection<? extends CodeSystem> codeSystems) {
        TerminologyUtils.codeSystems.addAll(codeSystems);
    }

    /**
     * Returns the URN of the normalized code system.
     *
     * @param codeSystem The URN or OID of the code system to be normalized.
     * @return The URN normalized code system.
     */
    public static String getNormalizedCodeSystem(String codeSystem) {
        codeSystem = Oid.stripPrefix(codeSystem);
        CodeSystem normalized = normalizedCodeSystemMap.get(codeSystem);

        if (normalized == null) {
            CodeSystem cs = findCodeSystem(codeSystem);
            normalized = cs == null ? null : getNormalizedCodeSystem(cs);
        }

        return normalized != null ? normalized.getUrnAsString() : codeSystem;
    }

    /**
     * Returns the normalized code system.
     *
     * @param codeSystem The URL or OID of the code system to be normalized.
     * @return The normalized code system.
     */
    public static CodeSystem getNormalizedCodeSystem(CodeSystem codeSystem) {
        CodeSystem normalized = normalizedCodeSystemMap.get(codeSystem.getUrnAsString());
        return normalized == null ? codeSystem : normalized;
    }

    /**
     * Create a code system.
     *
     * @param urn  The URN.
     * @param oids Optional OIDs.
     * @return The newly created code system.
     */
    public static CodeSystem newCodeSystem(
            String urn,
            String... oids) {
        return new CodeSystemImpl(URI.create(urn), null, null, oids);
    }

    /**
     * Registers a mapping from one code system to another.  Used for normalizing code systems.  When
     * the "fromSystem" is encountered, it will be normalized to the "toSystem".
     *
     * @param fromSystem The code system to be normalized.
     * @param toSystem   The normalized code system.
     */
    public static void registerCodeSystemNormalization(
            CodeSystem fromSystem,
            CodeSystem toSystem) {
        registerCodeSystemNormalization(fromSystem.getUrnAsString(), toSystem);
        fromSystem.getOids().forEach(oid -> registerCodeSystemNormalization(oid.toString(), toSystem));
    }

    /**
     * Registers a mapping from one code system to another.  Used for normalizing code systems.  When
     * the "fromSystem" is encountered, it will be normalized to the "toSystem".
     *
     * @param fromSystem The code system to be normalized.
     * @param toSystem   The normalized code system.
     */
    public static void registerCodeSystemNormalization(
            String fromSystem,
            CodeSystem toSystem) {
        normalizedCodeSystemMap.put(fromSystem, toSystem);
    }

    /**
     * Search for code system that contains the specified urn.
     *
     * @param urn The urn to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byUrn(String urn) {
        return codeSystems.stream()
                .filter(cs -> (cs.getUrn() != null
                        && urn.equalsIgnoreCase(cs.getUrnAsString())))
                .findFirst()
                .orElse(null);
    }

    /**
     * Search for code system that contains the specified urn.
     *
     * @param urn The urn to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byUrn(URI urn) {
        return codeSystems.stream()
                .filter(cs -> urn.equals(cs.getUrn()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Search for code system that contains the specified OID.
     *
     * @param oid The OID as a string value (with or without the OID prefix).
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byOid(String oid) {
        return codeSystems.stream()
                .filter(cs -> cs.getOids().stream()
                        .anyMatch(value -> value.isEquivalent(oid)))
                .findAny()
                .orElse(null);
    }

    /**
     * Search for code system that contains the specified OID.
     *
     * @param oid The OID to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byOid(Oid oid) {
        return codeSystems.stream()
                .filter(cs -> cs.getOids().contains(oid))
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the code system with the specified URL or OID.  Performs a
     * case-insensitive search.
     *
     * @param value A URL or OID.
     * @return The corresponding code system, or null if not found.
     */
    public static CodeSystem findCodeSystem(String value) {
        CodeSystem system = byUrn(value);
        return system != null ? system : byOid(value);
    }

    protected TerminologyUtils() {
    }

}
