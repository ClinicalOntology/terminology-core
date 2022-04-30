package org.clinicalontology.terminology.api;

import java.io.Serializable;

/**
 * Represents a mapping between two concepts (LHS to RHS) - typically concepts in different terminologies.
 */
public interface TerminologyMapping extends Serializable {

    /**
     * @return The mapping type - e.g., equivalent, broader, narrower, partial.
     */
    TerminologyMappingType getType();

    /**
     * @return The LHS concept.
     */
    Concept getSource();

    /**
     * @return The RHS concept.
     */
    Concept getTarget();

    /**
     * @return The category of the mapping.
     */
    Concept getCategory();

    /**
     * @return True if the mapping has an associated category.
     */
    default boolean hasCategory() {
        return getCategory() != null;
    }
}
