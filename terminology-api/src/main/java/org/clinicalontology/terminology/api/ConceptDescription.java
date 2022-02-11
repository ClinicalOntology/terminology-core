package org.clinicalontology.terminology.api;

/**
 * Represents a concept term such as a name or synonym. A description must apply to a concept and a concept can have
 * multiple descriptions. The description need not be unique as multiple distinct concepts may share the same
 * description - e.g., 'Apache' (a people, an open-source community, a helicopter).
 * TODO: Flesh out for publisher once requirements are clarified
 */
@SuppressWarnings("unused")
public interface ConceptDescription {

    /**
     * @return The language for the description.
     */
    Concept getLanguage(); //TODO: Turn into enum of ISO country codes.

    /**
     * @return The description of the concept.
     */
    String getDescription();

    /**
     * @return The description type.
     */
    Concept getDescriptionType(); // TODO: Turn into enum

    /**
     * @return The concept this description applies to.
     */
    Concept getConcept();

    /**
     * @return The version associated with this description.
     */
    String getVersion();

}
