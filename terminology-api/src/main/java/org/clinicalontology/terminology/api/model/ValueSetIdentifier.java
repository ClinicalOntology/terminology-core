package org.clinicalontology.terminology.api.model;

import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;

/**
 * An identifier of a value set. A value set is a collection of unique concept references.
 */
public interface ValueSetIdentifier extends VersionedNamespace, Serializable, Comparable<ValueSetIdentifier> {

    /**
     * Returns the value set display name.
     *
     * @return The value set display name.
     */
    String getDisplayName();

    /**
     * Returns the result of the comparison.
     *
     * @param other The value set identifier to compare.
     * @return The result of the comparison.
     */
    @Override
    default int compareTo(ValueSetIdentifier other) {
        return ObjectUtils.compare(getVersionedId(), other.getVersionedId());
    }

}
