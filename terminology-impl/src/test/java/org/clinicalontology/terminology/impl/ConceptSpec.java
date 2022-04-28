package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.Concept;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConceptSpec {

    @Test
    public void tests() {
        Concept cpt1 = new ConceptImpl("http://system1", "code1", "cpt1");
        assertEquals("cpt1", cpt1.getPreferredName());
        assertEquals(1, cpt1.getConceptDescriptions().size());
        cpt1.setPreferredName("test");
        assertEquals("test", cpt1.getPreferredName());
        assertEquals(1, cpt1.getConceptDescriptions().size());
    }

}
