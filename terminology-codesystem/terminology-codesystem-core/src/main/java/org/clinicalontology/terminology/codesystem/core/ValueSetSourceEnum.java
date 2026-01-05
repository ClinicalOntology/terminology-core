package org.clinicalontology.terminology.codesystem.core;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.ValueSetSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.clinicalontology.terminology.codesystem.core.CodeSystems.*;

/**
 * Code systems included in standard value set sources.
 */
public enum ValueSetSourceEnum implements ValueSetSource {
    /**
     * <a href="https://lhncbc.nlm.nih.gov/RxNav/">RXNAV</a>
     */
    RXNAV(RXNORM),
    /**
     * <a href="https://www.nlm.nih.gov/research/umls/index.html">UMLS</a>
     */
    UMLS(SNOMED_CT, RXNORM, LOINC, NCI, CPT, HCPCS, NDFRT, CVX, ICD9_CM, ICD10_CM, ICD10_PCS),
    /**
     * <a href="https://vsac.nlm.nih.gov/">VSAC</a>
     */
    VSAC(SNOMED_CT, RXNORM, LOINC, NCI, CPT, HCPCS, NDFRT, CVX, ICD9_CM, ICD10_CM, UCUM),
    /**
     * <a href="https://hl7.org/fhir/us/vitals/CodeSystem-SolorTemporaryCodeSystem.html">SOLOR</a>
     * <p>See also: <a href="https://cimi.hl7.org">CIMI</a>
     */
    SOLOR(SNOMED_CT, RXNORM, LOINC);

    private final Set<CodeSystem> supportedSources;

    /**
     * Create a member with the given code systems.
     *
     * @param supportedSources The code systems included in this value set source.
     */
    ValueSetSourceEnum(CodeSystem... supportedSources) {
        this.supportedSources = Arrays.stream(supportedSources).collect(Collectors.toUnmodifiableSet());
    }

    /**
     * Returns the code systems included in this value set source.
     *
     * @return The code systems included in this value set source.
     */
    @Override
    public Set<CodeSystem> getSupportedSources() {
        return supportedSources;
    }

    /**
     * Returns all value set sources that include the given code system.
     *
     * @param codeSystem The code system.
     * @return All value set sources that include the given code system.
     */
    public static Set<ValueSetSource> resolve(CodeSystem codeSystem) {
        return ValueSetSource.resolve(codeSystem, ValueSetSourceEnum.values());
    }

}
