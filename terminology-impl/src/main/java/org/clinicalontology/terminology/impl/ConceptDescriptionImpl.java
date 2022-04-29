package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.ConceptDescription;
import org.clinicalontology.terminology.api.DescriptionType;
import org.clinicalontology.terminology.api.Language;

import java.util.Objects;

public class ConceptDescriptionImpl implements ConceptDescription {

    private final Language language;

    private final String description;

    private final DescriptionType descriptionType;

    private final Concept concept;

    private final String version;

    public ConceptDescriptionImpl(
            Concept concept,
            String description,
            DescriptionType descriptionType) {
        this(concept, description, descriptionType, null, null);
    }

    public ConceptDescriptionImpl(
            Concept concept,
            String description,
            DescriptionType descriptionType,
            Language language,
            String version) {
        this.concept = concept;
        this.description = description;
        this.descriptionType = descriptionType;
        this.language = language;
        this.version = version;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public DescriptionType getDescriptionType() {
        return descriptionType;
    }

    @Override
    public Concept getConcept() {
        return concept;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConceptDescription) {
            ConceptDescription other = (ConceptDescription) obj;
            return getLanguage() == other.getLanguage()
                    && getDescriptionType() == other.getDescriptionType()
                    && Objects.equals(other.getDescription(), getDescription())
                    && getConcept().isEqual(other.getConcept());
        } else {
            return false;
        }
    }

}
