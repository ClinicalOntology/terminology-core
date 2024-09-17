package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ConceptSet;

import java.net.URI;
import java.util.*;

public class ConceptSetImpl implements ConceptSet {

    private final Set<Concept> concepts = new LinkedHashSet<>();

    private String text;

    @SuppressWarnings("unused")
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
        Collections.addAll(this.concepts, concepts);
    }

    public ConceptSetImpl(Collection<Concept> concepts) {
        this.concepts.addAll(concepts);
    }

    @Override
    public Set<Concept> getConcepts() {
        return concepts;
    }

    @Override
    public void setConcepts(Set<Concept> concepts) {
        this.concepts.clear();

        if (concepts != null) {
            this.concepts.addAll(concepts);
        }
    }

    @Override
    public void addConcept(Concept concept) {
        if (concept != null) {
            concepts.add(concept);
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
        return Objects.equals(concepts, that.concepts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concepts);
    }

}
