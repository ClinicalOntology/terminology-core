package org.clinicalontology.terminology.codesystem.fhir;

import org.clinicalontology.terminology.api.CodeSystemRegistry;
import org.clinicalontology.terminology.api.PseudoEnumDelegate;
import org.clinicalontology.terminology.impl.CodeSystemImpl;

import java.net.URI;
import java.util.List;

@SuppressWarnings("unused")
public final class FhirExtensions extends CodeSystemImpl {

    public static final FhirExtensions EXT_MEDICATIONREQUEST_CATEGORY = new FhirExtensions("http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationRequest.category");

    public static final FhirExtensions EXT_MEDICATIONSTATEMENT_CATEGORY = new FhirExtensions("http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationStatement.category");

    private static final String DEFAULT_EXTENSION_PREFIX = "http://hl7.org/fhir/StructureDefinition/";

    public static final FhirExtensions EXT_CONDITION_ASSERTED_DATE = defaultExtension("extension-Condition.assertedDate");

    public static final FhirExtensions EXT_ASSOCIATED_ENCOUNTER = defaultExtension("encounter-associatedEncounter");

    public static final FhirExtensions EXT_GOAL_RECORDED = defaultExtension("goal-recorded");

    public static final FhirExtensions EXT_GOAL_TARGET = defaultExtension("goal-target");

    public static final FhirExtensions EXT_PATIENT_BIRTH_TIME = defaultExtension("patient-birthTime");

    public static final FhirExtensions EXT_US_CORE_BIRTH_SEX = defaultExtension("us-core-birth-sex");

    public static final FhirExtensions EXT_US_CORE_ETHNICITY = defaultExtension("us-core-ethnicity");

    public static final FhirExtensions EXT_US_CORE_RACE = defaultExtension("us-core-race");

    private static final String HSPC_EXTENSION_PREFIX = "http://hl7.org/fhir/hspc/StructureDefinition/";

    public static final FhirExtensions EXT_ALGORITHM_FOR_BLOODPRESSURE_AVERAGE = hspcExtension("AlgorithmForBloodPressureAverageExt");

    public static final FhirExtensions EXT_ALGORITHM_TYPE = hspcExtension("AlgorithmTypeExt");

    public static final FhirExtensions EXT_MEASUREMENT_SETTING = hspcExtension("MeasurementSettingExt");

    public static final FhirExtensions EXT_SET_SIZE = hspcExtension("SetSizeExt");

    public static final FhirExtensions EXT_TIME_WINDOW = hspcExtension("TimeWindowExt");

    private static final PseudoEnumDelegate<FhirExtensions> delegate = new PseudoEnumDelegate<>(FhirExtensions.class);

    static {
        CodeSystemRegistry.registerCodeSystems(delegate.values());
    }

    public static List<FhirExtensions> values() {
        return delegate.values();
    }

    public static List<String> names() {
        return delegate.names();
    }

    public static FhirExtensions valueOf(String name) {
        return delegate.valueOf(name);
    }

    public static FhirExtensions valueOf(
            String name,
            boolean exceptionIfNotFound) {
        return delegate.valueOf(name, exceptionIfNotFound);
    }

    private static FhirExtensions defaultExtension(String urn) {
        return new FhirExtensions(DEFAULT_EXTENSION_PREFIX + urn);
    }

    private static FhirExtensions hspcExtension(String urn) {
        return new FhirExtensions(HSPC_EXTENSION_PREFIX + urn);
    }

    private FhirExtensions(String urn) {
        super(URI.create(urn));
    }

    public int ordinal() {
        return delegate.ordinal(this);
    }

    public String name() {
        return delegate.name(this);
    }

    @Override
    public String getName() {
        return name();
    }

}
