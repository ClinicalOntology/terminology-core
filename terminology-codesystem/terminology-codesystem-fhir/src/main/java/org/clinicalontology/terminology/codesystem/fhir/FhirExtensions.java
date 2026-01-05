package org.clinicalontology.terminology.codesystem.fhir;

import org.clinicalontology.terminology.api.model.CodeSystemEnumerator;
import org.clinicalontology.terminology.api.model.CodeSystemRegistry;
import org.clinicalontology.terminology.impl.model.CodeSystemImpl;

import java.net.URI;
import java.util.List;

/**
 * Recognized FHIR extensions.
 */
@SuppressWarnings("unused")
public final class FhirExtensions extends CodeSystemImpl {

    public static final FhirExtensions EXT_MEDICATIONREQUEST_CATEGORY = new FhirExtensions("http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationRequest.category");

    public static final FhirExtensions EXT_MEDICATIONSTATEMENT_CATEGORY = new FhirExtensions("http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationStatement.category");

    private static final String DEFAULT_EXTENSION_PREFIX = "http://hl7.org/fhir/StructureDefinition/";

    // -------------------- FHIR Extension Registry --------------------

    public static final FhirExtensions EXT_ADDITIONAL_IDENTIFIER = defaultExtension("additionalIdentifier");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_ABATEMENT = defaultExtension("allergyintolerance-abatement");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_ASSERTED_DATE = defaultExtension("allergyintolerance-assertedDate");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_CERTAINTY = defaultExtension("allergyintolerance-certainty");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_DURATION = defaultExtension("allergyintolerance-duration");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_REASON_REFUTED = defaultExtension("allergyintolerance-reasonRefuted");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_RESOLUTION_AGE = defaultExtension("allergyintolerance-resolutionAge");

    public static final FhirExtensions EXT_ALLERGYINTOLERANCE_SUBSTANCE_EXPOSURE_RISK = defaultExtension("allergyintolerance-substanceExposureRisk");

    public static final FhirExtensions EXT_ALTERNATE_CANONICAL = defaultExtension("alternate-canonical");

    public static final FhirExtensions EXT_ALTERNATE_REFERENCE = defaultExtension("alternate-reference");

    public static final FhirExtensions EXT_ARTIFACT_AUTHOR = defaultExtension("artifact-author");

    public static final FhirExtensions EXT_ARTIFACT_CONTACT = defaultExtension("artifact-contact");

    public static final FhirExtensions EXT_ARTIFACT_CONTACT_DETAIL_REFERENCE = defaultExtension("artifact-contactDetailReference");

    public static final FhirExtensions EXT_ARTIFACT_COPYRIGHT = defaultExtension("artifact-copyright");

    public static final FhirExtensions EXT_ARTIFACT_DATE = defaultExtension("artifact-date");

    public static final FhirExtensions EXT_ARTIFACT_DESCRIPTION = defaultExtension("artifact-description");

    public static final FhirExtensions EXT_ARTIFACT_EDITOR = defaultExtension("artifact-editor");

    public static final FhirExtensions EXT_ARTIFACT_ENDORSER = defaultExtension("artifact-endorser");

    public static final FhirExtensions EXT_ARTIFACT_EXPERIMENTAL = defaultExtension("artifact-experimental");

    public static final FhirExtensions EXT_ARTIFACT_IDENTIFIER = defaultExtension("artifact-identifier");

    public static final FhirExtensions EXT_ARTIFACT_JURISDICTION = defaultExtension("artifact-jurisdiction");

    public static final FhirExtensions EXT_ARTIFACT_KNOWLEDGE_CAPABILITY = defaultExtension("artifact-knowledgeCapability");

    public static final FhirExtensions EXT_ARTIFACT_KNOWLEDGE_REPRESENTATION_LEVEL = defaultExtension("artifact-knowledgeRepresentationLevel");

    public static final FhirExtensions EXT_ARTIFACT_NAME = defaultExtension("artifact-name");

    public static final FhirExtensions EXT_ARTIFACT_PERIOD_DURATION = defaultExtension("artifact-periodDuration");

    public static final FhirExtensions EXT_ARTIFACT_PUBLISHER = defaultExtension("artifact-publisher");

    public static final FhirExtensions EXT_ARTIFACT_PURPOSE = defaultExtension("artifact-purpose");

    public static final FhirExtensions EXT_ARTIFACT_RELATED_ARTIFACT = defaultExtension("artifact-relatedArtifact");

    public static final FhirExtensions EXT_ARTIFACT_REVIEWER = defaultExtension("artifact-reviewer");

    public static final FhirExtensions EXT_ARTIFACT_STATUS = defaultExtension("artifact-status");

    public static final FhirExtensions EXT_ARTIFACT_TITLE = defaultExtension("artifact-title");

    public static final FhirExtensions EXT_ARTIFACT_TOPIC = defaultExtension("artifact-topic");

    public static final FhirExtensions EXT_ARTIFACT_URL = defaultExtension("artifact-url");

    public static final FhirExtensions EXT_ARTIFACT_USE_CONTEXT = defaultExtension("artifact-useContext");

    public static final FhirExtensions EXT_ARTIFACT_VERSION = defaultExtension("artifact-version");

    public static final FhirExtensions EXT_ASSOCIATED_ENCOUNTER = defaultExtension("encounter-associatedEncounter");

    public static final FhirExtensions EXT_AUDITEVENT_ACCESSION = defaultExtension("auditevent-Accession");

    public static final FhirExtensions EXT_AUDITEVENT_ALTERNATIVE_USER_ID = defaultExtension("auditevent-AlternativeUserID");

    public static final FhirExtensions EXT_AUDITEVENT_ANONYMIZED = defaultExtension("auditevent-Anonymized");

    public static final FhirExtensions EXT_AUDITEVENT_ENCRYPTED = defaultExtension("auditevent-Encrypted");

    public static final FhirExtensions EXT_AUDITEVENT_INSTANCE = defaultExtension("auditevent-Instance");

    public static final FhirExtensions EXT_AUDITEVENT_LIFECYCLE = defaultExtension("auditevent-Lifecycle");

    public static final FhirExtensions EXT_AUDITEVENT_MPPS = defaultExtension("auditevent-MPPS");

    public static final FhirExtensions EXT_AUDITEVENT_NUMBER_OF_INSTANCES = defaultExtension("auditevent-NumberOfInstances");

    public static final FhirExtensions EXT_AUDITEVENT_PARTICIPANT_OBJECT_CONTAINS_STUDY = defaultExtension("auditevent-ParticipantObjectContainsStudy");

    public static final FhirExtensions EXT_AUDITEVENT_SOP_CLASS = defaultExtension("auditevent-SOPClass");

    public static final FhirExtensions EXT_CODESYSTEM_ALTERNATE = defaultExtension("codesystem-alternate");

    public static final FhirExtensions EXT_CODESYSTEM_AUTHORITATIVE_SOURCE = defaultExtension("codesystem-authoritativeSource");

    public static final FhirExtensions EXT_CODESYSTEM_CONCEPT_COMMENTS = defaultExtension("codesystem-concept-comments");

    public static final FhirExtensions EXT_CODESYSTEM_CONCEPT_ORDER = defaultExtension("codesystem-conceptOrder");

    public static final FhirExtensions EXT_CODESYSTEM_HISTORY = defaultExtension("codesystem-history");

    public static final FhirExtensions EXT_CODESYSTEM_KEYWORD = defaultExtension("codesystem-keyWord");

    public static final FhirExtensions EXT_CODESYSTEM_LABEL = defaultExtension("codesystem-label");

    public static final FhirExtensions EXT_CODESYSTEM_MAP = defaultExtension("codesystem-map");

    public static final FhirExtensions EXT_CODESYSTEM_OTHER_NAME = defaultExtension("codesystem-otherName");

    public static final FhirExtensions EXT_CODESYSTEM_PROPERTIES_MODE = defaultExtension("codesystem-properties-mode");

    public static final FhirExtensions EXT_CODESYSTEM_REPLACED_BY = defaultExtension("codesystem-replacedby");

    public static final FhirExtensions EXT_CODESYSTEM_SOURCE_REFERENCE = defaultExtension("codesystem-sourceReference");

    public static final FhirExtensions EXT_CODESYSTEM_TRUSTED_EXPANSION = defaultExtension("codesystem-trusted-expansion");

    public static final FhirExtensions EXT_CODESYSTEM_USAGE = defaultExtension("codesystem-usage");

    public static final FhirExtensions EXT_CODESYSTEM_USE_MARKDOWN = defaultExtension("codesystem-use-markdown");

    public static final FhirExtensions EXT_CODESYSTEM_WARNING = defaultExtension("codesystem-warning");

    public static final FhirExtensions EXT_CODESYSTEM_WORKFLOW_STATUS = defaultExtension("codesystem-workflowStatus");

    public static final FhirExtensions EXT_CONDITION_ASSERTED_DATE = defaultExtension("condition-assertedDate");

    public static final FhirExtensions EXT_CONDITION_DISEASE_COURSE = defaultExtension("condition-diseaseCourse");

    public static final FhirExtensions EXT_CONDITION_DUE_TO = defaultExtension("condition-dueTo");

    public static final FhirExtensions EXT_CONDITION_OCCURRED_FOLLOWING = defaultExtension("condition-occurredFollowing");

    public static final FhirExtensions EXT_CONDITION_OUTCOME = defaultExtension("condition-outcome");

    public static final FhirExtensions EXT_CONDITION_RANK = defaultExtension("condition-rank");

    public static final FhirExtensions EXT_CONDITION_RELATED = defaultExtension("condition-related");

    public static final FhirExtensions EXT_CONDITION_REVIEWED = defaultExtension("condition-reviewed");

    public static final FhirExtensions EXT_CONDITION_RULED_OUT = defaultExtension("condition-ruledOut");

    public static final FhirExtensions EXT_DATA_ABSENT_REASON = defaultExtension("data-absent-reason");

    public static final FhirExtensions EXT_GOAL_ACCEPTANCE = defaultExtension("goal-acceptance");

    public static final FhirExtensions EXT_GOAL_RECORDED = defaultExtension("goal-recorded");

    public static final FhirExtensions EXT_GOAL_REJECTED = defaultExtension("goal-rejected");

    public static final FhirExtensions EXT_GOAL_RELATIONSHIP = defaultExtension("goal-relationship");

    public static final FhirExtensions EXT_GOAL_TARGET = defaultExtension("goal-target");

    public static final FhirExtensions EXT_OBSERVATION_BODY_POSITION = defaultExtension("observation-bodyPosition");

    public static final FhirExtensions EXT_OBSERVATION_DELTA = defaultExtension("observation-delta");

    public static final FhirExtensions EXT_OBSERVATION_DEVICE_CODE = defaultExtension("observation-deviceCode");

    public static final FhirExtensions EXT_OBSERVATION_FOCUS_CODE = defaultExtension("observation-focusCode");

    public static final FhirExtensions EXT_OBSERVATION_GATEWAY_DEVICE = defaultExtension("observation-gatewayDevice");

    public static final FhirExtensions EXT_OBSERVATION_PRECONDITION = defaultExtension("observation-precondition");

    public static final FhirExtensions EXT_OBSERVATION_REAGENT = defaultExtension("observation-reagent");

    public static final FhirExtensions EXT_OBSERVATION_REPLACES = defaultExtension("observation-replaces");

    public static final FhirExtensions EXT_OBSERVATION_SECONDARY_FINDING = defaultExtension("observation-secondaryFinding");

    public static final FhirExtensions EXT_OBSERVATION_SEQUEL_TO = defaultExtension("observation-sequelTo");

    public static final FhirExtensions EXT_OBSERVATION_SPECIMEN_CODE = defaultExtension("observation-specimenCode");

    public static final FhirExtensions EXT_OBSERVATION_TIME_OFFSET = defaultExtension("observation-timeOffset");

    public static final FhirExtensions EXT_PATIENT_ADOPTION_INFO = defaultExtension("patient-adoptionInfo");

    public static final FhirExtensions EXT_PATIENT_ANIMAL = defaultExtension("patient-animal");

    public static final FhirExtensions EXT_PATIENT_BIRTH_PLACE = defaultExtension("patient-birthPlace");

    public static final FhirExtensions EXT_PATIENT_BIRTH_TIME = defaultExtension("patient-birthTime");

    public static final FhirExtensions EXT_PATIENT_CADAVERIC_DONOR = defaultExtension("patient-cadavericDonor");

    public static final FhirExtensions EXT_PATIENT_CITIZENSHIP = defaultExtension("patient-citizenship");

    public static final FhirExtensions EXT_PATIENT_CONGREGATION = defaultExtension("patient-congregation");

    public static final FhirExtensions EXT_PATIENT_DISABILITY = defaultExtension("patient-disability");

    public static final FhirExtensions EXT_PATIENT_IMPORTANCE = defaultExtension("patient-importance");

    public static final FhirExtensions EXT_PATIENT_INTERPRETER_REQUIRED = defaultExtension("patient-interpreterRequired");

    public static final FhirExtensions EXT_PATIENT_MOTHERS_MAIDEN_NAME = defaultExtension("patient-mothersMaidenName");

    public static final FhirExtensions EXT_PATIENT_MULTIPLE_BIRTH_TOTAL = defaultExtension("patient-multipleBirthTotal");

    public static final FhirExtensions EXT_PATIENT_NATIONALITY = defaultExtension("patient-nationality");

    public static final FhirExtensions EXT_PATIENT_PREFERENCE_TYPE = defaultExtension("patient-preferenceType");

    public static final FhirExtensions EXT_PATIENT_PROFICIENCY = defaultExtension("patient-proficiency");

    public static final FhirExtensions EXT_PATIENT_RELATED_PERSON = defaultExtension("patient-relatedPerson");

    public static final FhirExtensions EXT_PATIENT_RELIGION = defaultExtension("patient-religion");

    public static final FhirExtensions EXT_PATIENT_SEX_FOR_CLINICAL_USE = defaultExtension("patient-sexForClinicalUse");

    public static final FhirExtensions EXT_QUESTIONNAIRE_BASE_TYPE = defaultExtension("questionnaire-baseType");

    public static final FhirExtensions EXT_QUESTIONNAIRE_CHOICE_ORIENTATION = defaultExtension("questionnaire-choiceOrientation");

    public static final FhirExtensions EXT_QUESTIONNAIRE_CONSTRAINT = defaultExtension("questionnaire-constraint");

    public static final FhirExtensions EXT_QUESTIONNAIRE_DEFINITION_BASSED = defaultExtension("questionnaire-definitionBased");

    public static final FhirExtensions EXT_QUESTIONNAIRE_DISPLAY_CATEGORY = defaultExtension("questionnaire-displayCategory");

    public static final FhirExtensions EXT_QUESTIONNAIRE_FHIR_TYPE = defaultExtension("questionnaire-fhirType");

    public static final FhirExtensions EXT_QUESTIONNAIRE_HIDDEN = defaultExtension("questionnaire-hidden");

    public static final FhirExtensions EXT_QUESTIONNAIRE_ITEM_CONTROL = defaultExtension("questionnaire-itemControl");

    public static final FhirExtensions EXT_QUESTIONNAIRE_MAX_OCCURS = defaultExtension("questionnaire-maxOccurs");

    public static final FhirExtensions EXT_QUESTIONNAIRE_MIN_OCCURS = defaultExtension("questionnaire-minOccurs");

    public static final FhirExtensions EXT_QUESTIONNAIRE_OPTION_EXCLUSIVE = defaultExtension("questionnaire-optionExclusive");

    public static final FhirExtensions EXT_QUESTIONNAIRE_OPTION_PREFIX = defaultExtension("questionnaire-optionPrefix");

    public static final FhirExtensions EXT_QUESTIONNAIRE_OPTION_RESTRICTION = defaultExtension("questionnaire-optionRestriction");

    public static final FhirExtensions EXT_QUESTIONNAIRE_REFERENCE_FILTER = defaultExtension("questionnaire-referenceFilter");

    public static final FhirExtensions EXT_QUESTIONNAIRE_REFERENCE_PROFILE = defaultExtension("questionnaire-referenceProfile");

    public static final FhirExtensions EXT_QUESTIONNAIRE_REFERENCE_RESOURCE = defaultExtension("questionnaire-referenceResource");

    public static final FhirExtensions EXT_QUESTIONNAIRE_SIGNATURE_REQUIRED = defaultExtension("questionnaire-signatureRequired");

    public static final FhirExtensions EXT_QUESTIONNAIRE_SLIDER_STEP_VALUE = defaultExtension("questionnaire-sliderStepValue");

    public static final FhirExtensions EXT_QUESTIONNAIRE_SUPPORT_LINK = defaultExtension("questionnaire-supportLink");

    public static final FhirExtensions EXT_QUESTIONNAIRE_UNIT = defaultExtension("questionnaire-unit");

    public static final FhirExtensions EXT_QUESTIONNAIRE_UNIT_OPTION = defaultExtension("questionnaire-unitOption");

    public static final FhirExtensions EXT_QUESTIONNAIRE_UNIT_VALUESET = defaultExtension("questionnaire-unitValueSet");

    public static final FhirExtensions EXT_QUESTIONNAIRE_USAGE_MODE = defaultExtension("questionnaire-usageMode");

    public static final FhirExtensions EXT_QUESTIONNAIRERESPONSE_ATTESTER = defaultExtension("questionnaireresponse-attester");

    public static final FhirExtensions EXT_QUESTIONNAIRRESPONSEE_AUTHOR = defaultExtension("questionnaireresponse-author");

    public static final FhirExtensions EXT_QUESTIONNAIRERESPONSE_COMPLETION_MODE = defaultExtension("questionnaireresponse-completionMode");

    public static final FhirExtensions EXT_QUESTIONNAIRERESPONSE_REASON = defaultExtension("questionnaireresponse-reason");

    public static final FhirExtensions EXT_QUESTIONNAIRERESPONSE_REVIEWER = defaultExtension("questionnaireresponse-reviewer");

    public static final FhirExtensions EXT_QUESTIONNAIRERESPONSE_SIGNATURE = defaultExtension("questionnaireresponse-signature");

    public static final FhirExtensions EXT_TIMING_EXACT = defaultExtension("timing-exact");

    // -------------------- US Core Profile --------------------

    public static final FhirExtensions EXT_US_CORE_BIRTH_SEX = defaultExtension("us-core-birth-sex");

    public static final FhirExtensions EXT_US_CORE_ETHNICITY = defaultExtension("us-core-ethnicity");

    public static final FhirExtensions EXT_US_CORE_RACE = defaultExtension("us-core-race");

    // -------------------- HSPC Extensions --------------------

    private static final String HSPC_EXTENSION_PREFIX = "http://hl7.org/fhir/hspc/StructureDefinition/";

    public static final FhirExtensions EXT_ALGORITHM_FOR_BLOODPRESSURE_AVERAGE = hspcExtension("AlgorithmForBloodPressureAverageExt");

    public static final FhirExtensions EXT_ALGORITHM_TYPE = hspcExtension("AlgorithmTypeExt");

    public static final FhirExtensions EXT_MEASUREMENT_SETTING = hspcExtension("MeasurementSettingExt");

    public static final FhirExtensions EXT_SET_SIZE = hspcExtension("SetSizeExt");

    public static final FhirExtensions EXT_TIME_WINDOW = hspcExtension("TimeWindowExt");

    private static final CodeSystemEnumerator<FhirExtensions> delegate = new CodeSystemEnumerator<>(FhirExtensions.class);

    static {
        CodeSystemRegistry.registerCodeSystems(delegate.values());
    }

    /**
     * Force instantiation and registration of static class members.
     */
    public static void load() {
    }

    /**
     * @see CodeSystemEnumerator#values()
     */
    public static List<FhirExtensions> values() {
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
    public static FhirExtensions valueOf(String name) {
        return delegate.valueOf(name);
    }

    /**
     * @see CodeSystemEnumerator#valueOf(String, boolean)
     */
    public static FhirExtensions valueOf(
        String name,
        boolean exceptionIfNotFound
    ) {
        return delegate.valueOf(name, exceptionIfNotFound);
    }

    /**
     * Create a formal FHIR extension.
     *
     * @param urn The extension URL.
     * @return The newly created extension.
     */
    private static FhirExtensions defaultExtension(String urn) {
        return new FhirExtensions(DEFAULT_EXTENSION_PREFIX + urn);
    }

    /**
     * Create an HSPC extension.
     *
     * @param urn The extension URL.
     * @return The newly created extension.
     */
    private static FhirExtensions hspcExtension(String urn) {
        return new FhirExtensions(HSPC_EXTENSION_PREFIX + urn);
    }

    private FhirExtensions(String urn) {
        super(URI.create(urn));
    }

    /**
     * @see CodeSystemEnumerator#ordinal(Object)
     */
    public int ordinal() {
        return delegate.ordinal(this);
    }

    /**
     * Alias for {@link #getName()}.
     *
     * @see CodeSystemEnumerator#name(Object)
     */
    public String name() {
        return delegate.name(this);
    }

    /**
     * @see CodeSystemEnumerator#name(Object)
     */
    @Override
    public String getName() {
        return name();
    }

}
