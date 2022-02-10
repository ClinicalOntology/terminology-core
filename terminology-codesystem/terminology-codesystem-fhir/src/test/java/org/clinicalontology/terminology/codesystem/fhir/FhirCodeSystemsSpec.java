package org.clinicalontology.terminology.codesystem.fhir;

import org.junit.Assert;
import org.junit.Test;

public class FhirCodeSystemsSpec {

    private static final String V2_LEGACY = "http://hl7.org/fhir/v2/0112";

    private static final String V2_NEW = "http://terminology.hl7.org/CodeSystem/v2-0112";

    private static final String V3_LEGACY = "http://hl7.org/fhir/v3/NullFlavor";

    private static final String V3_NEW = "http://terminology.hl7.org/CodeSystem/v3-NullFlavor";

    private static final String NO_CONVERSION1 = "http://snomed.info/sct";

    private static final String NO_CONVERSION2 = "http://hl7.org/fhir/xxx";

    private static final String NO_CONVERSION3 = "http://terminology.hl7.org/CodeSystem/xxx";

    @Test
    public void testLegacyConversion() {
        Assert.assertEquals(V2_LEGACY, FhirCodeSystems.toLegacyCodeSystem(V2_NEW));
        Assert.assertEquals(V2_NEW, FhirCodeSystems.fromLegacyCodeSystem(V2_LEGACY));
        Assert.assertEquals(V3_LEGACY, FhirCodeSystems.toLegacyCodeSystem(V3_NEW));
        Assert.assertEquals(V3_NEW, FhirCodeSystems.fromLegacyCodeSystem(V3_LEGACY));
        Assert.assertEquals(NO_CONVERSION1, FhirCodeSystems.toLegacyCodeSystem(NO_CONVERSION1));
        Assert.assertEquals(NO_CONVERSION1, FhirCodeSystems.fromLegacyCodeSystem(NO_CONVERSION1));
        Assert.assertEquals(NO_CONVERSION2, FhirCodeSystems.toLegacyCodeSystem(NO_CONVERSION2));
        Assert.assertEquals(NO_CONVERSION3, FhirCodeSystems.fromLegacyCodeSystem(NO_CONVERSION3));
    }

}
