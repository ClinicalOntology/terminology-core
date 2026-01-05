package org.clinicalontology.terminology.impl.model;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.model.ValueSetIdentifier;

import java.net.URI;

/**
 * Implementation of {@link ValueSetIdentifier}.
 */
public class ValueSetIdentifierImpl extends VersionedNamespaceImpl implements ValueSetIdentifier {

    public static ValueSetIdentifier create(String vsid) {
        if (StringUtils.isBlank(vsid)) {
            return null;
        }

        String[] pcs = vsid.split("\\|");
        return new ValueSetIdentifierImpl(
            ArrayUtils.get(pcs, 0),
            ArrayUtils.get(pcs, 1),
            ArrayUtils.get(pcs, 2),
            ArrayUtils.get(pcs, 3));
    }

    private final String displayName;

    /**
     * For deserialization.
     */
    protected ValueSetIdentifierImpl() {
         this.displayName = null;
    }

    public ValueSetIdentifierImpl(
        URI id,
        String version,
        String displayName,
        String alias
    ) {
        super(id, version, alias);
        Validate.isTrue(id != null, "You must specify an id.");
        this.displayName = displayName;
    }

    public ValueSetIdentifierImpl(
        URI id,
        String version,
        String displayName
    ) {
        this(id, version, displayName, null);
    }

    public ValueSetIdentifierImpl(
        String id,
        String version,
        String displayName
    ) {
        this(id, version, displayName, null);
    }

    public ValueSetIdentifierImpl(
        String id,
        String version,
        String displayName,
        String alias
    ) {
        this(URI.create(id), version, displayName, alias);
    }

    public ValueSetIdentifierImpl(
        URI id,
        String version
    ) {
        this(id, version, null);
    }

    public ValueSetIdentifierImpl(
        String id,
        String version
    ) {
        this(id, version, null);
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ValueSetIdentifierImpl valueSetIdentifier
            && valueSetIdentifier.getVersionedId().equals(getVersionedId());
    }

    @Override
    public int hashCode() {
        return getVersionedId().hashCode();
    }

    @Override
    public String toString() {
        return displayName == null ? getIdAsString() : displayName;
    }

}
