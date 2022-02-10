package org.clinicalontology.terminology.codesystem.fhir;

import org.apache.commons.lang3.StringUtils;
import org.clinicalontology.terminology.api.CodeSystemRegistry;
import org.clinicalontology.terminology.api.PseudoEnumDelegate;
import org.clinicalontology.terminology.impl.CodeSystemImpl;

import java.net.URI;
import java.util.List;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public final class FhirCodeSystems extends CodeSystemImpl {

    private static final Pattern VERSION_PREFIX_REGEX = Pattern.compile("^v\\d.*$");

    public static final String FHIR_CODESYSTEM_PREFIX = "http://terminology.hl7.org/CodeSystem/";

    public static final String LEGACY_CODESYSTEM_PREFIX = "http://hl7.org/fhir/";

    public static final FhirCodeSystems FHIR_VERSION = new FhirCodeSystems("FHIR-version");

    public static final FhirCodeSystems ABSTRACT_TYPES = new FhirCodeSystems("abstract-types");

    public static final FhirCodeSystems ACCOUNT_STATUS = new FhirCodeSystems("account-status");

    public static final FhirCodeSystems ACCOUNT_TYPE = new FhirCodeSystems("account-type");

    public static final FhirCodeSystems ACTION_CARDINALITY_BEHAVIOR = new FhirCodeSystems("action-cardinality-behavior");

    public static final FhirCodeSystems ACTION_CONDITION_KIND = new FhirCodeSystems("action-condition-kind");

    public static final FhirCodeSystems ACTION_GROUPING_BEHAVIOR = new FhirCodeSystems("action-grouping-behavior");

    public static final FhirCodeSystems ACTION_PARTICIPANT_ROLE = new FhirCodeSystems("action-participant-role");

    public static final FhirCodeSystems ACTION_PARTICIPANT_TYPE = new FhirCodeSystems("action-participant-type");

    public static final FhirCodeSystems ACTION_PRECHECK_BEHAVIOR = new FhirCodeSystems("action-precheck-behavior");

    public static final FhirCodeSystems ACTION_RELATIONSHIP_TYPE = new FhirCodeSystems("action-relationship-type");

    public static final FhirCodeSystems ACTION_REQUIRED_BEHAVIOR = new FhirCodeSystems("action-required-behavior");

    public static final FhirCodeSystems ACTION_SELECTION_BEHAVIOR = new FhirCodeSystems("action-selection-behavior");

    public static final FhirCodeSystems ACTION_TYPE = new FhirCodeSystems("action-type");

    public static final FhirCodeSystems ACTIVITY_DEFINITION_CATEGORY = new FhirCodeSystems("activity-definition-category");

    public static final FhirCodeSystems ADDITIONAL_INSTRUCTION_CODES = new FhirCodeSystems("additional-instruction-codes");

    public static final FhirCodeSystems ADDITIONALMATERIALS = new FhirCodeSystems("additionalmaterials");

    public static final FhirCodeSystems ADDRESS_TYPE = new FhirCodeSystems("address-type");

    public static final FhirCodeSystems ADDRESS_USE = new FhirCodeSystems("address-use");

    public static final FhirCodeSystems ADJUDICATION = new FhirCodeSystems("adjudication");

    public static final FhirCodeSystems ADJUDICATION_ERROR = new FhirCodeSystems("adjudication-error");

    public static final FhirCodeSystems ADJUDICATION_REASON = new FhirCodeSystems("adjudication-reason");

    public static final FhirCodeSystems ADMINISTRATION_METHOD_CODES = new FhirCodeSystems("administration-method-codes");

    public static final FhirCodeSystems ADMINISTRATIVE_GENDER = new FhirCodeSystems("administrative-gender");

    public static final FhirCodeSystems ADVERSE_EVENT_ACTUALITY = new FhirCodeSystems("adverse-event-actuality");

    public static final FhirCodeSystems ADVERSE_EVENT_CATEGORY = new FhirCodeSystems("adverse-event-category");

    public static final FhirCodeSystems ADVERSE_EVENT_CAUSALITY_ASSESS = new FhirCodeSystems("adverse-event-causality-assess");

    public static final FhirCodeSystems ADVERSE_EVENT_CAUSALITY_METHOD = new FhirCodeSystems("adverse-event-causality-method");

    public static final FhirCodeSystems ADVERSE_EVENT_OUTCOME = new FhirCodeSystems("adverse-event-outcome");

    public static final FhirCodeSystems ADVERSE_EVENT_SERIOUSNESS = new FhirCodeSystems("adverse-event-seriousness");

    public static final FhirCodeSystems ADVERSE_EVENT_SEVERITY = new FhirCodeSystems("adverse-event-severity");

    public static final FhirCodeSystems ADVERSE_EVENT_TYPE = new FhirCodeSystems("adverse-event-type");

    public static final FhirCodeSystems AGE_UNITS = new FhirCodeSystems("age-units");

    public static final FhirCodeSystems ALL_DISTANCE_UNITS = new FhirCodeSystems("all-distance-units");

    public static final FhirCodeSystems ALL_LANGUAGES = new FhirCodeSystems("all-languages");

    public static final FhirCodeSystems ALL_TIME_UNITS = new FhirCodeSystems("all-time-units");

    public static final FhirCodeSystems ALL_TYPES = new FhirCodeSystems("all-types");

    public static final FhirCodeSystems ALLELENAME = new FhirCodeSystems("allelename");

    public static final FhirCodeSystems ALLERG_INTOL_SUBSTANCE_EXP_RISK = new FhirCodeSystems("allerg-intol-substance-exp-risk");

    public static final FhirCodeSystems ALLERGY_INTOLERANCE_CATEGORY = new FhirCodeSystems("allergy-intolerance-category");

    public static final FhirCodeSystems ALLERGY_INTOLERANCE_CRITICALITY = new FhirCodeSystems("allergy-intolerance-criticality");

    public static final FhirCodeSystems ALLERGY_INTOLERANCE_TYPE = new FhirCodeSystems("allergy-intolerance-type");

    public static final FhirCodeSystems ALLERGYINTOLERANCE_CLINICAL = new FhirCodeSystems("allergyintolerance-clinical");

    public static final FhirCodeSystems ALLERGYINTOLERANCE_CODE = new FhirCodeSystems("allergyintolerance-code");

    public static final FhirCodeSystems ALLERGYINTOLERANCE_VERIFICATION = new FhirCodeSystems("allergyintolerance-verification");

    public static final FhirCodeSystems ANIMAL_BREEDS = new FhirCodeSystems("animal-breeds");

    public static final FhirCodeSystems ANIMAL_GENDERSTATUS = new FhirCodeSystems("animal-genderstatus");

    public static final FhirCodeSystems ANIMAL_SPECIES = new FhirCodeSystems("animal-species");

    public static final FhirCodeSystems APPOINTMENT_CANCELLATION_REASON = new FhirCodeSystems("appointment-cancellation-reason");

    public static final FhirCodeSystems APPOINTMENTSTATUS = new FhirCodeSystems("appointmentstatus");

    public static final FhirCodeSystems APPROACH_SITE_CODES = new FhirCodeSystems("approach-site-codes");

    public static final FhirCodeSystems ASSERT_DIRECTION_CODES = new FhirCodeSystems("assert-direction-codes");

    public static final FhirCodeSystems ASSERT_OPERATOR_CODES = new FhirCodeSystems("assert-operator-codes");

    public static final FhirCodeSystems ASSERT_RESPONSE_CODE_TYPES = new FhirCodeSystems("assert-response-code-types");

    public static final FhirCodeSystems ASSET_AVAILABILITY = new FhirCodeSystems("asset-availability");

    public static final FhirCodeSystems AUDIT_ENTITY_TYPE = new FhirCodeSystems("audit-entity-type");

    public static final FhirCodeSystems AUDIT_EVENT_ACTION = new FhirCodeSystems("audit-event-action");

    public static final FhirCodeSystems AUDIT_EVENT_OUTCOME = new FhirCodeSystems("audit-event-outcome");

    public static final FhirCodeSystems AUDIT_EVENT_SUB_TYPE = new FhirCodeSystems("audit-event-sub-type");

    public static final FhirCodeSystems AUDIT_EVENT_TYPE = new FhirCodeSystems("audit-event-type");

    public static final FhirCodeSystems AUDIT_SOURCE_TYPE = new FhirCodeSystems("audit-source-type");

    public static final FhirCodeSystems BASIC_RESOURCE_TYPE = new FhirCodeSystems("basic-resource-type");

    public static final FhirCodeSystems BENEFIT_NETWORK = new FhirCodeSystems("benefit-network");

    public static final FhirCodeSystems BENEFIT_TERM = new FhirCodeSystems("benefit-term");

    public static final FhirCodeSystems BENEFIT_TYPE = new FhirCodeSystems("benefit-type");

    public static final FhirCodeSystems BENEFIT_UNIT = new FhirCodeSystems("benefit-unit");

    public static final FhirCodeSystems BINDING_STRENGTH = new FhirCodeSystems("binding-strength");

    public static final FhirCodeSystems BODY_SITE = new FhirCodeSystems("body-site");

    public static final FhirCodeSystems BODYSITE_LATERALITY = new FhirCodeSystems("bodysite-laterality");

    public static final FhirCodeSystems BODYSTRUCTURE_CODE = new FhirCodeSystems("bodystructure-code");

    public static final FhirCodeSystems BODYSTRUCTURE_RELATIVE_LOCATION = new FhirCodeSystems("bodystructure-relative-location");

    public static final FhirCodeSystems BUNDLE_TYPE = new FhirCodeSystems("bundle-type");

    public static final FhirCodeSystems C80_DOC_TYPECODES = new FhirCodeSystems("c80-doc-typecodes");

    public static final FhirCodeSystems C80_FACILITYCODES = new FhirCodeSystems("c80-facilitycodes");

    public static final FhirCodeSystems C80_PRACTICE_CODES = new FhirCodeSystems("c80-practice-codes");

    public static final FhirCodeSystems CAPABILITY_STATEMENT_KIND = new FhirCodeSystems("capability-statement-kind");

    public static final FhirCodeSystems CARE_PLAN_ACTIVITY_KIND = new FhirCodeSystems("care-plan-activity-kind");

    public static final FhirCodeSystems CARE_PLAN_ACTIVITY_OUTCOME = new FhirCodeSystems("care-plan-activity-outcome");

    public static final FhirCodeSystems CARE_PLAN_ACTIVITY_STATUS = new FhirCodeSystems("care-plan-activity-status");

    public static final FhirCodeSystems CARE_PLAN_CATEGORY = new FhirCodeSystems("care-plan-category");

    public static final FhirCodeSystems CARE_PLAN_INTENT = new FhirCodeSystems("care-plan-intent");

    public static final FhirCodeSystems CARE_TEAM_CATEGORY = new FhirCodeSystems("care-team-category");

    public static final FhirCodeSystems CARE_TEAM_STATUS = new FhirCodeSystems("care-team-status");

    public static final FhirCodeSystems CATALOGTYPE = new FhirCodeSystems("catalogType");

    public static final FhirCodeSystems CDSHOOKS_INDICATOR = new FhirCodeSystems("cdshooks-indicator");

    public static final FhirCodeSystems CERTAINTY_SUBCOMPONENT_RATING = new FhirCodeSystems("certainty-subcomponent-rating");

    public static final FhirCodeSystems CERTAINTY_SUBCOMPONENT_TYPE = new FhirCodeSystems("certainty-subcomponent-type");

    public static final FhirCodeSystems CHARGEITEM_BILLINGCODES = new FhirCodeSystems("chargeitem-billingcodes");

    public static final FhirCodeSystems CHARGEITEM_STATUS = new FhirCodeSystems("chargeitem-status");

    public static final FhirCodeSystems CHOICE_LIST_ORIENTATION = new FhirCodeSystems("choice-list-orientation");

    public static final FhirCodeSystems CHROMOSOME_HUMAN = new FhirCodeSystems("chromosome-human");

    public static final FhirCodeSystems CLAIM_CARETEAMROLE = new FhirCodeSystems("claim-careteamrole");

    public static final FhirCodeSystems CLAIM_EXCEPTION = new FhirCodeSystems("claim-exception");

    public static final FhirCodeSystems CLAIM_INFORMATIONCATEGORY = new FhirCodeSystems("claim-informationcategory");

    public static final FhirCodeSystems CLAIM_MODIFIERS = new FhirCodeSystems("claim-modifiers");

    public static final FhirCodeSystems CLAIM_SUBTYPE = new FhirCodeSystems("claim-subtype");

    public static final FhirCodeSystems CLAIM_TYPE = new FhirCodeSystems("claim-type");

    public static final FhirCodeSystems CLAIM_USE = new FhirCodeSystems("claim-use");

    public static final FhirCodeSystems CLINICAL_FINDINGS = new FhirCodeSystems("clinical-findings");

    public static final FhirCodeSystems CLINICALIMPRESSION_PROGNOSIS = new FhirCodeSystems("clinicalimpression-prognosis");

    public static final FhirCodeSystems CLINICALIMPRESSION_STATUS = new FhirCodeSystems("clinicalimpression-status");

    public static final FhirCodeSystems CLINVAR = new FhirCodeSystems("clinvar");

    public static final FhirCodeSystems CODE_SEARCH_SUPPORT = new FhirCodeSystems("code-search-support");

    public static final FhirCodeSystems CODESYSTEM_ALTCODE_KIND = new FhirCodeSystems("codesystem-altcode-kind");

    public static final FhirCodeSystems CODESYSTEM_CONTENT_MODE = new FhirCodeSystems("codesystem-content-mode");

    public static final FhirCodeSystems CODESYSTEM_HIERARCHY_MEANING = new FhirCodeSystems("codesystem-hierarchy-meaning");

    public static final FhirCodeSystems COMMON_TAGS = new FhirCodeSystems("common-tags");

    public static final FhirCodeSystems COMMUNICATION_CATEGORY = new FhirCodeSystems("communication-category");

    public static final FhirCodeSystems COMMUNICATION_NOT_DONE_REASON = new FhirCodeSystems("communication-not-done-reason");

    public static final FhirCodeSystems COMMUNICATION_TOPIC = new FhirCodeSystems("communication-topic");

    public static final FhirCodeSystems COMPARTMENT_TYPE = new FhirCodeSystems("compartment-type");

    public static final FhirCodeSystems COMPOSITE_MEASURE_SCORING = new FhirCodeSystems("composite-measure-scoring");

    public static final FhirCodeSystems COMPOSITION_ALTCODE_KIND = new FhirCodeSystems("composition-altcode-kind");

    public static final FhirCodeSystems COMPOSITION_ATTESTATION_MODE = new FhirCodeSystems("composition-attestation-mode");

    public static final FhirCodeSystems COMPOSITION_STATUS = new FhirCodeSystems("composition-status");

    public static final FhirCodeSystems CONCEPT_MAP_EQUIVALENCE = new FhirCodeSystems("concept-map-equivalence");

    public static final FhirCodeSystems CONCEPT_PROPERTY_TYPE = new FhirCodeSystems("concept-property-type");

    public static final FhirCodeSystems CONCEPT_SUBSUMPTION_OUTCOME = new FhirCodeSystems("concept-subsumption-outcome");

    public static final FhirCodeSystems CONCEPTMAP_UNMAPPED_MODE = new FhirCodeSystems("conceptmap-unmapped-mode");

    public static final FhirCodeSystems CONDITION_CATEGORY = new FhirCodeSystems("condition-category");

    public static final FhirCodeSystems CONDITION_CAUSE = new FhirCodeSystems("condition-cause");

    public static final FhirCodeSystems CONDITION_CLINICAL = new FhirCodeSystems("condition-clinical");

    public static final FhirCodeSystems CONDITION_CODE = new FhirCodeSystems("condition-code");

    public static final FhirCodeSystems CONDITION_OUTCOME = new FhirCodeSystems("condition-outcome");

    public static final FhirCodeSystems CONDITION_PREDECESSOR = new FhirCodeSystems("condition-predecessor");

    public static final FhirCodeSystems CONDITION_SEVERITY = new FhirCodeSystems("condition-severity");

    public static final FhirCodeSystems CONDITION_STAGE = new FhirCodeSystems("condition-stage");

    public static final FhirCodeSystems CONDITION_STAGE_TYPE = new FhirCodeSystems("condition-stage-type");

    public static final FhirCodeSystems CONDITION_STATE = new FhirCodeSystems("condition-state");

    public static final FhirCodeSystems CONDITION_VER_STATUS = new FhirCodeSystems("condition-ver-status");

    public static final FhirCodeSystems CONDITIONAL_DELETE_STATUS = new FhirCodeSystems("conditional-delete-status");

    public static final FhirCodeSystems CONDITIONAL_READ_STATUS = new FhirCodeSystems("conditional-read-status");

    public static final FhirCodeSystems CONFORMANCE_EXPECTATION = new FhirCodeSystems("conformance-expectation");

    public static final FhirCodeSystems CONSENT_ACTION = new FhirCodeSystems("consent-action");

    public static final FhirCodeSystems CONSENT_CATEGORY = new FhirCodeSystems("consent-category");

    public static final FhirCodeSystems CONSENT_CONTENT_CLASS = new FhirCodeSystems("consent-content-class");

    public static final FhirCodeSystems CONSENT_CONTENT_CODE = new FhirCodeSystems("consent-content-code");

    public static final FhirCodeSystems CONSENT_DATA_MEANING = new FhirCodeSystems("consent-data-meaning");

    public static final FhirCodeSystems CONSENT_PERFORMER = new FhirCodeSystems("consent-performer");

    public static final FhirCodeSystems CONSENT_POLICY = new FhirCodeSystems("consent-policy");

    public static final FhirCodeSystems CONSENT_PROVISION_TYPE = new FhirCodeSystems("consent-provision-type");

    public static final FhirCodeSystems CONSENT_SCOPE = new FhirCodeSystems("consent-scope");

    public static final FhirCodeSystems CONSENT_STATE_CODES = new FhirCodeSystems("consent-state-codes");

    public static final FhirCodeSystems CONSISTENCY_TYPE = new FhirCodeSystems("consistency-type");

    public static final FhirCodeSystems CONSTRAINT_SEVERITY = new FhirCodeSystems("constraint-severity");

    public static final FhirCodeSystems CONTACT_POINT_SYSTEM = new FhirCodeSystems("contact-point-system");

    public static final FhirCodeSystems CONTACT_POINT_USE = new FhirCodeSystems("contact-point-use");

    public static final FhirCodeSystems CONTACTENTITY_TYPE = new FhirCodeSystems("contactentity-type");

    public static final FhirCodeSystems CONTAINER_CAP = new FhirCodeSystems("container-cap");

    public static final FhirCodeSystems CONTAINER_MATERIAL = new FhirCodeSystems("container-material");

    public static final FhirCodeSystems CONTRACT_ACTION = new FhirCodeSystems("contract-action");

    public static final FhirCodeSystems CONTRACT_ACTIONSTATUS = new FhirCodeSystems("contract-actionstatus");

    public static final FhirCodeSystems CONTRACT_ACTORROLE = new FhirCodeSystems("contract-actorrole");

    public static final FhirCodeSystems CONTRACT_ASSETCONTEXT = new FhirCodeSystems("contract-assetcontext");

    public static final FhirCodeSystems CONTRACT_ASSETSCOPE = new FhirCodeSystems("contract-assetscope");

    public static final FhirCodeSystems CONTRACT_ASSETSUBTYPE = new FhirCodeSystems("contract-assetsubtype");

    public static final FhirCodeSystems CONTRACT_ASSETTYPE = new FhirCodeSystems("contract-assettype");

    public static final FhirCodeSystems CONTRACT_CONTENT_DERIVATIVE = new FhirCodeSystems("contract-content-derivative");

    public static final FhirCodeSystems CONTRACT_DATA_MEANING = new FhirCodeSystems("contract-data-meaning");

    public static final FhirCodeSystems CONTRACT_DECISION_MODE = new FhirCodeSystems("contract-decision-mode");

    public static final FhirCodeSystems CONTRACT_DEFINITION_SUBTYPE = new FhirCodeSystems("contract-definition-subtype");

    public static final FhirCodeSystems CONTRACT_DEFINITION_TYPE = new FhirCodeSystems("contract-definition-type");

    public static final FhirCodeSystems CONTRACT_EXPIRATION_TYPE = new FhirCodeSystems("contract-expiration-type");

    public static final FhirCodeSystems CONTRACT_LEGALSTATE = new FhirCodeSystems("contract-legalstate");

    public static final FhirCodeSystems CONTRACT_PARTY_ROLE = new FhirCodeSystems("contract-party-role");

    public static final FhirCodeSystems CONTRACT_PUBLICATIONSTATUS = new FhirCodeSystems("contract-publicationstatus");

    public static final FhirCodeSystems CONTRACT_SCOPE = new FhirCodeSystems("contract-scope");

    public static final FhirCodeSystems CONTRACT_SECURITY_CATEGORY = new FhirCodeSystems("contract-security-category");

    public static final FhirCodeSystems CONTRACT_SECURITY_CLASSIFICATION = new FhirCodeSystems("contract-security-classification");

    public static final FhirCodeSystems CONTRACT_SECURITY_CONTROL = new FhirCodeSystems("contract-security-control");

    public static final FhirCodeSystems CONTRACT_SIGNER_TYPE = new FhirCodeSystems("contract-signer-type");

    public static final FhirCodeSystems CONTRACT_STATUS = new FhirCodeSystems("contract-status");

    public static final FhirCodeSystems CONTRACT_SUBTYPE = new FhirCodeSystems("contract-subtype");

    public static final FhirCodeSystems CONTRACT_TERM_SUBTYPE = new FhirCodeSystems("contract-term-subtype");

    public static final FhirCodeSystems CONTRACT_TERM_TYPE = new FhirCodeSystems("contract-term-type");

    public static final FhirCodeSystems CONTRACT_TYPE = new FhirCodeSystems("contract-type");

    public static final FhirCodeSystems CONTRIBUTOR_TYPE = new FhirCodeSystems("contributor-type");

    public static final FhirCodeSystems COPY_NUMBER_EVENT = new FhirCodeSystems("copy-number-event");

    public static final FhirCodeSystems COSMIC = new FhirCodeSystems("cosmic");

    public static final FhirCodeSystems COVERAGE_CLASS = new FhirCodeSystems("coverage-class");

    public static final FhirCodeSystems COVERAGE_COPAY_TYPE = new FhirCodeSystems("coverage-copay-type");

    public static final FhirCodeSystems COVERAGE_FINANCIAL_EXCEPTION = new FhirCodeSystems("coverage-financial-exception");

    public static final FhirCodeSystems COVERAGE_SELFPAY = new FhirCodeSystems("coverage-selfpay");

    public static final FhirCodeSystems COVERAGE_TYPE = new FhirCodeSystems("coverage-type");

    public static final FhirCodeSystems COVERAGEELIGIBILITYRESPONSE_EX_AUTH_SUPPORT = new FhirCodeSystems("coverageeligibilityresponse-ex-auth-support");

    public static final FhirCodeSystems CPT_ALL = new FhirCodeSystems("cpt-all");

    public static final FhirCodeSystems CURRENCIES = new FhirCodeSystems("currencies");

    public static final FhirCodeSystems DATA_ABSENT_REASON = new FhirCodeSystems("data-absent-reason");

    public static final FhirCodeSystems DATA_TYPES = new FhirCodeSystems("data-types");

    public static final FhirCodeSystems DATAELEMENT_SDCOBJECTCLASS = new FhirCodeSystems("dataelement-sdcobjectclass");

    public static final FhirCodeSystems DATAELEMENT_SDCOBJECTCLASSPROPERTY = new FhirCodeSystems("dataelement-sdcobjectclassproperty");

    public static final FhirCodeSystems DAYS_OF_WEEK = new FhirCodeSystems("days-of-week");

    public static final FhirCodeSystems DBSNP = new FhirCodeSystems("dbsnp");

    public static final FhirCodeSystems DEFINED_TYPES = new FhirCodeSystems("defined-types");

    public static final FhirCodeSystems DEFINITION_RESOURCE_TYPES = new FhirCodeSystems("definition-resource-types");

    public static final FhirCodeSystems DEFINITION_STATUS = new FhirCodeSystems("definition-status");

    public static final FhirCodeSystems DEFINITION_TOPIC = new FhirCodeSystems("definition-topic");

    public static final FhirCodeSystems DEFINITION_USE = new FhirCodeSystems("definition-use");

    public static final FhirCodeSystems DESIGNATION_USE = new FhirCodeSystems("designation-use");

    public static final FhirCodeSystems DETECTEDISSUE_CATEGORY = new FhirCodeSystems("detectedissue-category");

    public static final FhirCodeSystems DETECTEDISSUE_MITIGATION_ACTION = new FhirCodeSystems("detectedissue-mitigation-action");

    public static final FhirCodeSystems DETECTEDISSUE_SEVERITY = new FhirCodeSystems("detectedissue-severity");

    public static final FhirCodeSystems DEVICE_ACTION = new FhirCodeSystems("device-action");

    public static final FhirCodeSystems DEVICE_COMPONENT_PROPERTY = new FhirCodeSystems("device-component-property");

    public static final FhirCodeSystems DEVICE_DEFINITION_STATUS = new FhirCodeSystems("device-definition-status");

    public static final FhirCodeSystems DEVICE_KIND = new FhirCodeSystems("device-kind");

    public static final FhirCodeSystems DEVICE_NAMETYPE = new FhirCodeSystems("device-nametype");

    public static final FhirCodeSystems DEVICE_SAFETY = new FhirCodeSystems("device-safety");

    public static final FhirCodeSystems DEVICE_STATEMENT_STATUS = new FhirCodeSystems("device-statement-status");

    public static final FhirCodeSystems DEVICE_STATUS = new FhirCodeSystems("device-status");

    public static final FhirCodeSystems DEVICE_STATUS_REASON = new FhirCodeSystems("device-status-reason");

    public static final FhirCodeSystems DEVICE_TYPE = new FhirCodeSystems("device-type");

    public static final FhirCodeSystems DEVICEMETRIC_TYPE = new FhirCodeSystems("devicemetric-type");

    public static final FhirCodeSystems DIAGNOSIS_ROLE = new FhirCodeSystems("diagnosis-role");

    public static final FhirCodeSystems DIAGNOSTIC_BASED_ON_SNOMED = new FhirCodeSystems("diagnostic-based-on-snomed");

    public static final FhirCodeSystems DIAGNOSTIC_REPORT_STATUS = new FhirCodeSystems("diagnostic-report-status");

    public static final FhirCodeSystems DIAGNOSTIC_SERVICE_SECTIONS = new FhirCodeSystems("diagnostic-service-sections");

    public static final FhirCodeSystems DICM_405_MEDIATYPE = new FhirCodeSystems("dicm-405-mediatype");

    public static final FhirCodeSystems DIET_TYPE = new FhirCodeSystems("diet-type");

    public static final FhirCodeSystems DISCRIMINATOR_TYPE = new FhirCodeSystems("discriminator-type");

    public static final FhirCodeSystems DISTANCE_UNITS = new FhirCodeSystems("distance-units");

    public static final FhirCodeSystems DOC_SECTION_CODES = new FhirCodeSystems("doc-section-codes");

    public static final FhirCodeSystems DOC_TYPECODES = new FhirCodeSystems("doc-typecodes");

    public static final FhirCodeSystems DOCUMENT_CLASSCODES = new FhirCodeSystems("document-classcodes");

    public static final FhirCodeSystems DOCUMENT_MODE = new FhirCodeSystems("document-mode");

    public static final FhirCodeSystems DOCUMENT_REFERENCE_STATUS = new FhirCodeSystems("document-reference-status");

    public static final FhirCodeSystems DOCUMENT_RELATIONSHIP_TYPE = new FhirCodeSystems("document-relationship-type");

    public static final FhirCodeSystems DOSE_RATE_TYPE = new FhirCodeSystems("dose-rate-type");

    public static final FhirCodeSystems DURATION_UNITS = new FhirCodeSystems("duration-units");

    public static final FhirCodeSystems EFFECT_ESTIMATE_TYPE = new FhirCodeSystems("effect-estimate-type");

    public static final FhirCodeSystems ELIGIBILITYREQUEST_PURPOSE = new FhirCodeSystems("eligibilityrequest-purpose");

    public static final FhirCodeSystems ELIGIBILITYRESPONSE_PURPOSE = new FhirCodeSystems("eligibilityresponse-purpose");

    public static final FhirCodeSystems ENCOUNTER_ADMIT_SOURCE = new FhirCodeSystems("encounter-admit-source");

    public static final FhirCodeSystems ENCOUNTER_DIET = new FhirCodeSystems("encounter-diet");

    public static final FhirCodeSystems ENCOUNTER_DISCHARGE_DISPOSITION = new FhirCodeSystems("encounter-discharge-disposition");

    public static final FhirCodeSystems ENCOUNTER_LOCATION_STATUS = new FhirCodeSystems("encounter-location-status");

    public static final FhirCodeSystems ENCOUNTER_PARTICIPANT_TYPE = new FhirCodeSystems("encounter-participant-type");

    public static final FhirCodeSystems ENCOUNTER_REASON = new FhirCodeSystems("encounter-reason");

    public static final FhirCodeSystems ENCOUNTER_SPECIAL_ARRANGEMENTS = new FhirCodeSystems("encounter-special-arrangements");

    public static final FhirCodeSystems ENCOUNTER_SPECIAL_COURTESY = new FhirCodeSystems("encounter-special-courtesy");

    public static final FhirCodeSystems ENCOUNTER_STATUS = new FhirCodeSystems("encounter-status");

    public static final FhirCodeSystems ENCOUNTER_TYPE = new FhirCodeSystems("encounter-type");

    public static final FhirCodeSystems ENDPOINT_CONNECTION_TYPE = new FhirCodeSystems("endpoint-connection-type");

    public static final FhirCodeSystems ENDPOINT_PAYLOAD_TYPE = new FhirCodeSystems("endpoint-payload-type");

    public static final FhirCodeSystems ENDPOINT_STATUS = new FhirCodeSystems("endpoint-status");

    public static final FhirCodeSystems ENSEMBL = new FhirCodeSystems("ensembl");

    public static final FhirCodeSystems ENTERAL_ROUTE = new FhirCodeSystems("enteral-route");

    public static final FhirCodeSystems ENTFORMULA_ADDITIVE = new FhirCodeSystems("entformula-additive");

    public static final FhirCodeSystems ENTFORMULA_TYPE = new FhirCodeSystems("entformula-type");

    public static final FhirCodeSystems EPISODE_OF_CARE_STATUS = new FhirCodeSystems("episode-of-care-status");

    public static final FhirCodeSystems EPISODEOFCARE_TYPE = new FhirCodeSystems("episodeofcare-type");

    public static final FhirCodeSystems EVENT_CAPABILITY_MODE = new FhirCodeSystems("event-capability-mode");

    public static final FhirCodeSystems EVENT_OR_REQUEST_RESOURCE_TYPES = new FhirCodeSystems("event-or-request-resource-types");

    public static final FhirCodeSystems EVENT_RESOURCE_TYPES = new FhirCodeSystems("event-resource-types");

    public static final FhirCodeSystems EVENT_STATUS = new FhirCodeSystems("event-status");

    public static final FhirCodeSystems EVENT_TIMING = new FhirCodeSystems("event-timing");

    public static final FhirCodeSystems EVIDENCE_QUALITY = new FhirCodeSystems("evidence-quality");

    public static final FhirCodeSystems EVIDENCE_VARIANT_STATE = new FhirCodeSystems("evidence-variant-state");

    public static final FhirCodeSystems EX_BENEFITCATEGORY = new FhirCodeSystems("ex-benefitcategory");

    public static final FhirCodeSystems EX_DIAGNOSIS_ON_ADMISSION = new FhirCodeSystems("ex-diagnosis-on-admission");

    public static final FhirCodeSystems EX_DIAGNOSISRELATEDGROUP = new FhirCodeSystems("ex-diagnosisrelatedgroup");

    public static final FhirCodeSystems EX_DIAGNOSISTYPE = new FhirCodeSystems("ex-diagnosistype");

    public static final FhirCodeSystems EX_ONSETTYPE = new FhirCodeSystems("ex-onsettype");

    public static final FhirCodeSystems EX_PAYEE_RESOURCE_TYPE = new FhirCodeSystems("ex-payee-resource-type");

    public static final FhirCodeSystems EX_PAYMENTTYPE = new FhirCodeSystems("ex-paymenttype");

    public static final FhirCodeSystems EX_PROCEDURE_TYPE = new FhirCodeSystems("ex-procedure-type");

    public static final FhirCodeSystems EX_PROGRAM_CODE = new FhirCodeSystems("ex-program-code");

    public static final FhirCodeSystems EX_REVENUE_CENTER = new FhirCodeSystems("ex-revenue-center");

    public static final FhirCodeSystems EXAMPLE_EXPANSION = new FhirCodeSystems("example-expansion");

    public static final FhirCodeSystems EXAMPLE_EXTENSIONAL = new FhirCodeSystems("example-extensional");

    public static final FhirCodeSystems EXAMPLE_FILTER = new FhirCodeSystems("example-filter");

    public static final FhirCodeSystems EXAMPLE_HIERARCHICAL = new FhirCodeSystems("example-hierarchical");

    public static final FhirCodeSystems EXAMPLE_INTENSIONAL = new FhirCodeSystems("example-intensional");

    public static final FhirCodeSystems EXAMPLESCENARIO_ACTOR_TYPE = new FhirCodeSystems("examplescenario-actor-type");

    public static final FhirCodeSystems EXPANSION_PARAMETER_SOURCE = new FhirCodeSystems("expansion-parameter-source");

    public static final FhirCodeSystems EXPANSION_PROCESSING_RULE = new FhirCodeSystems("expansion-processing-rule");

    public static final FhirCodeSystems EXPLANATIONOFBENEFIT_STATUS = new FhirCodeSystems("explanationofbenefit-status");

    public static final FhirCodeSystems EXPOSURE_STATE = new FhirCodeSystems("exposure-state");

    public static final FhirCodeSystems EXPRESSION_LANGUAGE = new FhirCodeSystems("expression-language");

    public static final FhirCodeSystems EXTENSION_CONTEXT_TYPE = new FhirCodeSystems("extension-context-type");

    public static final FhirCodeSystems FEEDING_DEVICE = new FhirCodeSystems("feeding-device");

    public static final FhirCodeSystems FILTER_OPERATOR = new FhirCodeSystems("filter-operator");

    public static final FhirCodeSystems FINANCIAL_TASKCODE = new FhirCodeSystems("financial-taskcode");

    public static final FhirCodeSystems FINANCIAL_TASKINPUTTYPE = new FhirCodeSystems("financial-taskinputtype");

    public static final FhirCodeSystems FLAG_CATEGORY = new FhirCodeSystems("flag-category");

    public static final FhirCodeSystems FLAG_CODE = new FhirCodeSystems("flag-code");

    public static final FhirCodeSystems FLAG_PRIORITY = new FhirCodeSystems("flag-priority");

    public static final FhirCodeSystems FLAG_STATUS = new FhirCodeSystems("flag-status");

    public static final FhirCodeSystems FM_CONDITIONS = new FhirCodeSystems("fm-conditions");

    public static final FhirCodeSystems FM_ITEMTYPE = new FhirCodeSystems("fm-itemtype");

    public static final FhirCodeSystems FM_STATUS = new FhirCodeSystems("fm-status");

    public static final FhirCodeSystems FOCAL_SUBJECT = new FhirCodeSystems("focal-subject");

    public static final FhirCodeSystems FOOD_TYPE = new FhirCodeSystems("food-type");

    public static final FhirCodeSystems FORMATCODES = new FhirCodeSystems("formatcodes");

    public static final FhirCodeSystems FORMS = new FhirCodeSystems("forms");

    public static final FhirCodeSystems FUNDSRESERVE = new FhirCodeSystems("fundsreserve");

    public static final FhirCodeSystems GENDER_IDENTITY = new FhirCodeSystems("gender-identity");

    public static final FhirCodeSystems GENENAMES = new FhirCodeSystems("genenames");

    public static final FhirCodeSystems GOAL_ACCEPTANCE_STATUS = new FhirCodeSystems("goal-acceptance-status");

    public static final FhirCodeSystems GOAL_ACHIEVEMENT = new FhirCodeSystems("goal-achievement");

    public static final FhirCodeSystems GOAL_CATEGORY = new FhirCodeSystems("goal-category");

    public static final FhirCodeSystems GOAL_PRIORITY = new FhirCodeSystems("goal-priority");

    public static final FhirCodeSystems GOAL_RELATIONSHIP_TYPE = new FhirCodeSystems("goal-relationship-type");

    public static final FhirCodeSystems GOAL_START_EVENT = new FhirCodeSystems("goal-start-event");

    public static final FhirCodeSystems GOAL_STATUS = new FhirCodeSystems("goal-status");

    public static final FhirCodeSystems GOAL_STATUS_REASON = new FhirCodeSystems("goal-status-reason");

    public static final FhirCodeSystems GRAPH_COMPARTMENT_RULE = new FhirCodeSystems("graph-compartment-rule");

    public static final FhirCodeSystems GRAPH_COMPARTMENT_USE = new FhirCodeSystems("graph-compartment-use");

    public static final FhirCodeSystems GROUP_MEASURE = new FhirCodeSystems("group-measure");

    public static final FhirCodeSystems GROUP_TYPE = new FhirCodeSystems("group-type");

    public static final FhirCodeSystems GUIDANCE_RESPONSE_STATUS = new FhirCodeSystems("guidance-response-status");

    public static final FhirCodeSystems GUIDE_PAGE_GENERATION = new FhirCodeSystems("guide-page-generation");

    public static final FhirCodeSystems GUIDE_PARAMETER_CODE = new FhirCodeSystems("guide-parameter-code");

    public static final FhirCodeSystems HANDLING_CONDITION = new FhirCodeSystems("handling-condition");

    public static final FhirCodeSystems HISTORY_ABSENT_REASON = new FhirCodeSystems("history-absent-reason");

    public static final FhirCodeSystems HISTORY_STATUS = new FhirCodeSystems("history-status");

    public static final FhirCodeSystems HL7_WORK_GROUP = new FhirCodeSystems("hl7-work-group");

    public static final FhirCodeSystems HTTP_OPERATIONS = new FhirCodeSystems("http-operations");

    public static final FhirCodeSystems HTTP_VERB = new FhirCodeSystems("http-verb");

    public static final FhirCodeSystems ICD_10 = new FhirCodeSystems("icd-10");

    public static final FhirCodeSystems ICD_10_PROCEDURES = new FhirCodeSystems("icd-10-procedures");

    public static final FhirCodeSystems IDENTIFIER_TYPE = new FhirCodeSystems("identifier-type");

    public static final FhirCodeSystems IDENTIFIER_USE = new FhirCodeSystems("identifier-use");

    public static final FhirCodeSystems IDENTITY_ASSURANCELEVEL = new FhirCodeSystems("identity-assuranceLevel");

    public static final FhirCodeSystems IMAGINGSTUDY_STATUS = new FhirCodeSystems("imagingstudy-status");

    public static final FhirCodeSystems IMMUNIZATION_EVALUATION_DOSE_STATUS = new FhirCodeSystems("immunization-evaluation-dose-status");

    public static final FhirCodeSystems IMMUNIZATION_EVALUATION_DOSE_STATUS_REASON = new FhirCodeSystems("immunization-evaluation-dose-status-reason");

    public static final FhirCodeSystems IMMUNIZATION_EVALUATION_STATUS = new FhirCodeSystems("immunization-evaluation-status");

    public static final FhirCodeSystems IMMUNIZATION_EVALUATION_TARGET_DISEASE = new FhirCodeSystems("immunization-evaluation-target-disease");

    public static final FhirCodeSystems IMMUNIZATION_FUNCTION = new FhirCodeSystems("immunization-function");

    public static final FhirCodeSystems IMMUNIZATION_FUNDING_SOURCE = new FhirCodeSystems("immunization-funding-source");

    public static final FhirCodeSystems IMMUNIZATION_ORIGIN = new FhirCodeSystems("immunization-origin");

    public static final FhirCodeSystems IMMUNIZATION_PROGRAM_ELIGIBILITY = new FhirCodeSystems("immunization-program-eligibility");

    public static final FhirCodeSystems IMMUNIZATION_REASON = new FhirCodeSystems("immunization-reason");

    public static final FhirCodeSystems IMMUNIZATION_RECOMMENDATION_DATE_CRITERION = new FhirCodeSystems("immunization-recommendation-date-criterion");

    public static final FhirCodeSystems IMMUNIZATION_RECOMMENDATION_REASON = new FhirCodeSystems("immunization-recommendation-reason");

    public static final FhirCodeSystems IMMUNIZATION_RECOMMENDATION_STATUS = new FhirCodeSystems("immunization-recommendation-status");

    public static final FhirCodeSystems IMMUNIZATION_RECOMMENDATION_TARGET_DISEASE = new FhirCodeSystems("immunization-recommendation-target-disease");

    public static final FhirCodeSystems IMMUNIZATION_ROUTE = new FhirCodeSystems("immunization-route");

    public static final FhirCodeSystems IMMUNIZATION_SITE = new FhirCodeSystems("immunization-site");

    public static final FhirCodeSystems IMMUNIZATION_STATUS = new FhirCodeSystems("immunization-status");

    public static final FhirCodeSystems IMMUNIZATION_STATUS_REASON = new FhirCodeSystems("immunization-status-reason");

    public static final FhirCodeSystems IMMUNIZATION_SUBPOTENT_REASON = new FhirCodeSystems("immunization-subpotent-reason");

    public static final FhirCodeSystems IMMUNIZATION_TARGET_DISEASE = new FhirCodeSystems("immunization-target-disease");

    public static final FhirCodeSystems IMPLANTSTATUS = new FhirCodeSystems("implantStatus");

    public static final FhirCodeSystems INACTIVE = new FhirCodeSystems("inactive");

    public static final FhirCodeSystems INSTANCE_AVAILABILITY = new FhirCodeSystems("instance-availability");

    public static final FhirCodeSystems INSURANCEPLAN_APPLICABILITY = new FhirCodeSystems("insuranceplan-applicability");

    public static final FhirCodeSystems INSURANCEPLAN_TYPE = new FhirCodeSystems("insuranceplan-type");

    public static final FhirCodeSystems INTERVENTION = new FhirCodeSystems("intervention");

    public static final FhirCodeSystems INVESTIGATION_SETS = new FhirCodeSystems("investigation-sets");

    public static final FhirCodeSystems INVOICE_PRICECOMPONENTTYPE = new FhirCodeSystems("invoice-priceComponentType");

    public static final FhirCodeSystems INVOICE_STATUS = new FhirCodeSystems("invoice-status");

    public static final FhirCodeSystems ISO3166_1_2 = new FhirCodeSystems("iso3166-1-2");

    public static final FhirCodeSystems ISO3166_1_3 = new FhirCodeSystems("iso3166-1-3");

    public static final FhirCodeSystems ISO3166_1_N = new FhirCodeSystems("iso3166-1-N");

    public static final FhirCodeSystems ISSUE_SEVERITY = new FhirCodeSystems("issue-severity");

    public static final FhirCodeSystems ISSUE_TYPE = new FhirCodeSystems("issue-type");

    public static final FhirCodeSystems ITEM_TYPE = new FhirCodeSystems("item-type");

    public static final FhirCodeSystems JURISDICTION = new FhirCodeSystems("jurisdiction");

    public static final FhirCodeSystems KNOWLEDGE_RESOURCE_TYPES = new FhirCodeSystems("knowledge-resource-types");

    public static final FhirCodeSystems LANGUAGE_PREFERENCE_TYPE = new FhirCodeSystems("language-preference-type");

    public static final FhirCodeSystems LANGUAGES = new FhirCodeSystems("languages");

    public static final FhirCodeSystems LDLCHOLESTEROL_CODES = new FhirCodeSystems("ldlcholesterol-codes");

    public static final FhirCodeSystems LIBRARY_TYPE = new FhirCodeSystems("library-type");

    public static final FhirCodeSystems LINK_TYPE = new FhirCodeSystems("link-type");

    public static final FhirCodeSystems LINKAGE_TYPE = new FhirCodeSystems("linkage-type");

    public static final FhirCodeSystems LIST_EMPTY_REASON = new FhirCodeSystems("list-empty-reason");

    public static final FhirCodeSystems LIST_EXAMPLE_CODES = new FhirCodeSystems("list-example-codes");

    public static final FhirCodeSystems LIST_ITEM_FLAG = new FhirCodeSystems("list-item-flag");

    public static final FhirCodeSystems LIST_MODE = new FhirCodeSystems("list-mode");

    public static final FhirCodeSystems LIST_ORDER = new FhirCodeSystems("list-order");

    public static final FhirCodeSystems LIST_STATUS = new FhirCodeSystems("list-status");

    public static final FhirCodeSystems LOCATION_MODE = new FhirCodeSystems("location-mode");

    public static final FhirCodeSystems LOCATION_PHYSICAL_TYPE = new FhirCodeSystems("location-physical-type");

    public static final FhirCodeSystems LOCATION_STATUS = new FhirCodeSystems("location-status");

    public static final FhirCodeSystems MANIFESTATION_OR_SYMPTOM = new FhirCodeSystems("manifestation-or-symptom");

    public static final FhirCodeSystems MAP_CONTEXT_TYPE = new FhirCodeSystems("map-context-type");

    public static final FhirCodeSystems MAP_GROUP_TYPE_MODE = new FhirCodeSystems("map-group-type-mode");

    public static final FhirCodeSystems MAP_INPUT_MODE = new FhirCodeSystems("map-input-mode");

    public static final FhirCodeSystems MAP_MODEL_MODE = new FhirCodeSystems("map-model-mode");

    public static final FhirCodeSystems MAP_SOURCE_LIST_MODE = new FhirCodeSystems("map-source-list-mode");

    public static final FhirCodeSystems MAP_TARGET_LIST_MODE = new FhirCodeSystems("map-target-list-mode");

    public static final FhirCodeSystems MAP_TRANSFORM = new FhirCodeSystems("map-transform");

    public static final FhirCodeSystems MARITAL_STATUS = new FhirCodeSystems("marital-status");

    public static final FhirCodeSystems MATCH_GRADE = new FhirCodeSystems("match-grade");

    public static final FhirCodeSystems MEASURE_DATA_USAGE = new FhirCodeSystems("measure-data-usage");

    public static final FhirCodeSystems MEASURE_IMPROVEMENT_NOTATION = new FhirCodeSystems("measure-improvement-notation");

    public static final FhirCodeSystems MEASURE_POPULATION = new FhirCodeSystems("measure-population");

    public static final FhirCodeSystems MEASURE_REPORT_STATUS = new FhirCodeSystems("measure-report-status");

    public static final FhirCodeSystems MEASURE_REPORT_TYPE = new FhirCodeSystems("measure-report-type");

    public static final FhirCodeSystems MEASURE_SCORING = new FhirCodeSystems("measure-scoring");

    public static final FhirCodeSystems MEASURE_TYPE = new FhirCodeSystems("measure-type");

    public static final FhirCodeSystems MED_ADMIN_PERFORM_FUNCTION = new FhirCodeSystems("med-admin-perform-function");

    public static final FhirCodeSystems MEDIA_MODALITY = new FhirCodeSystems("media-modality");

    public static final FhirCodeSystems MEDIA_TYPE = new FhirCodeSystems("media-type");

    public static final FhirCodeSystems MEDIA_VIEW = new FhirCodeSystems("media-view");

    public static final FhirCodeSystems MEDICATION_ADMIN_CATEGORY = new FhirCodeSystems("medication-admin-category");

    public static final FhirCodeSystems MEDICATION_ADMIN_STATUS = new FhirCodeSystems("medication-admin-status");

    public static final FhirCodeSystems MEDICATION_AS_NEEDED_REASON = new FhirCodeSystems("medication-as-needed-reason");

    public static final FhirCodeSystems MEDICATION_CODES = new FhirCodeSystems("medication-codes");

    public static final FhirCodeSystems MEDICATION_FORM_CODES = new FhirCodeSystems("medication-form-codes");

    public static final FhirCodeSystems MEDICATION_STATEMENT_CATEGORY = new FhirCodeSystems("medication-statement-category");

    public static final FhirCodeSystems MEDICATION_STATEMENT_STATUS = new FhirCodeSystems("medication-statement-status");

    public static final FhirCodeSystems MEDICATION_STATUS = new FhirCodeSystems("medication-status");

    public static final FhirCodeSystems MEDICATIONDISPENSE_CATEGORY = new FhirCodeSystems("medicationdispense-category");

    public static final FhirCodeSystems MEDICATIONDISPENSE_PERFORMER_FUNCTION = new FhirCodeSystems("medicationdispense-performer-function");

    public static final FhirCodeSystems MEDICATIONDISPENSE_STATUS = new FhirCodeSystems("medicationdispense-status");

    public static final FhirCodeSystems MEDICATIONDISPENSE_STATUS_REASON = new FhirCodeSystems("medicationdispense-status-reason");

    public static final FhirCodeSystems MEDICATIONKNOWLEDGE_CHARACTERISTIC = new FhirCodeSystems("medicationknowledge-characteristic");

    public static final FhirCodeSystems MEDICATIONKNOWLEDGE_PACKAGE_TYPE = new FhirCodeSystems("medicationknowledge-package-type");

    public static final FhirCodeSystems MEDICATIONKNOWLEDGE_STATUS = new FhirCodeSystems("medicationknowledge-status");

    public static final FhirCodeSystems MEDICATIONREQUEST_CATEGORY = new FhirCodeSystems("medicationrequest-category");

    public static final FhirCodeSystems MEDICATIONREQUEST_COURSE_OF_THERAPY = new FhirCodeSystems("medicationrequest-course-of-therapy");

    public static final FhirCodeSystems MEDICATIONREQUEST_INTENT = new FhirCodeSystems("medicationrequest-intent");

    public static final FhirCodeSystems MEDICATIONREQUEST_STATUS = new FhirCodeSystems("medicationrequest-status");

    public static final FhirCodeSystems MEDICATIONREQUEST_STATUS_REASON = new FhirCodeSystems("medicationrequest-status-reason");

    public static final FhirCodeSystems MESSAGE_EVENTS = new FhirCodeSystems("message-events");

    public static final FhirCodeSystems MESSAGE_REASON_ENCOUNTER = new FhirCodeSystems("message-reason-encounter");

    public static final FhirCodeSystems MESSAGE_SIGNIFICANCE_CATEGORY = new FhirCodeSystems("message-significance-category");

    public static final FhirCodeSystems MESSAGE_TRANSPORT = new FhirCodeSystems("message-transport");

    public static final FhirCodeSystems MESSAGEHEADER_RESPONSE_REQUEST = new FhirCodeSystems("messageheader-response-request");

    public static final FhirCodeSystems METRIC_CALIBRATION_STATE = new FhirCodeSystems("metric-calibration-state");

    public static final FhirCodeSystems METRIC_CALIBRATION_TYPE = new FhirCodeSystems("metric-calibration-type");

    public static final FhirCodeSystems METRIC_CATEGORY = new FhirCodeSystems("metric-category");

    public static final FhirCodeSystems METRIC_COLOR = new FhirCodeSystems("metric-color");

    public static final FhirCodeSystems METRIC_OPERATIONAL_STATUS = new FhirCodeSystems("metric-operational-status");

    public static final FhirCodeSystems MIMETYPES = new FhirCodeSystems("mimetypes");

    public static final FhirCodeSystems MISSING_TOOTH_REASON = new FhirCodeSystems("missing-tooth-reason");

    public static final FhirCodeSystems MODIFIED_FOODTYPE = new FhirCodeSystems("modified-foodtype");

    public static final FhirCodeSystems NAME_ASSEMBLY_ORDER = new FhirCodeSystems("name-assembly-order");

    public static final FhirCodeSystems NAME_PART_QUALIFIER = new FhirCodeSystems("name-part-qualifier");

    public static final FhirCodeSystems NAME_USE = new FhirCodeSystems("name-use");

    public static final FhirCodeSystems NAME_V3_REPRESENTATION = new FhirCodeSystems("name-v3-representation");

    public static final FhirCodeSystems NAMINGSYSTEM_IDENTIFIER_TYPE = new FhirCodeSystems("namingsystem-identifier-type");

    public static final FhirCodeSystems NAMINGSYSTEM_TYPE = new FhirCodeSystems("namingsystem-type");

    public static final FhirCodeSystems NARRATIVE_STATUS = new FhirCodeSystems("narrative-status");

    public static final FhirCodeSystems NETWORK_TYPE = new FhirCodeSystems("network-type");

    public static final FhirCodeSystems NHIN_PURPOSEOFUSE = new FhirCodeSystems("nhin-purposeofuse");

    public static final FhirCodeSystems NOTE_TYPE = new FhirCodeSystems("note-type");

    public static final FhirCodeSystems NUTRIENT_CODE = new FhirCodeSystems("nutrient-code");

    public static final FhirCodeSystems OBJECT_LIFECYCLE_EVENTS = new FhirCodeSystems("object-lifecycle-events");

    public static final FhirCodeSystems OBJECT_ROLE = new FhirCodeSystems("object-role");

    public static final FhirCodeSystems OBSERVATION_CATEGORY = new FhirCodeSystems("observation-category");

    public static final FhirCodeSystems OBSERVATION_CODES = new FhirCodeSystems("observation-codes");

    public static final FhirCodeSystems OBSERVATION_INTERPRETATION = new FhirCodeSystems("observation-interpretation");

    public static final FhirCodeSystems OBSERVATION_METHODS = new FhirCodeSystems("observation-methods");

    public static final FhirCodeSystems OBSERVATION_RANGE_CATEGORY = new FhirCodeSystems("observation-range-category");

    public static final FhirCodeSystems OBSERVATION_STATISTICS = new FhirCodeSystems("observation-statistics");

    public static final FhirCodeSystems OBSERVATION_STATUS = new FhirCodeSystems("observation-status");

    public static final FhirCodeSystems OBSERVATION_VITALSIGNRESULT = new FhirCodeSystems("observation-vitalsignresult");

    public static final FhirCodeSystems OPERATION_KIND = new FhirCodeSystems("operation-kind");

    public static final FhirCodeSystems OPERATION_OUTCOME = new FhirCodeSystems("operation-outcome");

    public static final FhirCodeSystems OPERATION_PARAMETER_USE = new FhirCodeSystems("operation-parameter-use");

    public static final FhirCodeSystems ORAL_PROSTHODONTIC_MATERIAL = new FhirCodeSystems("oral-prosthodontic-material");

    public static final FhirCodeSystems ORGANIZATION_ROLE = new FhirCodeSystems("organization-role");

    public static final FhirCodeSystems ORGANIZATION_TYPE = new FhirCodeSystems("organization-type");

    public static final FhirCodeSystems ORIENTATION_TYPE = new FhirCodeSystems("orientation-type");

    public static final FhirCodeSystems PARAMETER_GROUP = new FhirCodeSystems("parameter-group");

    public static final FhirCodeSystems PARENT_RELATIONSHIP_CODES = new FhirCodeSystems("parent-relationship-codes");

    public static final FhirCodeSystems PARTICIPANT_ROLE = new FhirCodeSystems("participant-role");

    public static final FhirCodeSystems PARTICIPANTREQUIRED = new FhirCodeSystems("participantrequired");

    public static final FhirCodeSystems PARTICIPATION_ROLE_TYPE = new FhirCodeSystems("participation-role-type");

    public static final FhirCodeSystems PARTICIPATIONSTATUS = new FhirCodeSystems("participationstatus");

    public static final FhirCodeSystems PATIENT_CONTACTRELATIONSHIP = new FhirCodeSystems("patient-contactrelationship");

    public static final FhirCodeSystems PAYEETYPE = new FhirCodeSystems("payeetype");

    public static final FhirCodeSystems PAYMENT_ADJUSTMENT_REASON = new FhirCodeSystems("payment-adjustment-reason");

    public static final FhirCodeSystems PAYMENT_STATUS = new FhirCodeSystems("payment-status");

    public static final FhirCodeSystems PAYMENT_TYPE = new FhirCodeSystems("payment-type");

    public static final FhirCodeSystems PERFORMER_FUNCTION = new FhirCodeSystems("performer-function");

    public static final FhirCodeSystems PERFORMER_ROLE = new FhirCodeSystems("performer-role");

    public static final FhirCodeSystems PERMITTED_DATA_TYPE = new FhirCodeSystems("permitted-data-type");

    public static final FhirCodeSystems PLAN_DEFINITION_TYPE = new FhirCodeSystems("plan-definition-type");

    public static final FhirCodeSystems POSTAL_ADDRESS_USE = new FhirCodeSystems("postal-address-use");

    public static final FhirCodeSystems PRACTITIONER_ROLE = new FhirCodeSystems("practitioner-role");

    public static final FhirCodeSystems PRACTITIONER_SPECIALTY = new FhirCodeSystems("practitioner-specialty");

    public static final FhirCodeSystems PRECISION_ESTIMATE_TYPE = new FhirCodeSystems("precision-estimate-type");

    public static final FhirCodeSystems PREPARE_PATIENT_PRIOR_SPECIMEN_COLLECTION = new FhirCodeSystems("prepare-patient-prior-specimen-collection");

    public static final FhirCodeSystems PROBABILITY_DISTRIBUTION_TYPE = new FhirCodeSystems("probability-distribution-type");

    public static final FhirCodeSystems PROCEDURE_CATEGORY = new FhirCodeSystems("procedure-category");

    public static final FhirCodeSystems PROCEDURE_CODE = new FhirCodeSystems("procedure-code");

    public static final FhirCodeSystems PROCEDURE_FOLLOWUP = new FhirCodeSystems("procedure-followup");

    public static final FhirCodeSystems PROCEDURE_NOT_PERFORMED_REASON = new FhirCodeSystems("procedure-not-performed-reason");

    public static final FhirCodeSystems PROCEDURE_OUTCOME = new FhirCodeSystems("procedure-outcome");

    public static final FhirCodeSystems PROCEDURE_PROGRESS_STATUS_CODES = new FhirCodeSystems("procedure-progress-status-codes");

    public static final FhirCodeSystems PROCEDURE_REASON = new FhirCodeSystems("procedure-reason");

    public static final FhirCodeSystems PROCESS_PRIORITY = new FhirCodeSystems("process-priority");

    public static final FhirCodeSystems PRODUCT_CATEGORY = new FhirCodeSystems("product-category");

    public static final FhirCodeSystems PRODUCT_STATUS = new FhirCodeSystems("product-status");

    public static final FhirCodeSystems PRODUCT_STORAGE_SCALE = new FhirCodeSystems("product-storage-scale");

    public static final FhirCodeSystems PROGRAM = new FhirCodeSystems("program");

    public static final FhirCodeSystems PROPERTY_REPRESENTATION = new FhirCodeSystems("property-representation");

    public static final FhirCodeSystems PROVENANCE_ACTIVITY_TYPE = new FhirCodeSystems("provenance-activity-type");

    public static final FhirCodeSystems PROVENANCE_AGENT_ROLE = new FhirCodeSystems("provenance-agent-role");

    public static final FhirCodeSystems PROVENANCE_AGENT_TYPE = new FhirCodeSystems("provenance-agent-type");

    public static final FhirCodeSystems PROVENANCE_ENTITY_ROLE = new FhirCodeSystems("provenance-entity-role");

    public static final FhirCodeSystems PROVENANCE_HISTORY_AGENT_TYPE = new FhirCodeSystems("provenance-history-agent-type");

    public static final FhirCodeSystems PROVENANCE_HISTORY_RECORD_ACTIVITY = new FhirCodeSystems("provenance-history-record-activity");

    public static final FhirCodeSystems PROVIDER_QUALIFICATION = new FhirCodeSystems("provider-qualification");

    public static final FhirCodeSystems PROVIDER_TAXONOMY = new FhirCodeSystems("provider-taxonomy");

    public static final FhirCodeSystems PUBLICATION_STATUS = new FhirCodeSystems("publication-status");

    public static final FhirCodeSystems QUALITY_TYPE = new FhirCodeSystems("quality-type");

    public static final FhirCodeSystems QUANTITY_COMPARATOR = new FhirCodeSystems("quantity-comparator");

    public static final FhirCodeSystems QUESTION_MAX_OCCURS = new FhirCodeSystems("question-max-occurs");

    public static final FhirCodeSystems QUESTIONNAIRE_ANSWERS = new FhirCodeSystems("questionnaire-answers");

    public static final FhirCodeSystems QUESTIONNAIRE_ANSWERS_STATUS = new FhirCodeSystems("questionnaire-answers-status");

    public static final FhirCodeSystems QUESTIONNAIRE_CATEGORY = new FhirCodeSystems("questionnaire-category");

    public static final FhirCodeSystems QUESTIONNAIRE_DISPLAY_CATEGORY = new FhirCodeSystems("questionnaire-display-category");

    public static final FhirCodeSystems QUESTIONNAIRE_ENABLE_BEHAVIOR = new FhirCodeSystems("questionnaire-enable-behavior");

    public static final FhirCodeSystems QUESTIONNAIRE_ENABLE_OPERATOR = new FhirCodeSystems("questionnaire-enable-operator");

    public static final FhirCodeSystems QUESTIONNAIRE_ITEM_CONTROL = new FhirCodeSystems("questionnaire-item-control");

    public static final FhirCodeSystems QUESTIONNAIRE_QUESTIONS = new FhirCodeSystems("questionnaire-questions");

    public static final FhirCodeSystems QUESTIONNAIRE_USAGE_MODE = new FhirCodeSystems("questionnaire-usage-mode");

    public static final FhirCodeSystems QUESTIONNAIRERESPONSE_MODE = new FhirCodeSystems("questionnaireresponse-mode");

    public static final FhirCodeSystems REACTION_EVENT_CERTAINTY = new FhirCodeSystems("reaction-event-certainty");

    public static final FhirCodeSystems REACTION_EVENT_SEVERITY = new FhirCodeSystems("reaction-event-severity");

    public static final FhirCodeSystems REASON_MEDICATION_GIVEN_CODES = new FhirCodeSystems("reason-medication-given-codes");

    public static final FhirCodeSystems REASON_MEDICATION_NOT_GIVEN_CODES = new FhirCodeSystems("reason-medication-not-given-codes");

    public static final FhirCodeSystems REASON_MEDICATION_STATUS_CODES = new FhirCodeSystems("reason-medication-status-codes");

    public static final FhirCodeSystems RECOMMENDATION_STRENGTH = new FhirCodeSystems("recommendation-strength");

    public static final FhirCodeSystems REF_SEQUENCES = new FhirCodeSystems("ref-sequences");

    public static final FhirCodeSystems REFERENCE_HANDLING_POLICY = new FhirCodeSystems("reference-handling-policy");

    public static final FhirCodeSystems REFERENCE_VERSION_RULES = new FhirCodeSystems("reference-version-rules");

    public static final FhirCodeSystems REFERENCERANGE_APPLIESTO = new FhirCodeSystems("referencerange-appliesto");

    public static final FhirCodeSystems REFERENCERANGE_MEANING = new FhirCodeSystems("referencerange-meaning");

    public static final FhirCodeSystems REJECTION_CRITERIA = new FhirCodeSystems("rejection-criteria");

    public static final FhirCodeSystems RELATED_ARTIFACT_TYPE = new FhirCodeSystems("related-artifact-type");

    public static final FhirCodeSystems RELATED_CLAIM_RELATIONSHIP = new FhirCodeSystems("related-claim-relationship");

    public static final FhirCodeSystems RELATEDPERSON_RELATIONSHIPTYPE = new FhirCodeSystems("relatedperson-relationshiptype");

    public static final FhirCodeSystems RELATION_TYPE = new FhirCodeSystems("relation-type");

    public static final FhirCodeSystems RELATIONSHIP = new FhirCodeSystems("relationship");

    public static final FhirCodeSystems REMITTANCE_OUTCOME = new FhirCodeSystems("remittance-outcome");

    public static final FhirCodeSystems REPORT_ACTION_RESULT_CODES = new FhirCodeSystems("report-action-result-codes");

    public static final FhirCodeSystems REPORT_CODES = new FhirCodeSystems("report-codes");

    public static final FhirCodeSystems REPORT_PARTICIPANT_TYPE = new FhirCodeSystems("report-participant-type");

    public static final FhirCodeSystems REPORT_RESULT_CODES = new FhirCodeSystems("report-result-codes");

    public static final FhirCodeSystems REPORT_STATUS_CODES = new FhirCodeSystems("report-status-codes");

    public static final FhirCodeSystems REPOSITORY_TYPE = new FhirCodeSystems("repository-type");

    public static final FhirCodeSystems REQUEST_INTENT = new FhirCodeSystems("request-intent");

    public static final FhirCodeSystems REQUEST_PRIORITY = new FhirCodeSystems("request-priority");

    public static final FhirCodeSystems REQUEST_RESOURCE_TYPES = new FhirCodeSystems("request-resource-types");

    public static final FhirCodeSystems REQUEST_STATUS = new FhirCodeSystems("request-status");

    public static final FhirCodeSystems RESEARCH_ELEMENT_TYPE = new FhirCodeSystems("research-element-type");

    public static final FhirCodeSystems RESEARCH_STUDY_OBJECTIVE_TYPE = new FhirCodeSystems("research-study-objective-type");

    public static final FhirCodeSystems RESEARCH_STUDY_PHASE = new FhirCodeSystems("research-study-phase");

    public static final FhirCodeSystems RESEARCH_STUDY_PRIM_PURP_TYPE = new FhirCodeSystems("research-study-prim-purp-type");

    public static final FhirCodeSystems RESEARCH_STUDY_REASON_STOPPED = new FhirCodeSystems("research-study-reason-stopped");

    public static final FhirCodeSystems RESEARCH_STUDY_STATUS = new FhirCodeSystems("research-study-status");

    public static final FhirCodeSystems RESEARCH_SUBJECT_STATUS = new FhirCodeSystems("research-subject-status");

    public static final FhirCodeSystems RESOURCE_AGGREGATION_MODE = new FhirCodeSystems("resource-aggregation-mode");

    public static final FhirCodeSystems RESOURCE_SECURITY_CATEGORY = new FhirCodeSystems("resource-security-category");

    public static final FhirCodeSystems RESOURCE_SLICING_RULES = new FhirCodeSystems("resource-slicing-rules");

    public static final FhirCodeSystems RESOURCE_STATUS = new FhirCodeSystems("resource-status");

    public static final FhirCodeSystems RESOURCE_TYPE_LINK = new FhirCodeSystems("resource-type-link");

    public static final FhirCodeSystems RESOURCE_TYPES = new FhirCodeSystems("resource-types");

    public static final FhirCodeSystems RESOURCE_VALIDATION_MODE = new FhirCodeSystems("resource-validation-mode");

    public static final FhirCodeSystems RESPONSE_CODE = new FhirCodeSystems("response-code");

    public static final FhirCodeSystems RESTFUL_CAPABILITY_MODE = new FhirCodeSystems("restful-capability-mode");

    public static final FhirCodeSystems RESTFUL_SECURITY_SERVICE = new FhirCodeSystems("restful-security-service");

    public static final FhirCodeSystems RISK_ESTIMATE_TYPE = new FhirCodeSystems("risk-estimate-type");

    public static final FhirCodeSystems RISK_PROBABILITY = new FhirCodeSystems("risk-probability");

    public static final FhirCodeSystems ROUTE_CODES = new FhirCodeSystems("route-codes");

    public static final FhirCodeSystems SEARCH_COMPARATOR = new FhirCodeSystems("search-comparator");

    public static final FhirCodeSystems SEARCH_ENTRY_MODE = new FhirCodeSystems("search-entry-mode");

    public static final FhirCodeSystems SEARCH_MODIFIER_CODE = new FhirCodeSystems("search-modifier-code");

    public static final FhirCodeSystems SEARCH_PARAM_TYPE = new FhirCodeSystems("search-param-type");

    public static final FhirCodeSystems SEARCH_XPATH_USAGE = new FhirCodeSystems("search-xpath-usage");

    public static final FhirCodeSystems SECONDARY_FINDING = new FhirCodeSystems("secondary-finding");

    public static final FhirCodeSystems SECURITY_LABELS = new FhirCodeSystems("security-labels");

    public static final FhirCodeSystems SECURITY_ROLE_TYPE = new FhirCodeSystems("security-role-type");

    public static final FhirCodeSystems SEQUENCE_QUALITY_METHOD = new FhirCodeSystems("sequence-quality-method");

    public static final FhirCodeSystems SEQUENCE_QUALITY_STANDARDSEQUENCE = new FhirCodeSystems("sequence-quality-standardSequence");

    public static final FhirCodeSystems SEQUENCE_REFERENCESEQ = new FhirCodeSystems("sequence-referenceSeq");

    public static final FhirCodeSystems SEQUENCE_SPECIES = new FhirCodeSystems("sequence-species");

    public static final FhirCodeSystems SEQUENCE_TYPE = new FhirCodeSystems("sequence-type");

    public static final FhirCodeSystems SEQUENCEONTOLOGY = new FhirCodeSystems("sequenceontology");

    public static final FhirCodeSystems SERIES_PERFORMER_FUNCTION = new FhirCodeSystems("series-performer-function");

    public static final FhirCodeSystems SERVICE_CATEGORY = new FhirCodeSystems("service-category");

    public static final FhirCodeSystems SERVICE_MODIFIERS = new FhirCodeSystems("service-modifiers");

    public static final FhirCodeSystems SERVICE_PHARMACY = new FhirCodeSystems("service-pharmacy");

    public static final FhirCodeSystems SERVICE_PLACE = new FhirCodeSystems("service-place");

    public static final FhirCodeSystems SERVICE_PRODUCT = new FhirCodeSystems("service-product");

    public static final FhirCodeSystems SERVICE_PROVISION_CONDITIONS = new FhirCodeSystems("service-provision-conditions");

    public static final FhirCodeSystems SERVICE_REFERRAL_METHOD = new FhirCodeSystems("service-referral-method");

    public static final FhirCodeSystems SERVICE_TYPE = new FhirCodeSystems("service-type");

    public static final FhirCodeSystems SERVICE_USCLS = new FhirCodeSystems("service-uscls");

    public static final FhirCodeSystems SERVICEREQUEST_CATEGORY = new FhirCodeSystems("servicerequest-category");

    public static final FhirCodeSystems SERVICEREQUEST_ORDERDETAIL = new FhirCodeSystems("servicerequest-orderdetail");

    public static final FhirCodeSystems SIBLING_RELATIONSHIP_CODES = new FhirCodeSystems("sibling-relationship-codes");

    public static final FhirCodeSystems SIGNATURE_TYPE = new FhirCodeSystems("signature-type");

    public static final FhirCodeSystems SLOTSTATUS = new FhirCodeSystems("slotstatus");

    public static final FhirCodeSystems SMART_CAPABILITIES = new FhirCodeSystems("smart-capabilities");

    public static final FhirCodeSystems SORT_DIRECTION = new FhirCodeSystems("sort-direction");

    public static final FhirCodeSystems SPDX_LICENSE = new FhirCodeSystems("spdx-license");

    public static final FhirCodeSystems SPECIAL_VALUES = new FhirCodeSystems("special-values");

    public static final FhirCodeSystems SPECIMEN_COLLECTION = new FhirCodeSystems("specimen-collection");

    public static final FhirCodeSystems SPECIMEN_COLLECTION_METHOD = new FhirCodeSystems("specimen-collection-method");

    public static final FhirCodeSystems SPECIMEN_COLLECTION_PRIORITY = new FhirCodeSystems("specimen-collection-priority");

    public static final FhirCodeSystems SPECIMEN_CONTAINED_PREFERENCE = new FhirCodeSystems("specimen-contained-preference");

    public static final FhirCodeSystems SPECIMEN_CONTAINER_TYPE = new FhirCodeSystems("specimen-container-type");

    public static final FhirCodeSystems SPECIMEN_PROCESSING_PROCEDURE = new FhirCodeSystems("specimen-processing-procedure");

    public static final FhirCodeSystems SPECIMEN_STATUS = new FhirCodeSystems("specimen-status");

    public static final FhirCodeSystems STANDARDS_STATUS = new FhirCodeSystems("standards-status");

    public static final FhirCodeSystems STRAND_TYPE = new FhirCodeSystems("strand-type");

    public static final FhirCodeSystems STRUCTURE_DEFINITION_KIND = new FhirCodeSystems("structure-definition-kind");

    public static final FhirCodeSystems STUDY_TYPE = new FhirCodeSystems("study-type");

    public static final FhirCodeSystems SUBJECT_TYPE = new FhirCodeSystems("subject-type");

    public static final FhirCodeSystems SUBSCRIBER_RELATIONSHIP = new FhirCodeSystems("subscriber-relationship");

    public static final FhirCodeSystems SUBSCRIPTION_CHANNEL_TYPE = new FhirCodeSystems("subscription-channel-type");

    public static final FhirCodeSystems SUBSCRIPTION_STATUS = new FhirCodeSystems("subscription-status");

    public static final FhirCodeSystems SUBSCRIPTION_TAG = new FhirCodeSystems("subscription-tag");

    public static final FhirCodeSystems SUBSTANCE_CATEGORY = new FhirCodeSystems("substance-category");

    public static final FhirCodeSystems SUBSTANCE_CODE = new FhirCodeSystems("substance-code");

    public static final FhirCodeSystems SUBSTANCE_STATUS = new FhirCodeSystems("substance-status");

    public static final FhirCodeSystems SUPPLEMENT_TYPE = new FhirCodeSystems("supplement-type");

    public static final FhirCodeSystems SUPPLY_ITEM = new FhirCodeSystems("supply-item");

    public static final FhirCodeSystems SUPPLYDELIVERY_STATUS = new FhirCodeSystems("supplydelivery-status");

    public static final FhirCodeSystems SUPPLYDELIVERY_TYPE = new FhirCodeSystems("supplydelivery-type");

    public static final FhirCodeSystems SUPPLYREQUEST_KIND = new FhirCodeSystems("supplyrequest-kind");

    public static final FhirCodeSystems SUPPLYREQUEST_REASON = new FhirCodeSystems("supplyrequest-reason");

    public static final FhirCodeSystems SUPPLYREQUEST_STATUS = new FhirCodeSystems("supplyrequest-status");

    public static final FhirCodeSystems SURFACE = new FhirCodeSystems("surface");

    public static final FhirCodeSystems SYNTHESIS_TYPE = new FhirCodeSystems("synthesis-type");

    public static final FhirCodeSystems SYSTEM_RESTFUL_INTERACTION = new FhirCodeSystems("system-restful-interaction");

    public static final FhirCodeSystems TASK_CODE = new FhirCodeSystems("task-code");

    public static final FhirCodeSystems TASK_INTENT = new FhirCodeSystems("task-intent");

    public static final FhirCodeSystems TASK_STATUS = new FhirCodeSystems("task-status");

    public static final FhirCodeSystems TEETH = new FhirCodeSystems("teeth");

    public static final FhirCodeSystems TEMPLATE_STATUS_CODE = new FhirCodeSystems("template-status-code");

    public static final FhirCodeSystems TESTSCRIPT_OPERATION_CODES = new FhirCodeSystems("testscript-operation-codes");

    public static final FhirCodeSystems TESTSCRIPT_PROFILE_DESTINATION_TYPES = new FhirCodeSystems("testscript-profile-destination-types");

    public static final FhirCodeSystems TESTSCRIPT_PROFILE_ORIGIN_TYPES = new FhirCodeSystems("testscript-profile-origin-types");

    public static final FhirCodeSystems TEXTURE_CODE = new FhirCodeSystems("texture-code");

    public static final FhirCodeSystems TIMEZONES = new FhirCodeSystems("timezones");

    public static final FhirCodeSystems TIMING_ABBREVIATION = new FhirCodeSystems("timing-abbreviation");

    public static final FhirCodeSystems TOOTH = new FhirCodeSystems("tooth");

    public static final FhirCodeSystems TRANSACTION_MODE = new FhirCodeSystems("transaction-mode");

    public static final FhirCodeSystems TRIGGER_TYPE = new FhirCodeSystems("trigger-type");

    public static final FhirCodeSystems TYPE_DERIVATION_RULE = new FhirCodeSystems("type-derivation-rule");

    public static final FhirCodeSystems TYPE_RESTFUL_INTERACTION = new FhirCodeSystems("type-restful-interaction");

    public static final FhirCodeSystems UCUM_BODYLENGTH = new FhirCodeSystems("ucum-bodylength");

    public static final FhirCodeSystems UCUM_BODYTEMP = new FhirCodeSystems("ucum-bodytemp");

    public static final FhirCodeSystems UCUM_BODYWEIGHT = new FhirCodeSystems("ucum-bodyweight");

    public static final FhirCodeSystems UCUM_COMMON = new FhirCodeSystems("ucum-common");

    public static final FhirCodeSystems UCUM_UNITS = new FhirCodeSystems("ucum-units");

    public static final FhirCodeSystems UCUM_VITALS_COMMON = new FhirCodeSystems("ucum-vitals-common");

    public static final FhirCodeSystems UDI = new FhirCodeSystems("udi");

    public static final FhirCodeSystems UDI_ENTRY_TYPE = new FhirCodeSystems("udi-entry-type");

    public static final FhirCodeSystems UNITS_OF_TIME = new FhirCodeSystems("units-of-time");

    public static final FhirCodeSystems UNKNOWN_CONTENT_CODE = new FhirCodeSystems("unknown-content-code");

    public static final FhirCodeSystems USAGE_CONTEXT_TYPE = new FhirCodeSystems("usage-context-type");

    public static final FhirCodeSystems USE_CONTEXT = new FhirCodeSystems("use-context");

    public static final FhirCodeSystems VACCINE_CODE = new FhirCodeSystems("vaccine-code");

    public static final FhirCodeSystems VARIABLE_TYPE = new FhirCodeSystems("variable-type");

    public static final FhirCodeSystems VARIANT_STATE = new FhirCodeSystems("variant-state");

    public static final FhirCodeSystems VARIANTS = new FhirCodeSystems("variants");

    public static final FhirCodeSystems VERIFICATIONRESULT_CAN_PUSH_UPDATES = new FhirCodeSystems("verificationresult-can-push-updates");

    public static final FhirCodeSystems VERIFICATIONRESULT_COMMUNICATION_METHOD = new FhirCodeSystems("verificationresult-communication-method");

    public static final FhirCodeSystems VERIFICATIONRESULT_FAILURE_ACTION = new FhirCodeSystems("verificationresult-failure-action");

    public static final FhirCodeSystems VERIFICATIONRESULT_NEED = new FhirCodeSystems("verificationresult-need");

    public static final FhirCodeSystems VERIFICATIONRESULT_PRIMARY_SOURCE_TYPE = new FhirCodeSystems("verificationresult-primary-source-type");

    public static final FhirCodeSystems VERIFICATIONRESULT_PUSH_TYPE_AVAILABLE = new FhirCodeSystems("verificationresult-push-type-available");

    public static final FhirCodeSystems VERIFICATIONRESULT_STATUS = new FhirCodeSystems("verificationresult-status");

    public static final FhirCodeSystems VERIFICATIONRESULT_VALIDATION_PROCESS = new FhirCodeSystems("verificationresult-validation-process");

    public static final FhirCodeSystems VERIFICATIONRESULT_VALIDATION_STATUS = new FhirCodeSystems("verificationresult-validation-status");

    public static final FhirCodeSystems VERIFICATIONRESULT_VALIDATION_TYPE = new FhirCodeSystems("verificationresult-validation-type");

    public static final FhirCodeSystems VERSIONING_POLICY = new FhirCodeSystems("versioning-policy");

    public static final FhirCodeSystems VISION_BASE_CODES = new FhirCodeSystems("vision-base-codes");

    public static final FhirCodeSystems VISION_EYE_CODES = new FhirCodeSystems("vision-eye-codes");

    public static final FhirCodeSystems VISION_PRODUCT = new FhirCodeSystems("vision-product");

    public static final FhirCodeSystems WRITTEN_LANGUAGE = new FhirCodeSystems("written-language");

    public static final FhirCodeSystems YESNODONTKNOW = new FhirCodeSystems("yesnodontknow");

    private static final PseudoEnumDelegate<FhirCodeSystems> delegate = new PseudoEnumDelegate<>(FhirCodeSystems.class);

    static {
        CodeSystemRegistry.registerCodeSystems(delegate.values());
    }

    /**
     * Converts a code system to a pre-R4 legacy code system.
     *
     * @param codeSystem The code system to convert.
     * @return The converted code system (same as original if no conversion is required).
     */
    public static String toLegacyCodeSystem(String codeSystem) {
        if (codeSystem.startsWith(FHIR_CODESYSTEM_PREFIX)) {
            codeSystem = StringUtils.removeStart(codeSystem, FHIR_CODESYSTEM_PREFIX);

            if (VERSION_PREFIX_REGEX.matcher(codeSystem).matches()) {
                codeSystem = codeSystem.replaceFirst("-", "/");
            }

            codeSystem = LEGACY_CODESYSTEM_PREFIX + codeSystem;
        }

        return codeSystem;
    }

    /**
     * Converts a legacy code system to a post-STU3 code system.
     *
     * @param codeSystem The code system to convert.
     * @return The converted code system (same as original if no conversion is required).
     */
    public static String fromLegacyCodeSystem(String codeSystem) {
        if (codeSystem != null && codeSystem.startsWith(LEGACY_CODESYSTEM_PREFIX)) {
            String newSystem = StringUtils.removeStart(codeSystem, LEGACY_CODESYSTEM_PREFIX);

            if (newSystem.startsWith("sid/")) {
                return codeSystem;
            }

            if (VERSION_PREFIX_REGEX.matcher(newSystem).matches()) {
                newSystem = newSystem.replaceFirst("/", "-");
            }

            codeSystem = FHIR_CODESYSTEM_PREFIX + newSystem;
        }

        return codeSystem;
    }

    public static List<FhirCodeSystems> values() {
        return delegate.values();
    }

    public static List<String> names() {
        return delegate.names();
    }

    public static FhirCodeSystems valueOf(String name) {
        return delegate.valueOf(name);
    }

    public static FhirCodeSystems valueOf(
            String name,
            boolean exceptionIfNotFound) {
        return delegate.valueOf(name, exceptionIfNotFound);
    }

    private FhirCodeSystems(
            String uri,
            String... oids) {
        super(URI.create(FHIR_CODESYSTEM_PREFIX + uri), null, null, oids);
        CodeSystemRegistry.registerCodeSystemNormalization(LEGACY_CODESYSTEM_PREFIX + uri, this);
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
