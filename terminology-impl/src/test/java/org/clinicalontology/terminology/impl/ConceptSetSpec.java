package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ConceptSet;
import org.clinicalontology.terminology.impl.model.ConceptImpl;
import org.clinicalontology.terminology.impl.model.ConceptSetImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConceptSetSpec {

    @Test
    public void tests() {
        Concept cpt1 = new ConceptImpl("http://system1", "code1", "cpt1");
        Concept cpt1_1 = new ConceptImpl("http://system1", "code1", "cpt1_1");
        Concept cpt2 = new ConceptImpl("http://system2", "code2", "cpt2");
        Concept cpt3 = new ConceptImpl("http://system3", "code3", null);
        Concept cpt4 = new ConceptImpl("http://system3", "code4", null);
        ConceptSet set1 = new ConceptSetImpl(cpt1);
        set1.setText("set1");
        ConceptSet set2 = new ConceptSetImpl(cpt2);
        ConceptSet set3 = new ConceptSetImpl(cpt3);
        ConceptSet set3_1 = new ConceptSetImpl(cpt3, cpt1);
        ConceptSet set1_4 = new ConceptSetImpl(cpt1, cpt4);
        ConceptSet set3_4 = new ConceptSetImpl(cpt3, cpt4);
        ConceptSet set3_4_1 = new ConceptSetImpl(cpt3, cpt4, cpt1);
        assertTrue(set1.contains(cpt1_1));
        assertFalse(set1.contains(cpt2));
        assertEquals("set1", set1.getDisplayText());
        assertEquals("cpt2", set2.getDisplayText());
        assertEquals("code3", set3.getDisplayText());
        assertTrue(set3_1.contains(cpt1));
        assertFalse(set3_1.contains(cpt2));
        assertTrue(set3_1.contains(cpt3));
        assertEquals("cpt1", set3_1.getDisplayText());
        assertEquals("cpt1", set1_4.getDisplayText());
        assertEquals("code3", set3_4.getDisplayText());
        assertEquals("cpt1", set3_4_1.getDisplayText());
    }
}
