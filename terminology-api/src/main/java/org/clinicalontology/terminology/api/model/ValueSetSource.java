package org.clinicalontology.terminology.api.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public interface ValueSetSource {

    static Set<ValueSetSource> resolve(CodeSystem codeSystem, ValueSetSource... sources) {
        return Arrays.stream(sources)
            .filter(vss -> vss.getSupportedSources().contains(codeSystem))
            .collect(Collectors.toSet());
    }

    Set<CodeSystem> getSupportedSources();

}
