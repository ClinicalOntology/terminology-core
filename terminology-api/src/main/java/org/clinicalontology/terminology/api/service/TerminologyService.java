package org.clinicalontology.terminology.api.service;

import org.clinicalontology.terminology.api.model.*;

import java.util.List;
import java.util.Set;

/**
 * Logical interface exposed by a terminology service.
 */
public interface TerminologyService {

    /**
     * Method tests whether a concept reference is an element of a value set.
     *
     * @param valueSetIdentifier A value set identifier.
     * @param conceptReference   The concept whose inclusion in a value set we are verifying.
     * @return True if the concept is part of the value set. False otherwise.
     */
    boolean isMemberOfConceptSetExpansion(
            ValueSetIdentifier valueSetIdentifier,
            Concept conceptReference);

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

    /**
     * @param concept The concept whose existence in the terminology repository we are determining.
     * @return True if the concept exists in the given terminology repository. False otherwise.
     */
    boolean isValidConcept(Concept concept);

    /**
     * @param valueSetIdentifier The value set whose existence in the terminology repository we are determining.
     * @return True if the value set exists in the given terminology repository. False otherwise.
     */
    boolean isValidConceptSet(ValueSetIdentifier valueSetIdentifier);

    /**
     * @param valueSetIdentifier The identifier of the value set whose expansion we are requesting.
     * @return The expansion for the given value set.
     */
    ValueSetExpansion getConceptSetExpansion(ValueSetIdentifier valueSetIdentifier);

    /**
     * @param valueSetIdentifier The identifier of the value set whose expansion we are requesting.
     * @return A list of concepts in the form codeSystem|code(,codeSystem|code)*
     */
    String getConceptSetExpansionAsString(ValueSetIdentifier valueSetIdentifier);

    /**
     * @param concept The concept whose descriptions are sought.
     * @return The set of descriptions associated with the concept in the default language.
     */
    default Set<ConceptDescription> getDescriptions(Concept concept) {
        return getDescriptions(concept, Language.getDefault());
    }

    /**
     * @param concept  The concept whose descriptions are sought.
     * @param language The desired language.
     * @return The set of descriptions associated with the concept in the specified language.
     */
    Set<ConceptDescription> getDescriptions(
            Concept concept,
            Language language);

    /**
     * @param concept         The concept.
     * @param descriptionType The description type.
     * @return All descriptions of the given type.
     */
    default List<String> getConceptDescriptions(
            Concept concept,
            DescriptionType descriptionType) {
        return getConceptDescriptions(concept, descriptionType, Language.getDefault());
    }

    /**
     * @param concept         The concept.
     * @param descriptionType The description type.
     * @param language        The language
     * @return All descriptions of the given type.
     */
    List<String> getConceptDescriptions(
            Concept concept,
            DescriptionType descriptionType,
            Language language);

    /**
     * @param concept The concept whose fully specified name is desired.
     * @return The fully specified name for the concept.
     */
    default String getConceptFSN(Concept concept) {
        return getConceptFSN(concept, Language.getDefault());
    }

    /**
     * @param concept  The concept whose fully specified name is desired.
     * @param language The language.
     * @return The fully specified name for the concept.
     */
    String getConceptFSN(
            Concept concept,
            Language language);

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
    String getConceptDefinition(
            Concept concept,
            Language language);

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
    List<String> getConceptSynonyms(
            Concept concept,
            Language language);

}
