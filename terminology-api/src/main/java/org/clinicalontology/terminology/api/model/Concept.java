package org.clinicalontology.terminology.api.model;

import org.apache.commons.lang3.StringUtils;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a reference to a concept in a terminology or ontology.
 */
@SuppressWarnings("unused")
public interface Concept extends Serializable {

    /**
     * Returns the concept identifier.
     *
     * @return The code system or namespace for this concept code.
     */
    CodeSystem getCodeSystem();

    /**
     * Returns the code system as a string URN.
     *
     * @return The code system as a string URN.
     */
    @Transient
    default String getCodeSystemAsString() {
        return hasCodeSystem() ? getCodeSystem().getUrn().toString() : "";
    }

    /**
     * Returns true if the concept has a code system.
     *
     * @return True if the concept has a code system. False otherwise.
     */
    @Transient
    default boolean hasCodeSystem() {
        return getCodeSystem() != null;
    }

    /**
     * Returns the code for this concept.
     *
     * @return The code for this concept.
     */
    String getCode();

    /**
     * Returns the code for this concept or the empty string if null.
     *
     * @return The code for this concept or the empty string if null.
     */
    @Transient
    default String getCodeAsString() {
        return hasCode() ? getCode() : "";
    }

    /**
     * Returns the code system and code separated by a pipe character.
     *
     * @return The code system and code separated by a pipe character.
     */
    @Transient
    default String getSystemAndCode() {
        return getCodeSystemAsString() + "|" + getCodeAsString();
    }

    /**
     * Returns true if this concept was assigned a code.
     *
     * @return True if this concept was assigned a code. False otherwise.
     *     Note: a concept must have both a system and a code.
     */
    @Transient
    default boolean hasCode() {
        return StringUtils.isNotEmpty(getCode());
    }

    /**
     * Returns the preferred name associated with this concept for this purpose - usually, the fully specified name.
     *
     * @return The preferred name associated with this concept for this purpose - usually, the fully specified name.
     */
    String getPreferredName();

    /**
     * Sets the preferred name.
     *
     * @param preferredName The preferred name.
     */
    void setPreferredName(String preferredName);

    /**
     * Returns true if the concept is associated with a preferred term.
     *
     * @return True if the concept is associated with a preferred term.
     */
    @Transient
    default boolean hasPreferredName() {
        return StringUtils.isNotEmpty(getPreferredName());
    }

    /**
     * Returns the version of this concept.
     *
     * @return The version of this concept.
     */
    String getVersion();

    /**
     * Returns true if this concept has a version.
     *
     * @return True if this concept has a version. False otherwise.
     */
    @Transient
    default boolean hasVersion() {
        return StringUtils.isNotEmpty(getVersion());
    }

    /**
     * Returns true if the concept has a code (non-null and non-empty).
     *
     * @return True if the concept has a code (non-null and non-empty).
     */
    @Transient
    default boolean isValidConcept() {
        return hasCode();
    }

    /**
     * Returns an immutable set of concept descriptions associated with the concept.
     *
     * @return An immutable set of concept descriptions associated with the concept.
     */
    Set<ConceptDescription> getConceptDescriptions();

    /**
     * Returns all concept descriptions matching the specified type.
     *
     * @param type The description type.
     * @return The matching concept descriptions (never null).
     */
    default Set<ConceptDescription> getConceptDescriptions(DescriptionType type) {
        return getConceptDescriptions().stream()
            .filter(cd -> cd.getDescriptionType() == type)
            .collect(Collectors.toSet());
    }

    /**
     * Returns the first concept description matching the specified type.
     *
     * @param type The description type.
     * @return The matching concept description (possibly null).
     */
    default ConceptDescription getConceptDescription(DescriptionType type) {
        return getConceptDescriptions().stream()
            .filter(cd -> cd.getDescriptionType() == type)
            .findFirst()
            .orElse(null);
    }

    /**
     * Returns the text description of the first concept description matching the specified type.
     *
     * @param type The description type.
     * @return The description text (possibly null).
     */
    default String getConceptDescriptionText(DescriptionType type) {
        ConceptDescription conceptDescription = getConceptDescription(type);
        return conceptDescription == null ? null : conceptDescription.getDescription();
    }

    /**
     * Returns true if a concept description of the specified type exists.
     *
     * @param type The description type.
     * @return True if a concept description of the specified type exists.
     */
    default boolean hasConceptDescription(DescriptionType type) {
        return getConceptDescription(type) != null;
    }

    /**
     * Adds a concept description using the default language.
     *
     * @param type        The description type.
     * @param description The description.
     * @return The newly created concept description.
     */
    default ConceptDescription addConceptDescription(
        DescriptionType type,
        String description
    ) {
        return addConceptDescription(type, description, Language.getDefault());
    }

    /**
     * Adds a concept description.
     *
     * @param type        The description type.
     * @param description The description.
     * @param language    The language of the description.
     * @return The newly created concept description.
     */
    ConceptDescription addConceptDescription(
        DescriptionType type,
        String description,
        Language language
    );

    /**
     * Adds concept descriptions.
     *
     * @param conceptDescriptions The concept descriptions to add.
     */
    void addConceptDescriptions(ConceptDescription... conceptDescriptions);

    /**
     * Returns displayable text for the concept.  Searches for a non-blank value from, in order, the
     * preferred name, a concept definition, a concept synonym, the concept code.
     *
     * @return The display text.
     */
    @Transient
    default String getDisplayText() {
        return getDisplayText(false);
    }

    /**
     * Returns displayable text for the concept.  Searches for a non-blank value from, in order, the
     * preferred name, a concept definition, a concept synonym, the concept code.
     *
     * @param excludeCode If true, don't consider the concept's code as a last resort.
     * @return The display text.
     */
    default String getDisplayText(boolean excludeCode) {
        String text = StringUtils.firstNonBlank(getPreferredName(), getConceptDescriptionText(DescriptionType.DEFINITION),
            getConceptDescriptionText(DescriptionType.SYNONYM), excludeCode ? null : getCode());
        return text == null ? "" : text;
    }

    /**
     * An alias associated with this concept.
     *
     * @return The concept alias.
     */
    String getAlias();

    /**
     * Sets an alias associated with this concept.
     *
     * @param alias An alias to associate with this concept.
     */
    void setAlias(String alias);

    /**
     * Returns true if this and the target are equal.  Each interface implementation's "equals" method should delegate
     * to this.  Note that the "equals" method of enums implementing this interface is set to final, so calling this
     * method should be the preferred way when enums are involved.
     *
     * @param target The object to compare.
     * @return True if equal.
     */
    default boolean isEqual(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof Concept rhs)) {
            return false;
        }
        boolean sameCodeSystem = (!hasCodeSystem() && !rhs.hasCodeSystem()) || (hasCodeSystem() && getCodeSystem().isEqual(rhs.getCodeSystem()));
        return sameCodeSystem && Objects.equals(getCode(), rhs.getCode());
    }

    /**
     * Returns a pipe-delimited string consisting of the code system and code in that order.
     * @return The pipe-delimited string.
     */
    @Transient
    default String asString() {
        return asString(false);
    }

    /**
     * Returns a pipe-delimited string consisting of the code system, code, and optionally the preferred name in that order.
     *
     * @param includePreferredName If true, include the preferred name.
     * @return The pipe-delimited string.
     */
    default String asString(boolean includePreferredName) {
        return getCodeSystemAsString() + "|" + getCodeAsString() + (includePreferredName ? "|" : "")
            + (includePreferredName && hasPreferredName() ? getPreferredName() : "");
    }

}
