package org.clinicalontology.terminology.codesystem.core;

import org.clinicalontology.terminology.api.model.CodeSystemEnumerator;
import org.clinicalontology.terminology.api.model.CodeSystemRegistry;
import org.clinicalontology.terminology.impl.model.CodeSystemImpl;

import java.net.URI;
import java.util.List;

/**
 * Derived from <a href="https://vsac.nlm.nih.gov/">VSAC</a>
 */
public final class CodeSystems extends CodeSystemImpl {

    public static final CodeSystems ATC = new CodeSystems("www.whocc.no/atc", "2.16.840.1.113883.6.73");

    public static final CodeSystems CDT = new CodeSystems("www.nlm.nih.gov/research/umls/cdt", "2.16.840.1.113883.6.13");

    public static final CodeSystems CPT = new CodeSystems("www.ama-assn.org/go/cpt", "2.16.840.1.113883.6.12");

    public static final CodeSystems CVX = new CodeSystems("hl7.org/fhir/sid/cvx", "2.16.840.1.113883.12.292");

    public static final CodeSystems DSM5 = new CodeSystems("hl7.org/fhir/sid/dsm5", "2.16.840.1.113883.6.344");

    public static final CodeSystems HCPCS = new CodeSystems(true, "www.cms.gov/Medicare/Coding/HCPCSReleaseCodeSets", "2.16.840.1.113883.6.285");

    public static final CodeSystems ICD9 = new CodeSystems("hl7.org/fhir/sid/icd-9", "2.16.840.1.113883.6.42");

    // So far, this is the only code system that has two OIDS, per VSAC.
    public static final CodeSystems ICD9_CM = new CodeSystems("hl7.org/fhir/sid/icd-9-cm", "2.16.840.1.113883.6.103", "2.16.840.1.113883.6.104");

    public static final CodeSystems ICD9_CM_DIAGNOSIS = new CodeSystems("hl7.org/fhir/sid/icd-9-cm/diagnosis");

    public static final CodeSystems ICD10 = new CodeSystems("hl7.org/fhir/sid/icd-10", "2.16.840.1.113883.6.3");

    public static final CodeSystems ICD10_CM = new CodeSystems("hl7.org/fhir/sid/icd-10-cm", "2.16.840.1.113883.6.90");

    public static final CodeSystems ICD10_CM_DIAGNOSIS = new CodeSystems("hl7.org/fhir/sid/icd-10-cm/diagnosis");

    public static final CodeSystems ICD10_PCS = new CodeSystems("www.icd10data.com/icd10pcs", "2.16.840.1.113883.6.4");

    public static final CodeSystems LOINC = new CodeSystems("loinc.org", "2.16.840.1.113883.6.1");

    public static final CodeSystems MBI = new CodeSystems("hl7.org/fhir/sid/us-mbi", "2.16.840.1.113883.4.927");

    public static final CodeSystems MEDICARE = new CodeSystems("hl7.org/fhir/sid/us-medicare", "2.16.840.1.113883.4.572");

    public static final CodeSystems MEDRT = new CodeSystems("www.nlm.nih.gov/research/umls/MED-RT", "2.16.840.1.113883.6.345");

    public static final CodeSystems MESH = new CodeSystems("terminology.hl7.org/CodeSystem/MSH", "2.16.840.1.113883.6.177");

    public static final CodeSystems NCI = new CodeSystems("ncimeta.nci.nih.gov", "2.16.840.1.113883.3.26.1.1");

    public static final CodeSystems NDC = new CodeSystems("hl7.org/fhir/sid/ndc", "2.16.840.1.113883.6.69");

    public static final CodeSystems NDFRT = new CodeSystems("hl7.org/fhir/ndfrt", "2.16.840.1.113883.3.26.1.5");

    public static final CodeSystems NPI = new CodeSystems("hl7.org/fhir/sid/us-npi", "2.16.840.1.113883.4.6");

    public static final CodeSystems NUCCPT = new CodeSystems("nucc.org/provider-taxonomy", "2.16.840.1.113883.6.101");

    public static final CodeSystems RXNORM = new CodeSystems("www.nlm.nih.gov/research/umls/rxnorm", "2.16.840.1.113883.6.88");

    public static final CodeSystems SNOMED_CT = new CodeSystems("snomed.info/sct", "2.16.840.1.113883.6.96");

    public static final CodeSystems SOP = new CodeSystems("www.nlm.nih.gov/research/umls/sop", "2.16.840.1.113883.3.221.5");

    public static final CodeSystems SSN = new CodeSystems("hl7.org/fhir/sid/us-ssn", "2.16.840.1.113883.4.1");

    public static final CodeSystems UCUM = new CodeSystems("unitsofmeasure.org", "1.3.6.1.4.1.12009.10.3.1");

    public static final CodeSystems UMLS = new CodeSystems("www.nlm.nih.gov/research/umls", "2.16.840.1.113883.6.86");

    public static final CodeSystems UNII = new CodeSystems("fdasis.nlm.nih.gov", "2.16.840.1.113883.4.9");

    private static final CodeSystemEnumerator<CodeSystems> delegate = new CodeSystemEnumerator<>(CodeSystems.class);

    static {
        CodeSystemRegistry.registerCodeSystems(delegate.values());
        CodeSystemRegistry.registerCodeSystemNormalization(ICD9_CM_DIAGNOSIS, ICD9_CM);
        CodeSystemRegistry.registerCodeSystemNormalization(ICD10_CM_DIAGNOSIS, ICD10_CM);
    }

    /**
     * Force instantiation and registration of static class members.
     */
    public static void load() {
    }

    /**
     * @see CodeSystemEnumerator#values()
     */
    public static List<CodeSystems> values() {
        return delegate.values();
    }

    /**
     * @see CodeSystemEnumerator#names()
     */
    public static List<String> names() {
        return delegate.names();
    }

    /**
     * @see CodeSystemEnumerator#valueOf(String)
     */
    public static CodeSystems valueOf(String name) {
        return delegate.valueOf(name);
    }

    /**
     * @see CodeSystemEnumerator#valueOf(String, boolean)
     */
    public static CodeSystems valueOf(
        String name,
        boolean exceptionIfNotFound
    ) {
        return delegate.valueOf(name, exceptionIfNotFound);
    }

    /**
     * Creates a new code system.
     *
     * @param https If true, use https as the prefix, otherwise http.
     * @param urn The URN (less the protocol prefix).
     * @param oids Optional OIDs.
     */
    private CodeSystems(
        boolean https,
        String urn,
        String... oids
    ) {
        super(URI.create("http%s://%s".formatted(https ? "s" : "", urn)), null, null, oids);
    }

    /**
     * Creates a new code system with http as the prefix.
     *
     * @param urn The URN (less the protocol prefix).
     * @param oids Optional OIDs.
     */
    private CodeSystems(
        String urn,
        String... oids
    ) {
        this(false, urn, oids);
    }

    /**
     * @see CodeSystemEnumerator#ordinal(Object)
     */
    public int ordinal() {
        return delegate.ordinal(this);
    }

    /**
     * @see CodeSystemEnumerator#name(Object)
     */
    public String name() {
        return delegate.name(this);
    }

    @Override
    public String getName() {
        return name();
    }

}
