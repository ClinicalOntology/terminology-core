package org.clinicalontology.terminology.codesystem.hl7v2;

import org.clinicalontology.terminology.api.model.CodeSystemEnumerator;
import org.clinicalontology.terminology.api.model.CodeSystemRegistry;
import org.clinicalontology.terminology.impl.model.CodeSystemImpl;

import java.net.URI;
import java.util.List;

@SuppressWarnings("unused")
public final class V2CodeSystems extends CodeSystemImpl {

    public static final V2CodeSystems AdministrativeSex = new V2CodeSystems("0001", "2");

    public static final V2CodeSystems DischargeDisposition = new V2CodeSystems("0112", "112");

    private static final String V2_CODESYSTEM_PREFIX = "http://terminology.hl7.org/CodeSystem/v2-";

    private static final String LEGACY_CODESYSTEM_PREFIX = "http://hl7.org/fhir/v2/";

    private static final String V2_OID_PREFIX = "2.16.840.1.113883.18.";

    private static final CodeSystemEnumerator<V2CodeSystems> delegate = new CodeSystemEnumerator<>(V2CodeSystems.class);

    static {
        CodeSystemRegistry.registerCodeSystems(delegate.values());
    }

    /**
     * Force instantiation and registration of static class members.
     */
    public static void load() {
    }

    public static List<V2CodeSystems> values() {
        return delegate.values();
    }

    public static List<String> names() {
        return delegate.names();
    }

    public static V2CodeSystems valueOf(String name) {
        return delegate.valueOf(name);
    }

    public static V2CodeSystems valueOf(
        String name,
        boolean exceptionIfNotFound
    ) {
        return delegate.valueOf(name, exceptionIfNotFound);
    }

    private V2CodeSystems(
        String urn,
        String oid
    ) {
        super(URI.create(V2_CODESYSTEM_PREFIX + urn), null, null, V2_OID_PREFIX + oid);
        CodeSystemRegistry.registerCodeSystemNormalization(LEGACY_CODESYSTEM_PREFIX + urn, this);
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
