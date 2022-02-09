package org.clinicalontology.terminology.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.ConceptDescription;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class ConceptImpl implements Concept {

    private final CodeSystem codeSystem;

    private final String version;

    private final String code;

    private final Set<ConceptDescription> descriptions;

    private String preferredName; //Needed to relax this from final to support Phil's specializations.

    private static CodeSystem createCodeSystem(String system) {
        return StringUtils.isEmpty(system) ? null : new CodeSystemImpl(URI.create(system), null, null);
    }

    private static CodeSystem createCodeSystem(URI system) {
        return system == null ? null : new CodeSystemImpl(system, null, null);
    }

    /**
     * For deserialization.
     */
    @SuppressWarnings("unused")
    private ConceptImpl() {
        this.codeSystem = null;
        this.code = null;
        this.preferredName = null;
        this.version = null;
        this.descriptions = null;
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
        this(createCodeSystem(system), code, preferredName);
    }

    public ConceptImpl(
            URI system,
            String code,
            String preferredName) {
        this(createCodeSystem(system), code, preferredName);
    }

    public ConceptImpl(
            CodeSystem system,
            String code,
            String preferredName) {
        this(system, code, preferredName, null, null);
    }

    public ConceptImpl(
            CodeSystem system,
            String code,
            String preferredName,
            String version,
            Set<ConceptDescription> descriptions) {
        this.codeSystem = system;
        this.code = code;
        this.preferredName = preferredName;
        this.version = version;
        this.descriptions = descriptions == null ? Collections.emptySet() : descriptions;
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
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    @Override
    public Set<ConceptDescription> getConceptDescriptions() {
        return descriptions;
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
