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

    /**
     * Method returns the range of a concept relationship. It is
     * equivalent to the query:
     * domain predicate ?x
     * For instance, 'Beta-blocker class' 'has-ingredient' ?ingredients
     *
     * @param domain The concept that is the subject of the triple
     * @param predicate The concept that is the predicate of the triple
     * @return The set of concepts that represents the range of the relationship
     */
    Set<Concept> getRange(Concept domain, Concept predicate);

    /**
     * Method returns the domain of a concept relationship. It is
     * equivalent to the query:
     * ?x predicate range
     * For instance:
     * ?drugClass 'has ingredient' 'Metoprolol succinate'
     *
     * @param predicate
     * @param range
     * @return
     */
    Set<Concept> getDomain(Concept predicate, Concept range);

    void setConnectionSupplier(Supplier<Connection> connectionSupplier);
    
    // C translate(C sourceConcept, CodeSystem targetCodeSystem);
    //
    // C mapConcept(C fromConcept, List<Function<C, C>> mappingRules);

}
