package org.clinicalontology.terminology.impl;

import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.ValueSetIdentifier;

import java.net.URI;

public class ValueSetIdentifierImpl implements ValueSetIdentifier {

    private final URI id;

    private final URI versionedId;

    private final String version;

    private final String displayName;

    private final String alias;

    public ValueSetIdentifierImpl(
            URI id,
            String version,
            String displayName,
            String alias) {
        Validate.isTrue(id != null, "You must specify an id.");
        this.id = id;
        this.version = version == null ? "1.0.0" : version;
        this.displayName = displayName;
        this.alias = alias;
        this.versionedId = URI.create(id + "/" + this.version);
    }

    public ValueSetIdentifierImpl(
            URI id,
            String version,
            String displayName) {
        this(id, version, displayName, null);
    }

    public ValueSetIdentifierImpl(
            String id,
            String version,
            String displayName) {
        this(URI.create(id), version, displayName);
    }

    public ValueSetIdentifierImpl(
            URI id,
            String version) {
        this(id, version, null);
    }

    public ValueSetIdentifierImpl(
            String id,
            String version) {
        this(URI.create(id), version);
    }

    @Override
    public URI getId() {
        return id;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public URI getVersionedIdentifier() {
        return versionedId;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ValueSetIdentifierImpl && ((ValueSetIdentifierImpl) object).versionedId.equals(versionedId);
    }

    @Override
    public int compareTo(ValueSetIdentifier o) {
        return getVersionedIdentifier().compareTo(o.getVersionedIdentifier());
    }

    @Override
    public int hashCode() {
        return getVersionedIdentifier().hashCode();
    }

    @Override
    public String toString() {
        return displayName == null ? getIdAsString() : displayName;
    }

}
