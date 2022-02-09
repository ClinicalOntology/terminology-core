package org.clinicalontology.terminology.api;

import java.io.Serializable;

/**
 * Class represents a mapping between two concepts (LHS to RHS) - generally concepts in different terminologies
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

}
