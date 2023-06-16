package org.clinicalontology.terminology.impl.service;

import org.apache.commons.lang3.NotImplementedException;
import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ValueSetSource;
import org.clinicalontology.terminology.api.service.TerminologyClient;

import java.sql.Connection;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TerminologyClientImpl implements TerminologyClient {

    private static final TerminologyClient NOP_TERMINOLOGY_CLIENT = new NOPTerminologyClientImpl();

    private final ConcurrentMap<ValueSetSource, TerminologyClient> delegates;

    public TerminologyClientImpl() {
        this.delegates = new ConcurrentHashMap<>();
    }

    public TerminologyClientImpl registerDelegate(
            ValueSetSource source,
            TerminologyClient client) {
        delegates.put(source, client);
        return this;
    }

    @Override
    public Set<Concept> getConceptsInValueSet(
            String valueSetId,
            String valueSetVersion) {
        return delegates.entrySet().parallelStream()
                .map(entry -> entry.getValue().getConceptsInValueSet(valueSetId, valueSetVersion))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isConceptInValueSet(
            CodeSystem codeSystem,
            String code,
            String valueSetId,
            String version) {
        Set<ValueSetSource> sources = ValueSetSource.resolve(codeSystem);
        return sources.parallelStream().anyMatch(s -> delegates.getOrDefault(s, NOP_TERMINOLOGY_CLIENT)
                .isConceptInValueSet(codeSystem, code, valueSetId, version));
    }

    @Override
    public Set<Concept> getConcepts(
            CodeSystem codeSystem,
            String code,
            String version) {
        Set<ValueSetSource> sources = ValueSetSource.resolve(codeSystem);
        return sources.parallelStream()
                .map(s -> delegates.getOrDefault(s, NOP_TERMINOLOGY_CLIENT).getConcepts(codeSystem, code, version))
                .flatMap(Collection::stream).collect(Collectors.toSet());
    }

    @Override
    public boolean supports(ValueSetSource terminologySource) {
        return delegates.containsKey(terminologySource);
    }

    @Override
    public void setConnectionSupplier(Supplier<Connection> connectionSupplier) {
        throw new NotImplementedException("setConnectionSupplier not implemented.");
    }

    @Override
    public Set<Concept> getRange(Concept domain, Concept predicate) {
        throw new NotImplementedException("setConnectionSupplier not implemented.");
    }

    @Override
    public Set<Concept> getDomain(Concept predicate, Concept range) {
        throw new NotImplementedException("setConnectionSupplier not implemented.");
    }
}
