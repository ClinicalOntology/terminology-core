package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ValueSetExpansion;
import org.clinicalontology.terminology.api.model.ValueSetIdentifier;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class ValueSetExpansionImpl implements ValueSetExpansion {

    // TODO Do we need this? If so, should it not be multicardinality? Should it be a derived field based on the expansion? Should it rather reside in ValueSetIdentifier?
    // private final CodeSystem codeSystem = null;

    private final ValueSetIdentifier valueSetIdentifier;

    private final Set<Concept> expansion;

    /**
     * For deserialization.
     */
    @SuppressWarnings("unused")
    private ValueSetExpansionImpl() {
        this.valueSetIdentifier = null;
        this.expansion = new HashSet<>();
    }

    public ValueSetExpansionImpl(
        ValueSetIdentifier valueSetIdentifier,
        Set<Concept> expansion
    ) {
        this.valueSetIdentifier = valueSetIdentifier;
        this.expansion = getOrDefault(expansion, HashSet::new);
    }

    public ValueSetExpansionImpl(
        URI id,
        String version,
        String displayName,
        Set<Concept> expansion
    ) {
        this(new ValueSetIdentifierImpl(id, version, displayName), expansion);
    }

    public ValueSetExpansionImpl(
        String id,
        String version,
        String displayName,
        Set<Concept> expansion
    ) {
        this(URI.create(id), version, displayName, expansion);
    }

    private Set<Concept> getOrDefault(
        Set<Concept> expansion,
        Supplier<Set<Concept>> supplier) {
        return expansion == null ? supplier.get() : new HashSet<>(expansion);
    }

    @Override
    public ValueSetIdentifier getValueSetIdentifier() {
        return valueSetIdentifier;
    }

    @Override
    public Set<Concept> getExpansion() {
        return this.expansion;
    }

    /**
     * Optional.
     *
     * @return The semantic identifier.
     */
    @Override
    public Concept getSemanticIdentifier() {
        return null;
    }

}
