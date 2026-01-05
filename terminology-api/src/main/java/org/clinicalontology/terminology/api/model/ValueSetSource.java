package org.clinicalontology.terminology.api.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Associates code systems with a value set source.
 */
public interface ValueSetSource {

    /**
     * Returns the code systems supported by this value set source.
     *
     * @return The code systems supported by this value set source.
     */
    Set<CodeSystem> getSupportedSources();

    /**
     * Returns the value set sources that include the given code system.
     *
     * @param codeSystem The code system.
     * @param sources    The value set sources to filter.
     * @return The value set sources that include the given code system.
     */
    static Set<ValueSetSource> resolve(
        CodeSystem codeSystem,
        ValueSetSource... sources
    ) {
        return Arrays.stream(sources)
            .filter(vss -> vss.getSupportedSources().contains(codeSystem))
            .collect(Collectors.toUnmodifiableSet());
    }

}
