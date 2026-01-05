package org.clinicalontology.terminology.impl.model;

import org.clinicalontology.terminology.api.model.VersionedNamespace;

import java.net.URI;

/**
 * Implementation of {@link VersionedNamespace}.
 */
public class VersionedNamespaceImpl extends NamespaceImpl implements VersionedNamespace {

    private final String version;

    private final URI versionedId;

    /**
     * For deserialization.
     */
    protected VersionedNamespaceImpl() {
        this.version = null;
        this.versionedId = null;
    }

    public VersionedNamespaceImpl(
        URI id,
        String version,
        String alias
    ) {
        super(alias, id);
        this.version = version == null ? "1.0.0" : version;
        this.versionedId = id == null ? null : URI.create(id + "/" + this.version);
    }

    public VersionedNamespaceImpl(
        String id,
        String version,
        String alias
    ) {
        this(id == null ? null : URI.create(id), version, alias);
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public URI getVersionedId() {
        return versionedId;
    }
}
