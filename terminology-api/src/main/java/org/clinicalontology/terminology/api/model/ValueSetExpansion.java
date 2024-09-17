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
@SuppressWarnings("unused")
public interface ValueSetExpansion extends Serializable {

    /**
     * Evaluates the value set expression to generate the set of codes that make up the value set at execution time.
     * Note: value sets can be intentional (e.g., a set inclusion rule) or extensional (an explicit enumeration of concepts)
     *
     * @return The set of concepts that make up this value set at execution time.
     */
    Set<Concept> getExpansion();

    /**
     * @return True if the value set has been evaluated and there is an expansion.
     */
    @Transient
    default boolean hasExpansion() {
        return CollectionUtils.isNotEmpty(getExpansion());
    }

    /**
     * @return A concept that represents the meaning of the set (e.g., concepts for Diabetes Mellitus).
     */
    Concept getSemanticIdentifier();

    /**
     * @return The semantic identifier for the value set.
     */
    ValueSetIdentifier getValueSetIdentifier();

    /**
     * @return The versioned identifier for this value set.
     */
    default URI getVersionedIdentifier() {
        return this.getValueSetIdentifier() != null ? this.getValueSetIdentifier().getVersionedIdentifier() : null;
    }

    /**
     * Tests whether concept is included in the value set.
     *
     * @param concept The concept to search in value set.
     * @return True if the concept exists in the value set. False otherwise.
     */
    @Transient
    default boolean hasConcept(Concept concept) {
        return this.getExpansion().stream()
            .anyMatch(element -> element.isEqual(concept));
    }

    /**
     * Tests whether any member of concept set is included in the value set.
     *
     * @param conceptSet The concept set to search.
     * @return True if any member of the concept set exists in the value set. False otherwise.
     */
    default boolean hasConcept(ConceptSet conceptSet) {
        return conceptSet.getConcepts().stream().anyMatch(this::hasConcept);
    }

    default String asString() {
        return getExpansion().stream()
            .map(Concept::getSystemAndCode)
            .collect(Collectors.joining(","));
    }
}
