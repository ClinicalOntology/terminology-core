package org.clinicalontology.terminology.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.ConceptDescription;
import org.clinicalontology.terminology.api.ConceptDescriptionType;

import java.net.URI;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConceptImpl implements Concept {

    private final CodeSystem codeSystem;

    private final String version;

    private final String code;

    private final Set<ConceptDescription> conceptDescriptions;

    /**
     * Creates a new Concept from a system and code, unless either are null or empty, in which case it returns a null.
     *
     * @param system The code system.
     * @param code   The code.
     * @return The newly created Concept or null.
     */
    public static Concept create(
            CodeSystem system,
            String code) {
        return create(system == null ? null : system.getUrnAsString(), code, null);
    }

    /**
     * Creates a new Concept from a system and code, unless either are null or empty, in which case it returns a null.
     *
     * @param system The code system.
     * @param code   The code.
     * @return The newly created Concept or null.
     */
    public static Concept create(
            String system,
            String code) {
        return create(system, code, null);
    }

    /**
     * Creates a new Concept from a system and code, unless either are null or empty, in which case it returns a null.
     *
     * @param system        The code system.
     * @param code          The code.
     * @param preferredName The preferred name.
     * @return The newly created Concept or null.
     */
    public static Concept create(
            String system,
            String code,
            String preferredName) {
        return StringUtils.isEmpty(system) || StringUtils.isEmpty(code) ? null : new ConceptImpl(system, code, preferredName);
    }

    /**
     * For deserialization.
     */
    @SuppressWarnings("unused")
    private ConceptImpl() {
        this.codeSystem = null;
        this.code = null;
        this.version = null;
        this.conceptDescriptions = null;
    }

    public ConceptImpl(
            String system,
            String code) {
        this(system, code, null);
    }

    public ConceptImpl(
            URI system,
            String code) {
        this(system, code, null);
    }

    public ConceptImpl(
            CodeSystem system,
            String code) {
        this(system, code, null);
    }

    public ConceptImpl(
            String system,
            String code,
            String preferredName) {
        this(CodeSystemImpl.create(system), code, preferredName);
    }

    public ConceptImpl(
            URI system,
            String code,
            String preferredName) {
        this(CodeSystemImpl.create(system), code, preferredName);
    }

    public ConceptImpl(
            CodeSystem system,
            String code,
            String preferredName) {
        this(system, code, null, null);
        setPreferredName(preferredName);
    }

    public ConceptImpl(
            CodeSystem system,
            String code,
            String version,
            Set<ConceptDescription> conceptDescriptions) {
        this.codeSystem = system;
        this.code = code;
        this.version = version;
        this.conceptDescriptions = conceptDescriptions == null ? new HashSet<>() : conceptDescriptions;
        Validate.isTrue(isValidConcept(), "Concept reference must have a code system and code.");
    }

    @Override
    public CodeSystem getCodeSystem() {
        return codeSystem;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getPreferredName() {
        return conceptDescriptions.stream()
                .filter(cd -> cd.getDescriptionType() == ConceptDescriptionType.FULLY_SPECIFIED_NAME)
                .findFirst()
                .map(ConceptDescription::getDescription)
                .orElse(null);
    }

    @Override
    public void setPreferredName(String preferredName) {
        conceptDescriptions.removeIf(dx -> dx.getDescriptionType() == ConceptDescriptionType.FULLY_SPECIFIED_NAME);

        if (preferredName != null) {
            conceptDescriptions.add(new ConceptDescriptionImpl(this, preferredName, ConceptDescriptionType.FULLY_SPECIFIED_NAME));
        }
    }

    @Override
    public Set<ConceptDescription> getConceptDescriptions() {
        return conceptDescriptions;
    }

    @Override
    public boolean equals(Object obj) {
        return isEqual(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeSystem().getUrn(), getCode());
    }

    @Override
    public String toString() {
        return "|" + getCodeSystemAsString() + "|" + getCodeAsString() + "|" + getPreferredName() + "|";
    }

}
