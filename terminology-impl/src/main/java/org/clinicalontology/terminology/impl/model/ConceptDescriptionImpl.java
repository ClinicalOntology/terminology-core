package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.ConceptDescription;
import org.clinicalontology.terminology.api.model.DescriptionType;
import org.clinicalontology.terminology.api.model.Language;

import java.util.Objects;

public class ConceptDescriptionImpl implements ConceptDescription {

    private final Language language;

    private final String description;

    private final DescriptionType descriptionType;

    private final String version;

    /**
     * For deserialization.
     */
    @SuppressWarnings("unused")
    private ConceptDescriptionImpl() {
        this.language = null;
        this.description = null;
        this.descriptionType = null;
        this.version = null;
    }

    public ConceptDescriptionImpl(
            String description,
            DescriptionType descriptionType) {
        this(description, descriptionType, null, null);
    }

    public ConceptDescriptionImpl(
            String description,
            DescriptionType descriptionType,
            Language language,
            String version) {
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
    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConceptDescription other) {
            return getLanguage() == other.getLanguage()
                    && getDescriptionType() == other.getDescriptionType()
                    && Objects.equals(other.getDescription(), getDescription());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return description;
    }
}
