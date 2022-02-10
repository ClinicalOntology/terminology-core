package org.clinicalontology.terminology.api;

import java.net.URI;
import java.util.*;

@SuppressWarnings("unused")
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
        return source.equalsIgnoreCase(target);
    }

    /**
     * Registers a set of code systems to be used for lookup by URI or OID.
     *
     * @param codeSystems A list of code systems.
     */
    public static void registerCodeSystems(CodeSystem... codeSystems) {
        Collections.addAll(CodeSystemRegistry.codeSystems, codeSystems);
    }

    /**
     * Registers a set of code systems to be used for lookup by URI or OID.
     *
     * @param codeSystems A list of code systems.
     */
    public static void registerCodeSystems(Collection<? extends CodeSystem> codeSystems) {
        CodeSystemRegistry.codeSystems.addAll(codeSystems);
    }

    /**
     * Returns the URI of the normalized code system.
     *
     * @param codeSystem The URI or OID of the code system to be normalized.
     * @return The URI of the normalized code system.
     */
    public static String getNormalizedCodeSystem(String codeSystem) {
        codeSystem = Oid.stripPrefix(codeSystem);
        CodeSystem normalized = normalizedCodeSystemMap.get(codeSystem);

        if (normalized == null) {
            CodeSystem cs = findCodeSystem(codeSystem);
            normalized = cs == null ? null : getNormalizedCodeSystem(cs);
        }

        return normalized != null ? normalized.getUriAsString() : codeSystem;
    }

    /**
     * Returns the normalized code system.
     *
     * @param codeSystem The URL or OID of the code system to be normalized.
     * @return The normalized code system.
     */
    public static CodeSystem getNormalizedCodeSystem(CodeSystem codeSystem) {
        CodeSystem normalized = normalizedCodeSystemMap.get(codeSystem.getUriAsString());
        return normalized == null ? codeSystem : normalized;
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
        registerCodeSystemNormalization(fromSystem.getUriAsString(), toSystem);
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
     * Search for code system that contains the specified URI.
     *
     * @param uri The URI to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byUri(String uri) {
        return codeSystems.stream()
                .filter(cs -> (cs.getUri() != null
                        && uri.equalsIgnoreCase(cs.getUriAsString())))
                .findFirst()
                .orElse(null);
    }

    /**
     * Search for code system that contains the specified URI.
     *
     * @param uri The URI to match.
     * @return The matching code system, or null if not found.
     */
    public static CodeSystem byUri(URI uri) {
        return codeSystems.stream()
                .filter(cs -> uri.equals(cs.getUri()))
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
        CodeSystem system = byUri(value);
        return system != null ? system : byOid(value);
    }

    protected CodeSystemRegistry() {
    }

}
