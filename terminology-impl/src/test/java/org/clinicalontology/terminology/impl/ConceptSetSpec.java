package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.ConceptSet;
import org.junit.Assert;
import org.junit.Test;

public class ConceptSetSpec {

    @Test
    public void tests() {
        Concept cpt1 = new ConceptImpl("http://system1", "code1", "cpt1");
        Concept cpt1_1 = new ConceptImpl("http://system1", "code1", "cpt1_1");
        Concept cpt2 = new ConceptImpl("http://system2", "code2", "cpt2");
        Concept cpt3 = new ConceptImpl("http://system3", "code3", null);
        ConceptSet set1 = new ConceptSetImpl(cpt1);
        set1.setText("set1");
        ConceptSet set2 = new ConceptSetImpl(cpt2);
        ConceptSet set3 = new ConceptSetImpl(cpt3);
        ConceptSet set4 = new ConceptSetImpl(cpt3, cpt1);
        Assert.assertTrue(set1.contains(cpt1_1));
        Assert.assertFalse(set1.contains(cpt2));
        Assert.assertEquals("set1", set1.getDisplayText());
        Assert.assertEquals("cpt2", set2.getDisplayText());
        Assert.assertEquals("", set3.getDisplayText());
        Assert.assertTrue(set4.contains(cpt1));
        Assert.assertFalse(set4.contains(cpt2));
        Assert.assertTrue(set4.contains(cpt3));
        Assert.assertEquals("cpt1", set4.getDisplayText());
    }
}
