package org.clinicalontology.terminology.api;

/**
 * Enumeration representing the type of mapping between a source and target concept
 */
public enum TerminologyMappingType {

    /**
     * Target concept is broader than source (e.g., Beta-blocker is broader than Metoprolol). Generally this means that the source is a subset/element of the target.
     */
    TARGET_BROADER,

    /**
     * Target concept is narrower than source (e.g., Metoprolol is narrower than Beta-blocker). Generally this means the target is a subset/element of the source.
     */
    TARGET_NARROWER,

    /**
     * Source and target concept semantics overlap but are not exactly the same (e.g., need example)
     */
    TARGET_INTERSECTS,

    /**
     * Concepts are semantically equivalent
     */
    TARGET_EQUIVALENT
}
