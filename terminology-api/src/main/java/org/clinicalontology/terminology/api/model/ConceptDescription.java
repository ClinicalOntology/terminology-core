package org.clinicalontology.terminology.api.model;

import java.io.Serializable;

/**
 * Represents a concept term such as a name or synonym. A description must apply to a concept and a concept can have
 * multiple descriptions. The description need not be unique as multiple distinct concepts may share the same
 * description - e.g., 'Apache' (a people, an open-source community, a helicopter).
 * TODO: Flesh out for publisher once requirements are clarified
 */
public interface ConceptDescription extends Serializable {

    /**
     * @return The language for the description.
     */
    Language getLanguage();

    /**
     * @return The description of the concept.
     */
    String getDescription();

    /**
     * @return The description type.
     */
    DescriptionType getDescriptionType();

    /**
     * @return The version associated with this description.
     */
    String getVersion();

}
