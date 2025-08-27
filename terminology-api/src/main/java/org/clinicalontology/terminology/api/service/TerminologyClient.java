package org.clinicalontology.terminology.api.service;

import org.clinicalontology.terminology.api.model.*;

import java.sql.Connection;
import java.util.Set;
import java.util.function.Supplier;

public interface TerminologyClient {

    boolean supports(ValueSetSource terminologySource);

    Set<Concept> getConceptsInValueSet(String valueSetId, String valueSetVersion);

    Set<Concept> getConceptsInValueSet(ValueSetIdentifier valueSetIdentifier);

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
     * Returns the range of a concept relationship. It is equivalent to the query:
     * domain predicate ?x
     * For instance, 'Beta-blocker class' 'has-ingredient' ?ingredients
     * <p>
     * If the expansion contains a set of concepts, that set of concepts will be used in
     * the pattern matching. If the expansion is empty, the expansion shall be fetched for
     * the value set identifier. If no expansion is found, an error will be thrown.
     *
     * @param rangeConstraint A value set that constrains the range concepts to one in that value set
     * @param domain          The concept that is the subject of the triple
     * @param predicate       The concept that is the predicate of the triple
     * @return The set of concepts that represents the range of the relationship
     */
    Set<Concept> getRange(ValueSetExpansion rangeConstraint, Concept domain, Concept predicate);

    /**
     * Returns the range of a concept relationship. It is equivalent to the query:
     * domain predicate ?x
     * For instance, 'Beta-blocker class' 'has-ingredient' ?ingredients
     * <p>
     * If the expansion contains a set of concepts, that set of concepts will be used in
     * the pattern matching. If the expansion is empty, the expansion shall be fetched for
     * the value set identifier. If no expansion is found, an error will be thrown.
     *
     * @param domain    A set of concepts allowed at the domain of the relationship (not null)
     * @param predicate A set of concepts allowed at the predicate of the relationship (not null)
     * @return The set of concepts that represents the range of the relationship
     */
    Set<Concept> getRangeUnion(ValueSetExpansion domain, ValueSetExpansion predicate);

    /**
     * Returns the range of a concept relationship. It is equivalent to the query:
     * domain predicate ?x
     * For instance, 'Beta-blocker class' 'has-ingredient' ?ingredients
     * <p>
     * If the expansion contains a set of concepts, that set of concepts will be used in
     * the pattern matching. If the expansion is empty, the expansion shall be fetched for
     * the value set identifier. If no expansion is found, an error will be thrown.
     *
     * @param rangeConstraint A value set that constrains the range concepts to one in that value set
     * @param domain          A set of concepts allowed at the domain of the relationship (not null)
     * @param predicate       A set of concepts allowed at the predicate of the relationship (not null)
     * @return The set of concepts that represents the range of the relationship
     */
    Set<Concept> getRangeUnion(ValueSetExpansion rangeConstraint, ValueSetExpansion domain, ValueSetExpansion predicate);

    /**
     * Method returns the domain of a concept relationship. It is
     * equivalent to the query:
     * ?x predicate range
     * For instance:
     * ?drugClass 'has ingredient' 'Metoprolol succinate'
     *
     * @param predicate The concept that is the predicate of the triple
     * @param range     The range of a concept relationship.
     * @return The set of concepts that represents the domain of the relationship matching the predicate-range pattern
     */
    Set<Concept> getDomain(Concept predicate, Concept range);


    /**
     * Method returns the domain of a concept relationship. It is
     * equivalent to the query:
     * ?x predicate range
     * For instance:
     * ?drugClass 'has ingredient' 'Metoprolol succinate'
     *
     * <p>
     * If the expansion contains a set of concepts, that set of concepts will be used in
     * the pattern matching. If the expansion is empty, the expansion shall be fetched for
     * the value set identifier. If no expansion is found, an error will be thrown.
     *
     * @param domainConstraint A value set expansion that constrains domain concepts to one in the value set expansion
     * @param predicate        The concept that is the predicate of the triple
     * @param range            The range of a concept relationship.
     * @return The set of concepts that represents the domain of the relationship matching the predicate-range pattern and also part of the domain constraint set
     */
    Set<Concept> getDomain(ValueSetExpansion domainConstraint, Concept predicate, Concept range);

    /**
     * Method returns the domain of a concept relationship. It is
     * equivalent to the query:
     * ?x predicate range
     * For instance:
     * ?drugClass 'has ingredient' 'Metoprolol succinate'
     *
     * <p>
     * If the expansion contains a set of concepts, that set of concepts will be used in
     * the pattern matching. If the expansion is empty, the expansion shall be fetched for
     * the value set identifier. If no expansion is found, an error will be thrown.
     *
     * @param predicate        A set of concepts allowed at the predicate of the relationship (not null)
     * @param range            A set of concepts allowed at the range of the relationship (not null)
     * @return The set of concepts that represents the domain of the relationship matching the predicate-range pattern
     */
    Set<Concept> getDomainUnion(ValueSetExpansion predicate, ValueSetExpansion range);


    /**
     * Method returns the domain of a concept relationship. It is
     * equivalent to the query:
     * ?x predicate range
     * For instance:
     * ?drugClass 'has ingredient' 'Metoprolol succinate'
     *
     * <p>
     * If the expansion contains a set of concepts, that set of concepts will be used in
     * the pattern matching. If the expansion is empty, the expansion shall be fetched for
     * the value set identifier. If no expansion is found, an error will be thrown.
     *
     * @param domainConstraint A value set expansion that constrains domain concepts to one in the value set expansion
     * @param predicate        A set of concepts allowed at the predicate of the relationship (not null)
     * @param range            A set of concepts allowed at the range of the relationship (not null)
     * @return The set of concepts that represents the domain of the relationship matching the predicate-range pattern and also part of the domain constraint set
     */
    Set<Concept> getDomainUnion(ValueSetExpansion domainConstraint, ValueSetExpansion predicate, ValueSetExpansion range);

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
     * Returns all concepts whose code is in the codes set.
     *
     * @param codeSystem The concept namespace URI
     * @param codes      The concept codes to search by
     * @return A collection of concepts whose code is in the codes set.
     */
    Set<Concept> findConceptsByCode(CodeSystem codeSystem, Set<String> codes);

    /**
     * Returns all concepts that have a description containing a string in the search term set.
     *
     * @param codeSystem  The concept namespace URI
     * @param searchTerms The search terms used to retrieve the concept(s)
     * @return A set of concepts with descriptions containing the search term(s)
     */
    Set<Concept> findConceptsByName(CodeSystem codeSystem, Set<String> searchTerms);

    /**
     * Sets the connection supplier.
     *
     * @param connectionSupplier The connection supplier.
     */
    void setConnectionSupplier(Supplier<Connection> connectionSupplier);

}
