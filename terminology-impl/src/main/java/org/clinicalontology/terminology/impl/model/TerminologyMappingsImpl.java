package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.TerminologyMapping;
import org.clinicalontology.terminology.api.model.TerminologyMappings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link TerminologyMappings}.
 */
public class TerminologyMappingsImpl implements TerminologyMappings {

    private final List<TerminologyMapping> mappings = new ArrayList<>();

    @Override
    public void add(TerminologyMapping... mapping) {
        Collections.addAll(mappings, mapping);
    }

    @Override
    public List<TerminologyMapping> getMappings() {
        return mappings;
    }

    @Override
    public TerminologyMapping findFirstMatch(CodeSystem targetCodeSystem) {
        return mappings.stream()
            .filter(m -> m.getTarget().getCodeSystem().equals(targetCodeSystem))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<TerminologyMapping> findMatches(CodeSystem targetCodeSystem) {
        return mappings.stream()
            .filter(m -> m.getTarget().getCodeSystem().equals(targetCodeSystem))
            .collect(Collectors.toList());
    }

}
