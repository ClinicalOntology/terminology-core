package org.clinicalontology.terminology.codesystem.core;

import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.CodeSystemRegistry;
import org.clinicalontology.terminology.api.Oid;
import org.junit.Test;

import java.net.URI;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CodeSystemSpec {

    private static final String UNKNOWN_URISTR = "http://acme.org";

    private static final URI UNKNOWN_URI = URI.create(UNKNOWN_URISTR);

    private static final String LOINC_URISTR = CodeSystems.LOINC.getUriAsString();

    private static final URI LOINC_URI = CodeSystems.LOINC.getUri();

    private static final String LOINC_OIDSTR = CodeSystems.LOINC.getFirstOid().toString();

    private static final Oid LOINC_OID = CodeSystems.LOINC.getFirstOid();

    private static final String ICD9_OIDSTR = "2.16.840.1.113883.6.104";

    private static final Oid ICD9_OID = CodeSystems.ICD9_CM.getFirstOid();

    @Test
    public void testLookup() {
        assertNull(CodeSystemRegistry.byUri(UNKNOWN_URI));
        assertNull(CodeSystemRegistry.byUri(UNKNOWN_URISTR));
        assertEquals(CodeSystems.LOINC, CodeSystemRegistry.byUri(LOINC_URI));
        assertEquals(CodeSystems.LOINC, CodeSystemRegistry.byUri(LOINC_URISTR));
        assertEquals(CodeSystems.LOINC, CodeSystemRegistry.byOid(LOINC_OID));
        assertEquals(CodeSystems.LOINC, CodeSystemRegistry.byOid(LOINC_OIDSTR));
        assertEquals(CodeSystems.ICD9_CM, CodeSystemRegistry.byOid(ICD9_OID));
        assertEquals(CodeSystems.ICD9_CM, CodeSystemRegistry.byOid(ICD9_OIDSTR));

        assertNull(CodeSystemRegistry.findCodeSystem(UNKNOWN_URISTR));

        assertEquals(CodeSystems.LOINC, CodeSystemRegistry.findCodeSystem(LOINC_OIDSTR));
        assertEquals(CodeSystems.ICD9_CM, CodeSystemRegistry.findCodeSystem(ICD9_OIDSTR));
        assertEquals(CodeSystems.LOINC, CodeSystemRegistry.findCodeSystem(LOINC_OIDSTR));

        assertEquals(LOINC_OID, CodeSystems.LOINC.getFirstOid());
        assertNotEquals(ICD9_OIDSTR, CodeSystems.ICD9_CM.getFirstOid().toURNString());
    }

    @Test
    public void listCodeSystems() {
        for (CodeSystem system : CodeSystems.values()) {
            System.out.println(
                    system.getUriAsString() + ", " +
                            system.getOids().stream().map(Oid::toURNString).collect(Collectors.joining(", ")));
        }
    }

}