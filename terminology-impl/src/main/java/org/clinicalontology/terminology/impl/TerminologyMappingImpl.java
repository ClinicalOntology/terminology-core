package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.TerminologyMapping;
import org.clinicalontology.terminology.api.TerminologyMappingType;

public class TerminologyMappingImpl implements TerminologyMapping {

    private final TerminologyMappingType type;

    private final Concept source;

    private final Concept target;

    public TerminologyMappingImpl(
            TerminologyMappingType type,
            Concept source,
            Concept target) {
        this.type = type;
        this.source = source;
        this.target = target;
    }

    @Override
    public TerminologyMappingType getType() {
        return type;
    }

    @Override
    public Concept getSource() {
        return source;
    }

    @Override
    public Concept getTarget() {
        return target;
    }

}
