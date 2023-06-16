package org.clinicalontology.terminology.impl.service;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ValueSetSource;
import org.clinicalontology.terminology.api.service.TerminologyClient;

import java.sql.Connection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;

/**
 * A NOP terminology client.
 */
public class NOPTerminologyClientImpl implements TerminologyClient {

    @Override
    public boolean supports(ValueSetSource terminologySource) {
        return false;
    }

    @Override
    public Set<Concept> getConceptsInValueSet(String valueSetId, String valueSetVersion) {
        return Collections.emptySet();
    }

    @Override
    public boolean isConceptInValueSet(CodeSystem codeSystem, String code, String valueSetId, String version) {
        return false;
    }

    @Override
    public Set<Concept> getConcepts(CodeSystem codeSystem, String code, String version) {
        return null;
    }

    @Override
    public void setConnectionSupplier(Supplier<Connection> connectionSupplier) {
        
    }

    @Override
    public Set<Concept> getRange(Concept domain, Concept predicate) {
        return Collections.emptySet();
    }

    @Override
    public Set<Concept> getDomain(Concept predicate, Concept range) {
        return Collections.emptySet();
    }
}
