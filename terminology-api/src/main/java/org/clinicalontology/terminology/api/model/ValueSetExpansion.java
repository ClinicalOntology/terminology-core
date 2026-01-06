package org.clinicalontology.terminology.api.model;

import org.apache.commons.collections4.CollectionUtils;

import java.beans.Transient;
import java.io.Serializable;
import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A value set expansion is generated after evaluating a value set expression (whether intentional or extensional).
 * It is a collection of unique concept references.
 */
public interface ValueSetExpansion extends SemanticKey, Serializable {

    /**
     * Evaluates the value set expression to generate the set of codes that make up the value set at execution time.
     * Note: value sets can be intentional (e.g., a set inclusion rule) or extensional (an explicit enumeration of concepts)
     *
     * @return The set of concepts that make up this value set at execution time.
     */
    Set<Concept> getExpansion();

    /**
     * Returns true if the value set has been evaluated and there is an expansion.
     *
     * @return True if the value set has been evaluated and there is an expansion.
     */
    @Transient
    default boolean hasExpansion() {
        return CollectionUtils.isNotEmpty(getExpansion());
    }

    /**
     * Returns the semantic key for the value set.  The default implementation returns null.  Override to
     * provide a semantic key.
     *
     * @return A concept set that represents the meaning of the set (e.g., concepts for Diabetes Mellitus).
     */
    default ConceptSet getSemanticKey() {
        return null;
    }

    /**
     * Returns the identifier for the value set.
     *
     * @return The identifier for the value set.
     */
    ValueSetIdentifier getValueSetIdentifier();

    /**
     * Returns the versioned identifier for this value set.
     *
     * @return The versioned identifier for this value set.
     */
    default URI getVersionedIdentifier() {
        return this.getValueSetIdentifier() != null ? this.getValueSetIdentifier().getVersionedId() : null;
    }

    /**
     * Tests whether the concept is included in the value set.
     *
     * @param concept The concept to search in the value set.
     * @return True if the concept exists in the value set. False otherwise.
     */
    @Transient
    default boolean hasConcept(Concept concept) {
        return this.getExpansion().stream()
            .anyMatch(element -> element.isEqual(concept));
    }

    /**
     * Tests whether any member of the concept set is included in the value set.
     *
     * @param conceptSet The concept set to search.
     * @return True if any member of the concept set exists in the value set. False otherwise.
     */
    default boolean hasConcept(ConceptSet conceptSet) {
        return conceptSet.getConcepts().stream().anyMatch(this::hasConcept);
    }

    /**
     * Formats the expansion as a sorted, comma-delimited list of system and code pairs.
     *
     * @return A comma-delimited list of system and code pairs.
     */
    default String asString() {
        return getExpansion().stream()
            .map(Concept::getSystemAndCode)
            .sorted()
            .collect(Collectors.joining(","));
    }
}
