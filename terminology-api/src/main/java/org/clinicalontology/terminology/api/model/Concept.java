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
     * @return The code system or namespace for this concept code.
     */
    CodeSystem getCodeSystem();

    /**
     * @return The code system as a string URN.
     */
    @Transient
    default String getCodeSystemAsString() {
        return hasCodeSystem() ? getCodeSystem().getUrn().toString() : "";
    }

    /**
     * @return True if the concept has a code system. False otherwise.
     */
    @Transient
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
    @Transient
    default String getCodeAsString() {
        return hasCode() ? getCode() : "";
    }

    /**
     * @return Returns the code system and code separated by a pipe character.
     */
    @Transient
    default String getSystemAndCode() {
        return getCodeSystemAsString() + "|" + getCodeAsString();
    }

    /**
     * @return True if this concept was assigned a code. False otherwise.
     * Note: a concept must have both a system and a code.
     */
    @Transient
    default boolean hasCode() {
        return StringUtils.isNotEmpty(getCode());
    }

    /**
     * @return The preferred name associated with this concept for this purpose. Usually, the fully specified name.
     */
    String getPreferredName();

    /**
     * Sets the preferred name.
     *
     * @param preferredName The preferred name.
     */
    void setPreferredName(String preferredName);

    /**
     * @return True if the concept is associated with a preferred term.
     */
    @Transient
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
    @Transient
    default boolean hasVersion() {
        return StringUtils.isNotEmpty(getVersion());
    }

    /**
     * A concept must have a code.
     *
     * @return True if the concept has a code (non-null and non-empty).
     */
    @Transient
    default boolean isValidConcept() {
        return hasCode();
    }

    /**
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
            String description) {
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
            Language language);

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
        boolean sameCodeSystem = (!hasCodeSystem() && !rhs.hasCodeSystem()) || (hasCodeSystem() && getCodeSystem().isEqual(rhs.getCodeSystem()));
        return sameCodeSystem && Objects.equals(getCode(), rhs.getCode());
    }

    /**
     * @return Returns a pipe-delimited string consisting of the code system and code in that order.
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
