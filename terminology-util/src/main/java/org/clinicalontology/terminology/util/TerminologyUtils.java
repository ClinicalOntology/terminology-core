package org.clinicalontology.terminology.util;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ValueSetExpansion;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class TerminologyUtils {

    /**
     * Converts a collection of concepts to a query string fragment suitable for inclusion in a query string.
     * Ensures that the codes are enumerated in a deterministic order to facilitate caching.
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
     * Converts a list of codes belonging to the named code system to a query string fragment suitable for inclusion
     * in a query string. Ensures that the codes are enumerated in a deterministic order to facilitate caching.
     *
     * @param codeSystem The code system.
     * @param codes      The codes belonging to the above code system.
     * @return A string consisting of comma-delimited code system|code pairs.
     */
    public static String codesToQueryParam(CodeSystem codeSystem, String... codes) {
        return codesToQueryParam(codeSystem.getUrnAsString(), codes);
    }

    /**
     * Converts a list of codes belonging to the named code system to a query string fragment suitable for inclusion
     * in a query string. Ensures that the codes are enumerated in a deterministic order to facilitate caching.
     *
     * @param codeSystem The code system.
     * @param codes      The codes belonging to the above code system.
     * @return A string consisting of comma-delimited code system|code pairs.
     */
    public static String codesToQueryParam(String codeSystem, String... codes) {
        return Arrays.stream(codes)
            .map(code -> codeSystem + "|" + code)
            .sorted()
            .collect(Collectors.joining(","));
    }

    /**
     * Returns a concatenated string of concept members of the specified value set expansion
     * suitable for inclusion in a query string.
     *
     * @param valueSetExpansion The value set expansion.
     * @return A string consisting of comma-delimited code system|code pairs.
     */
    public static String conceptsToQueryParam(ValueSetExpansion valueSetExpansion) {
        return valueSetExpansion == null ? null : conceptsToQueryParam(valueSetExpansion.getExpansion());
    }

    /**
     * Returns displayable text from a concept.  If the concept has no display text, its code is returned.
     *
     * @param concept The concept.
     * @return The display text (never null).
     */
    public static String getDisplayText(Concept concept) {
        return concept == null ? "" : concept.getDisplayText();
    }

    private TerminologyUtils() {
    }

}
