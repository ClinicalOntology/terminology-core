package org.clinicalontology.terminology.api.model;

/**
 * The semantic key of an entity.  A semantic key is a concept set that represents the meaning of an entity.
 */
public interface SemanticKey {

    /**
     * Returns the semantic key.
     *
     * @return The semantic key.
     */
    ConceptSet getSemanticKey();

}
