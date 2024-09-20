package org.clinicalontology.terminology.api.service;

import org.clinicalontology.terminology.api.model.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Logical interface exposed by a terminology service.
 */
public interface TerminologyService {

    //--------------- Concepts ---------------

    /**
     * @param concept The concept whose existence in the terminology repository we are determining.
     * @return True if the concept exists in the given terminology repository. False otherwise.
     */
    boolean isValidConcept(Concept concept);

    //--------------- Terminology Mappings ---------------

    /**
     * Method returns all concept mappings that involve this concept as the source of the mapping.
     *
     * @param source The concept that is at the source of the mapping (RHS).
     * @return The set of mappings having the concept at the source of the mapping.
     */
    TerminologyMappings getMappingsForConcept(Concept source);

    /**
     * Method returns all concept mappings within the specified category that involve this concept as
     * the source of the mapping.
     *
     * @param source   The concept that is at the source of the mapping (RHS).
     * @param category The category whose mappings are sought.
     * @return The set of mappings having the concept at the source of the mapping.
     */
    TerminologyMappings getMappingsForConcept(
        Concept source,
        Concept category);

    /**
     * Method returns all concept mappings from the source concept and target concepts within the specified
     * code system.
     *
     * @param source           The concept that is at the source of the mapping (RHS).
     * @param targetCodeSystem The code system of the target concepts.
     * @return The set of mappings having the concept at the source of the mapping.
     */
    TerminologyMappings getMappingsForConcept(
        Concept source,
        String targetCodeSystem);

    //--------------- Value Sets ---------------

    /**
     * @param valueSetIdentifier The value set whose existence in the terminology repository we are determining.
     * @return True if the value set exists in the given terminology repository. False otherwise.
     */
    boolean isValidValueSet(ValueSetIdentifier valueSetIdentifier);

    /**
     * Method tests whether a concept reference is an element of a value set.
     *
     * @param valueSetIdentifier A value set identifier.
     * @param concept            The concept whose inclusion in a value set we are verifying.
     * @return True if the concept is part of the value set. False otherwise.
     */
    boolean isMemberOfValueSet(
        ValueSetIdentifier valueSetIdentifier,
        Concept concept);

    /**
     * @param valueSetIdentifier The identifier of the value set whose expansion we are requesting.
     * @return The expansion for the given value set.
     */
    ValueSetExpansion getValueSetExpansion(ValueSetIdentifier valueSetIdentifier);

    /**
     * @param valueSetIdentifier The identifier of the value set whose expansion we are requesting.
     * @return A list of concepts in the form codeSystem|code(,codeSystem|code)*
     */
    default String getValueSetExpansionAsString(ValueSetIdentifier valueSetIdentifier) {
        return getValueSetExpansion(valueSetIdentifier).asString();
    }

    //--------------- Concepts ---------------

    /**
     * Returns a fully hydrated concept from the concept store.  If one is not available,
     * should return a minimal concept with the given code system and code.
     *
     * @param codeSystem The code system.
     * @param code The concept code.
     * @return The concept.
     */
    Concept getConcept(String codeSystem, String code);

    /**
     * Returns a fully hydrated concept from the concept store.  If one is not available, should
     * return the original concept.
     *
     * @param concept The concept.
     * @return The concept.
     */
    default Concept getConcept(Concept concept) {
        return getConcept(concept.getCodeSystemAsString(), concept.getCode());
    }

    /**
     * @param concept The concept whose descriptions are sought.
     * @return The set of descriptions associated with the concept in the default language.
     */
    default Set<ConceptDescription> getConceptDescriptions(Concept concept) {
        return getConceptDescriptions(concept, Language.getDefault());
    }

    /**
     * @param concept  The concept whose descriptions are sought.
     * @param language The desired language.
     * @return The set of descriptions associated with the concept in the specified language.
     */
    default Set<ConceptDescription> getConceptDescriptions(
        Concept concept,
        Language language
    ) {
        return getConcept(concept).getConceptDescriptions().stream()
            .filter(dx -> language == null || language.equals(dx.getLanguage()))
            .collect(Collectors.toSet());
    }

    /**
     * @param concept         The concept whose descriptions are sought.
     * @param descriptionType The description type.
     * @return The set of descriptions associated with the concept in the specified language.
     */
    default Set<ConceptDescription> getConceptDescriptions(
        Concept concept,
        DescriptionType descriptionType
    ) {
        return getConceptDescriptions(concept, descriptionType, Language.getDefault());
    }

    /**
     * @param concept  The concept whose descriptions are sought.
     * @param descriptionType The description type.
     * @param language The desired language.
     * @return The set of descriptions associated with the concept in the specified language.
     */
    default Set<ConceptDescription> getConceptDescriptions(
        Concept concept,
        DescriptionType descriptionType,
        Language language
    ) {
        return getConceptDescriptions(concept, language).stream()
            .filter(dx -> descriptionType == null || dx.getDescriptionType() == descriptionType)
            .collect(Collectors.toSet());
    }

    /**
     * @param concept         The concept.
     * @param descriptionType The description type.
     * @return All descriptions of the given type.
     */
    default List<String> getConceptDescriptionText(
        Concept concept,
        DescriptionType descriptionType
    ) {
        return getConceptDescriptionText(concept, descriptionType, Language.getDefault());
    }

    /**
     * @param concept         The concept.
     * @param descriptionType The description type.
     * @param language        The language
     * @return All descriptions of the given type.
     */
    default List<String> getConceptDescriptionText(
        Concept concept,
        DescriptionType descriptionType,
        Language language
    ) {
        return descriptionsAsText(getConceptDescriptions(concept, descriptionType, language));
    }

    /**
     * @param concept The concept whose fully specified name is desired.
     * @return The fully specified name for the concept.
     */
    default String getConceptFSN(Concept concept) {
        return getFirst(getConceptDescriptionText(concept, DescriptionType.FULLY_SPECIFIED_NAME, null));
    }

    /**
     * @param concept The concept whose fully specified name is desired.
     * @return The synonyms for the concept.
     */
    default List<String> getConceptSynonyms(Concept concept) {
        return getConceptSynonyms(concept, Language.getDefault());
    }

    /**
     * @param concept  The concept whose fully specified name is desired.
     * @param language The language.
     * @return The synonyms for the concept.
     */
    default List<String> getConceptSynonyms(
        Concept concept,
        Language language
    ) {
        return getConceptDescriptionText(concept, DescriptionType.SYNONYM, language);
    }

    /**
     * @param concept The concept whose fully specified name is desired.
     * @return The definition for the concept.
     */
    default String getConceptDefinition(Concept concept) {
        return getConceptDefinition(concept, Language.getDefault());
    }

    /**
     * @param concept  The concept whose fully specified name is desired.
     * @param language The language.
     * @return The definition for the concept.
     */
    default String getConceptDefinition(
        Concept concept,
        Language language
    ) {
        return getFirst(getConceptDescriptionText(concept, DescriptionType.DEFINITION, language));
    }

    /**
     * Method supports registration of user-defined value sets
     *
     * @param valueSetExpansion The value set expansion to register manually.
     * @param allowOverrides    If true, value set with override existing entry with the same value set identifier.
     */
    void registerExternalValueSet(ValueSetExpansion valueSetExpansion, boolean allowOverrides);

    /**
     * A terminology service may optionally implement this method, typically to refresh any caches.
     */
    default void refresh() {
    }

    private static List<String> descriptionsAsText(Collection<ConceptDescription> descriptions) {
        return descriptions.stream()
            .map(ConceptDescription::getDescription)
            .toList();
    }

    private static <T> T getFirst(List<T> list) {
        return list == null || list.isEmpty() ? null : list.get(0);
    }
}
