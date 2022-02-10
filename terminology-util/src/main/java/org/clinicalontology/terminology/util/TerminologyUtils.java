package org.clinicalontology.terminology.util;

import org.clinicalontology.terminology.api.Concept;

import java.util.Collection;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class TerminologyUtils {

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

    private TerminologyUtils() {
    }

}
