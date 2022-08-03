package org.clinicalontology.terminology.codesystem.core;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.ValueSetSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.clinicalontology.terminology.codesystem.core.CodeSystems.*;

public enum ValueSetSourceEnum implements ValueSetSource {
    RXNAV(RXNORM),
    UMLS(SNOMED_CT, RXNORM, LOINC, NCI, CPT, HCPCS, NDFRT, CVX, ICD9_CM, ICD10_CM, ICD10_PCS),
    VSAC(SNOMED_CT, RXNORM, LOINC, NCI, CPT, HCPCS, NDFRT, CVX, ICD9_CM, ICD10_CM, UCUM),
    /**
     * CIMI
     */
    SOLOR;

    private final Set<CodeSystem> supportedSources;

    public static Set<ValueSetSource> resolve(CodeSystem codeSystem) {
        return ValueSetSource.resolve(codeSystem, ValueSetSourceEnum.values());
    }

    ValueSetSourceEnum(CodeSystem... supportedTerminologies) {
        this.supportedSources = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(supportedTerminologies)));
    }

    public Set<CodeSystem> getSupportedSources() {
        return supportedSources;
    }

}
