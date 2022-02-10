package org.clinicalontology.terminology.impl;

import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.Concept;
import org.clinicalontology.terminology.api.ConceptSet;

import java.net.URI;
import java.util.*;

public class ConceptSetImpl implements ConceptSet {

    private final Set<Concept> conceptSet = new LinkedHashSet<>();

    private String text;

    public ConceptSetImpl() {
    }

    public ConceptSetImpl(
            String system,
            String code,
            String preferredName) {
        this(system == null ? null : URI.create(system), code, preferredName);
    }

    public ConceptSetImpl(
            URI system,
            String code,
            String preferredName) {
        this(new ConceptImpl(system, code, preferredName));
    }

    public ConceptSetImpl(
            CodeSystem system,
            String code,
            String preferredName) {
        this(new ConceptImpl(system, code, preferredName));
    }

    public ConceptSetImpl(Concept... concepts) {
        Collections.addAll(conceptSet, concepts);
    }

    public ConceptSetImpl(Collection<Concept> concepts) {
        conceptSet.addAll(concepts);
    }

    @Override
    public Set<Concept> getConcepts() {
        return conceptSet;
    }

    @Override
    public void setConcepts(Set<Concept> concepts) {
        conceptSet.clear();

        if (concepts != null) {
            conceptSet.addAll(concepts);
        }
    }

    @Override
    public void addConcept(Concept concept) {
        if (concept != null) {
            conceptSet.add(concept);
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConceptSetImpl that = (ConceptSetImpl) o;
        return Objects.equals(conceptSet, that.conceptSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conceptSet);
    }

}
