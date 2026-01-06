package org.clinicalontology.terminology.api.model;

import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.util.*;

/**
 * A centralized registry of code systems.  Each code system must register itself.
 */
public class CodeSystemRegistry {

    private static final Map<String, CodeSystem> normalizedCodeSystemMap = new HashMap<>();

    private static final List<CodeSystem> codeSystems = new ArrayList<>();

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
        return StringUtils.equalsIgnoreCase(source, target);
    }

    /**
     * Registers a set of code systems to be used for lookup by URN or OID.
     *
     * @param codeSystems A list of code systems.
     */
    public static void registerCodeSystems(CodeSystem... codeSystems) {
        Collections.addAll(CodeSystemRegistry.codeSystems, codeSystems);
    }

    /**
     * Registers a set of code systems to be used for lookup by URN or OID.
     *
     * @param codeSystems A list of code systems.
     */
    public static void registerCodeSystems(Collection<? extends CodeSystem> codeSystems) {
        CodeSystemRegistry.codeSystems.addAll(codeSystems);
    }

    /**
     * Returns the URN of the normalized code system.
     *
     * @param codeSystem The URN or OID of the code system to be normalized.
     * @return The URN of the normalized code system.
     */
    public static String getNormalizedCodeSystem(String codeSystem) {
        CodeSystem normalized = Optional.ofNullable(codeSystem)
            .filter(StringUtils::isNotBlank)
            .map(Oid::stripPrefix)
            .map(normalizedCodeSystemMap::get)
            .orElse(null);

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
        return Optional.ofNullable(codeSystem)
            .map(CodeSystem::getUrnAsString)
            .map(normalizedCodeSystemMap::get)
            .orElse(codeSystem);
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
        CodeSystem toSystem
    ) {
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
        CodeSystem toSystem
    ) {
        normalizedCodeSystemMap.put(fromSystem, toSystem);
    }

    /**
     * Search for a code system that matches the specified URN.
     *
     * @param urn The URN to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byUrn(String urn) {
        return codeSystems.stream()
            .filter(cs -> cs.getUrn() != null
                && StringUtils.equalsIgnoreCase(urn, cs.getUrnAsString()))
            .findAny()
            .orElse(null);
    }

    /**
     * Search for a code system that contains the specified URN.
     *
     * @param urn The URN to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byUrn(URI urn) {
        return Optional.ofNullable(urn)
            .map(URI::toString)
            .flatMap(u -> codeSystems.stream()
                .filter(cs -> urn.equals(cs.getUrn()))
                .findAny())
            .orElse(null);
    }

    /**
     * Search for a code system that contains the specified OID.
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
     * Search for a code system that contains the specified OID.
     *
     * @param oid The OID to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byOid(Oid oid) {
        return codeSystems.stream()
            .filter(cs -> cs.getOids().contains(oid))
            .findAny()
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

    private CodeSystemRegistry() {
    }

}
