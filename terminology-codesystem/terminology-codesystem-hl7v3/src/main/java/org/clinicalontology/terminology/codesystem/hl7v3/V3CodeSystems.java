package org.clinicalontology.terminology.codesystem.hl7v3;

import org.clinicalontology.terminology.api.model.CodeSystemEnumerator;
import org.clinicalontology.terminology.api.model.CodeSystemRegistry;
import org.clinicalontology.terminology.impl.model.CodeSystemImpl;

import java.net.URI;
import java.util.List;

/**
 * HL7 v3 code systems.
 */
public final class V3CodeSystems extends CodeSystemImpl {

    public static final V3CodeSystems AcknowledgementCondition = new V3CodeSystems("AcknowledgementCondition", "1050");

    public static final V3CodeSystems AcknowledgementDetailCode = new V3CodeSystems("AcknowledgementDetailCode", "1100");

    public static final V3CodeSystems AcknowledgementDetailType = new V3CodeSystems("AcknowledgementDetailType", "1082");

    public static final V3CodeSystems AcknowledgementType = new V3CodeSystems("AcknowledgementType", "18");

    public static final V3CodeSystems ActClass = new V3CodeSystems("ActClass", "6");

    public static final V3CodeSystems ActCode = new V3CodeSystems("ActCode", "4");

    public static final V3CodeSystems ActMood = new V3CodeSystems("ActMood", "1001");

    public static final V3CodeSystems ActPriority = new V3CodeSystems("ActPriority", "7");

    public static final V3CodeSystems ActReason = new V3CodeSystems("ActReason", "8");

    public static final V3CodeSystems ActRelationshipType = new V3CodeSystems("ActRelationshipType", "1002");

    public static final V3CodeSystems ActStatus = new V3CodeSystems("ActStatus", "14");

    public static final V3CodeSystems AddressUse = new V3CodeSystems("AddressUse", "1119");

    public static final V3CodeSystems AdministrativeGender = new V3CodeSystems("AdministrativeGender", "1");

    public static final V3CodeSystems Confidentiality = new V3CodeSystems("Confidentiality", "25");

    public static final V3CodeSystems EntityNamePartQualifier = new V3CodeSystems("EntityNamePartQualifier", "43");

    public static final V3CodeSystems EntityNameUse = new V3CodeSystems("EntityNameUse", "45");

    public static final V3CodeSystems GtsAbbreviation = new V3CodeSystems("GTSAbbreviation", "1022");

    public static final V3CodeSystems LanguageAbilityMode = new V3CodeSystems("LanguageAbilityMode", "60");

    public static final V3CodeSystems LanguageAbilityProficiency = new V3CodeSystems("LanguageAbilityProficiency", "61");

    public static final V3CodeSystems LivingArrangement = new V3CodeSystems("LivingArrangement", "63");

    public static final V3CodeSystems MaritalStatus = new V3CodeSystems("MaritalStatus", "2");

    public static final V3CodeSystems MediaType = new V3CodeSystems("MediaType", "79");

    public static final V3CodeSystems NullFlavor = new V3CodeSystems("NullFlavor", "1008");

    public static final V3CodeSystems ObservationInterpretation = new V3CodeSystems("ObservationInterpretation", "83");

    public static final V3CodeSystems ObservationValue = new V3CodeSystems("ObservationValue", "1063");

    public static final V3CodeSystems ParticipationFunction = new V3CodeSystems("ParticipationFunction", "88");

    public static final V3CodeSystems ParticipationMode = new V3CodeSystems("ParticipationMode", "1064");

    public static final V3CodeSystems ParticipationType = new V3CodeSystems("ParticipationType", "90");

    public static final V3CodeSystems Race = new V3CodeSystems("Race", "104");

    public static final V3CodeSystems ReligiousAffiliation = new V3CodeSystems("ReligiousAffiliation", "1076");

    public static final V3CodeSystems RoleClass = new V3CodeSystems("RoleClass", "110");

    public static final V3CodeSystems RoleCode = new V3CodeSystems("RoleCode", "111");

    public static final V3CodeSystems RoleStatus = new V3CodeSystems("RoleStatus", "1068");

    private static final String V3_CODESYSTEM_PREFIX = "http://terminology.hl7.org/CodeSystem/v3-";

    private static final String LEGACY_CODESYSTEM_PREFIX = "http://hl7.org/fhir/v3/";

    private static final String V3_OID_PREFIX = "2.16.840.1.113883.5.";

    private static final CodeSystemEnumerator<V3CodeSystems> delegate = new CodeSystemEnumerator<>(V3CodeSystems.class);

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
    public static List<V3CodeSystems> values() {
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
    public static V3CodeSystems valueOf(String name) {
        return delegate.valueOf(name);
    }

    /**
     * @see CodeSystemEnumerator#valueOf(String, boolean)
     */
    public static V3CodeSystems valueOf(
        String name,
        boolean exceptionIfNotFound
    ) {
        return delegate.valueOf(name, exceptionIfNotFound);
    }

    private V3CodeSystems(
        String urn,
        String oid
    ) {
        super(URI.create(V3_CODESYSTEM_PREFIX + urn), null, null, V3_OID_PREFIX + oid);
        CodeSystemRegistry.registerCodeSystemNormalization(LEGACY_CODESYSTEM_PREFIX + urn, this);
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
