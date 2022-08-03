package org.clinicalontology.terminology.api.service;

import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ValueSetSource;

import java.sql.Connection;
import java.util.Set;
import java.util.function.Supplier;

public interface TerminologyClient {

    boolean supports(ValueSetSource terminologySource);

    Set<Concept> getConceptsInValueSet(String valueSetId, String valueSetVersion);

    boolean isConceptInValueSet(CodeSystem codeSystem, String code, String valueSetId, String version);

    Set<Concept> getConcepts(CodeSystem codeSystem, String code, String version);

    void setConnectionSupplier(Supplier<Connection> connectionSupplier);
    
    // C translate(C sourceConcept, CodeSystem targetCodeSystem);
    //
    // C mapConcept(C fromConcept, List<Function<C, C>> mappingRules);

}
