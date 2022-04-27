package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.TerminologyMapping;
import org.clinicalontology.terminology.api.TerminologyMappingType;

public class TerminologyMappingImpl implements TerminologyMapping {

    private final TerminologyMappingType type;

    private final Concept source;

    private final Concept target;

    private final Concept category;

    /**
     * Builds a mapping with the specified source and target with a mapping type of equivalent and no category.
     *
     * @param source The source concept.
     * @param target The target concept.
     */
    public TerminologyMappingImpl(
            Concept source,
            Concept target) {
        this(TerminologyMappingType.TARGET_EQUIVALENT, source, target, null);
    }

    /**
     * Builds a mapping with the specified source, target, and mapping type and no category.
     *
     * @param type   The mapping type.
     * @param source The source concept.
     * @param target The target concept.
     */
    public TerminologyMappingImpl(
            TerminologyMappingType type,
            Concept source,
            Concept target) {
        this(type, source, target, null);
    }

    /**
     * Builds a mapping with the specified source, target, mapping type, and category.
     *
     * @param type     The mapping type.
     * @param source   The source concept.
     * @param target   The target concept.
     * @param category The category of the mapping.
     */
    public TerminologyMappingImpl(
            TerminologyMappingType type,
            Concept source,
            Concept target,
            Concept category) {
        this.type = type;
        this.source = source;
        this.target = target;
        this.category = category;
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

    @Override
    public Concept getCategory() {
        return category;
    }

}
