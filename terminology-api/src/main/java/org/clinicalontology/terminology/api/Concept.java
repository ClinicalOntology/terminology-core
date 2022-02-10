package org.clinicalontology.terminology.api;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a reference to a concept in a terminology or ontology.
 */
@SuppressWarnings("unused")
public interface Concept extends Serializable {

    /**
     * @return The code system or namespace for this concept code.
     */
    CodeSystem getCodeSystem();

    /**
     * @return The code system as a string URN.
     */
    default String getCodeSystemAsString() {
        return hasCodeSystem() ? getCodeSystem().getUrn().toString() : "";
    }

    /**
     * @return True if the concept has a code system. False otherwise.
     */
    default boolean hasCodeSystem() {
        return getCodeSystem() != null;
    }

    /**
     * @return The code for this concept.
     */
    String getCode();

    /**
     * @return The code for this concept or the empty string if null.
     */
    default String getCodeAsString() {
        return hasCode() ? getCode() : "";
    }

    /**
     * @return Returns the code system and code separated by a pipe character.
     */
    default String getSystemAndCode() {
        return getCodeSystemAsString() + "|" + getCodeAsString();
    }

    /**
     * @return True if this concept was assigned a code. False otherwise.
     * Note: a concept must have both a system and a code.
     */
    default boolean hasCode() {
        return StringUtils.isNotEmpty(getCode());
    }

    /**
     * @return The preferred name associated with this concept for this purpose. Usually, the English fully specified name.
     */
    String getPreferredName();

    /**
     * @return True if the concept is associated with a preferred term.
     */
    default boolean hasPreferredName() {
        return StringUtils.isNotEmpty(getPreferredName());
    }

    /**
     * @return The version of this concept.
     */
    String getVersion();

    /**
     * @return True if this concept has a version. False otherwise.
     */
    default boolean hasVersion() {
        return StringUtils.isNotEmpty(getVersion());
    }

    /**
     * A concept must have a code system and a code. The codesystem generally ensures the uniqueness of the code
     * unless the namespace if further subdivided.
     *
     * @return True if the concept has both a valid namespace and code (non-null and non-empty).
     */
    default boolean isValidConcept() {
        return hasCodeSystem() && hasCode();
    }

    /**
     * @return The set of concept descriptions associated with the concept.
     */
    Set<ConceptDescription> getConceptDescriptions();

    /**
     * Returns true if this and the target are equal.  Each interface implementation's "equals" method should delegate
     * to this.  Note that the "equals" method of enums implementing this interface is set to final, so calling this
     * method should be the preferred way when enums are involved.
     *
     * @param target The object to compare.
     * @return True if equal.
     */
    default boolean isEqual(Object target) {
        if (this == target) return true;
        if (!(target instanceof Concept)) return false;
        Concept rhs = (Concept) target;
        return getCodeSystem().isEqual(rhs.getCodeSystem()) && Objects.equals(getCode(), rhs.getCode());
    }

}
