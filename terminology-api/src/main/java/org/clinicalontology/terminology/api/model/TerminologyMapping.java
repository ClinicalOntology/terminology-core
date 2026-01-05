package org.clinicalontology.terminology.api.model;

import java.beans.Transient;
import java.io.Serializable;

/**
 * Represents a mapping between two concepts (LHS to RHS) - typically concepts in different terminologies.
 */
public interface TerminologyMapping extends Serializable {

    /**
     * Returns the mapping type.
     *
     * @return The mapping type - e.g., equivalent, broader, narrower, partial.
     */
    TerminologyMappingType getType();

    /**
     * Returns the LHS concept.
     *
     * @return The LHS concept.
     */
    Concept getSource();

    /**
     * Returns the RHS concept.
     *
     * @return The RHS concept.
     */
    Concept getTarget();

    /**
     * Returns the category of the mapping.
     *
     * @return The category of the mapping.
     */
    Concept getCategory();

    /**
     * Returns true if the mapping has an associated category.
     *
     * @return True if the mapping has an associated category.
     */
    @Transient
    default boolean hasCategory() {
        return getCategory() != null;
    }
}
