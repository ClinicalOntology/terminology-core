package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.DescriptionType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConceptSpec {

    @Test
    public void tests() {
        Concept cpt1 = new ConceptImpl("http://system1", "code1", "cpt1");
        assertEquals("cpt1", cpt1.getPreferredName());
        assertEquals(0, cpt1.getConceptDescriptions().size());
        cpt1.setPreferredName("test");
        assertEquals("test", cpt1.getPreferredName());
        cpt1.addConceptDescription(DescriptionType.FULLY_SPECIFIED_NAME, "FSN");
        cpt1.addConceptDescription(DescriptionType.SYNONYM, "SYN1");
        cpt1.addConceptDescription(DescriptionType.SYNONYM, "SYN2");
        assertEquals(3, cpt1.getConceptDescriptions().size());
        assertEquals(1, cpt1.getConceptDescriptions(DescriptionType.FULLY_SPECIFIED_NAME).size());
        assertEquals(2, cpt1.getConceptDescriptions(DescriptionType.SYNONYM).size());
        assertEquals("FSN", cpt1.getConceptDescription(DescriptionType.FULLY_SPECIFIED_NAME).getDescription());
        assertEquals("SYN1", cpt1.getConceptDescription(DescriptionType.SYNONYM).getDescription());
    }

}
