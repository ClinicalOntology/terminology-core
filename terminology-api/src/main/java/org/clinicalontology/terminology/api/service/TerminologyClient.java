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
     * Returns the range of a concept relationship. It is equivalent to the query:
     * domain predicate ?x
     * For instance, 'Beta-blocker class' 'has-ingredient' ?ingredients
     *
     * @param domain    The concept that is the subject of the triple
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
     * @param predicate The concept that is the predicate of the triple
     * @param range     The range of a concept relationship.
     * @return The domain of a concept relationship.
     */
    Set<Concept> getDomain(Concept predicate, Concept range);

    /**
     * Returns all concepts in concept namespace.
     * If no version is provided, the latest concept namespace will be considered.
     *
     * @param codeSystem The concept namespace URI.
     * @param version    The version.
     * @return All concepts in concept namespace.
     */
    Set<Concept> getConceptsInNamespace(CodeSystem codeSystem, String version);

    /**
     * Sets the connection supplier.
     *
     * @param connectionSupplier The connection supplier.
     */
    void setConnectionSupplier(Supplier<Connection> connectionSupplier);

}
