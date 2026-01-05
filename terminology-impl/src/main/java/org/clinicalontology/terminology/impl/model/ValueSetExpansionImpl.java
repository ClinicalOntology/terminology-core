package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ValueSetExpansion;
import org.clinicalontology.terminology.api.model.ValueSetIdentifier;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link ValueSetExpansion}.
 */
public class ValueSetExpansionImpl implements ValueSetExpansion {

    // TODO Do we need this? If so, should it not be multi-cardinality? Should it be a derived field based on the expansion? Should it rather reside in ValueSetIdentifier?
    // private final CodeSystem codeSystem = null;

    private final ValueSetIdentifier valueSetIdentifier;

    private final Set<Concept> expansion = new HashSet<>();

    /**
     * For deserialization.
     */
    @SuppressWarnings("unused")
    private ValueSetExpansionImpl() {
        this(null);
    }

    public ValueSetExpansionImpl(ValueSetIdentifier valueSetIdentifier) {
        this.valueSetIdentifier = valueSetIdentifier;
    }

    public ValueSetExpansionImpl(
        ValueSetIdentifier valueSetIdentifier,
        Set<Concept> expansion
    ) {
        this.valueSetIdentifier = valueSetIdentifier;

        if (expansion != null) {
            this.expansion.addAll(expansion);
        }
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

    @Override
    public ValueSetIdentifier getValueSetIdentifier() {
        return valueSetIdentifier;
    }

    @Override
    public Set<Concept> getExpansion() {
        return this.expansion;
    }

}
