package org.clinicalontology.terminology.codesystem.hl7v3;

import org.clinicalontology.terminology.api.CodeSystemRegistry;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CodeSystemSpec {

    private static final String ACTCODE_URISTR = "http://terminology.hl7.org/CodeSystem/v3-ActCode";

    private static final URI ACTCODE_URI = URI.create(ACTCODE_URISTR);

    private static final String UNKNOWN_URISTR = "http://acme.org";

    private static final URI UNKNOWN_URI = URI.create(UNKNOWN_URISTR);

    @Test
    public void testLookup() {
        assertEquals(V3CodeSystems.ActCode, CodeSystemRegistry.byUrn(ACTCODE_URI));
        assertEquals(V3CodeSystems.ActCode, CodeSystemRegistry.byUrn(ACTCODE_URISTR));
        assertNull(CodeSystemRegistry.byUrn(UNKNOWN_URI));
        assertNull(CodeSystemRegistry.byUrn(UNKNOWN_URISTR));

        assertEquals(V3CodeSystems.ActCode, CodeSystemRegistry.findCodeSystem(ACTCODE_URISTR));
        assertNull(CodeSystemRegistry.findCodeSystem(UNKNOWN_URISTR));
    }

}
