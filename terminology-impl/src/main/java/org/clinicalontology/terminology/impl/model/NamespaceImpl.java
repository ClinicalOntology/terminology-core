package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.Namespace;

import java.net.URI;
import java.util.Objects;

/**
 * Implementation of {@link Namespace}.
 */
public class NamespaceImpl implements Namespace {

    private final String alias;

    private final URI id;

    /**
     * For deserialization.
     */
    protected NamespaceImpl() {
        this.alias = null;
        this.id = null;
    }

    public NamespaceImpl(
        String alias,
        URI id
    ) {
        this.alias = alias;
        this.id = id;
    }

    public NamespaceImpl(
        String alias,
        String id
    ) {
        this.alias = alias;
        this.id = URI.create(id);
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public URI getId() {
        return id;
    }

}
