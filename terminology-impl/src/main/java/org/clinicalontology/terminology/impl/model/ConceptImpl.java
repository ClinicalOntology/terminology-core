package org.clinicalontology.terminology.impl.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.model.*;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ConceptImpl implements Concept {

    private final CodeSystem codeSystem;

    private final String version;

    private final String code;

    private final Set<ConceptDescription> conceptDescriptions = new LinkedHashSet<>();

    private String preferredName;

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
            String preferredName,
            String version,
            ConceptDescription... conceptDescriptions) {
        this.codeSystem = system;
        this.code = code;
        this.preferredName = preferredName;
        this.version = version;
        Validate.isTrue(isValidConcept(), "Concept reference must have a code.");
        addConceptDescriptions(conceptDescriptions);
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
        return preferredName;
    }

    @Override
    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    @Override
    public Set<ConceptDescription> getConceptDescriptions() {
        return conceptDescriptions;
    }

    @Override
    public ConceptDescription addConceptDescription(
            DescriptionType type,
            String description,
            Language language) {
        ConceptDescription conceptDescription = new ConceptDescriptionImpl(description, type, language, null);
        addConceptDescriptions(conceptDescription);
        return conceptDescription;
    }

    @Override
    public void addConceptDescriptions(ConceptDescription... conceptDescriptions) {
        Collections.addAll(this.conceptDescriptions, conceptDescriptions);
    }

    @Override
    public boolean equals(Object obj) {
        return isEqual(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasCodeSystem() ? getCodeSystem().getUrn() : null, getCode());
    }

    @Override
    public String toString() {
        return "|" + asString(true) + "|";
    }

}
