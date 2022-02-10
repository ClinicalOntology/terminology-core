package org.clinicalontology.terminology.api;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

/**
 * An identifier of a value set. A value set is a collection of unique concept references.
 */
@SuppressWarnings("unused")
public interface ValueSetIdentifier extends Comparable<ValueSetIdentifier>, Serializable {

    /**
     * This method returns an identifier for the collection of versions of a given value set.
     * If you need a URI for a specific version of the value set, use getVersionedIdentifier().
     *
     * @return The common value set identifier across all versions of the value set.
     */
    URI getId();

    /**
     * This method returns an identifier for the collection of versions of a given value set.
     * If you need a URI for a specific version of the value set, use getVersionedIdentifier().
     *
     * @return The common value set identifier across all versions of the value set.
     */
    default String getIdAsString() {
        return Objects.toString(getId());
    }

    /**
     * @return The version of the value set.
     */
    String getVersion();

    /**
     * @return The value set display name.
     */
    String getDisplayName();

    /**
     * @return Alias assigned to value set identifier for reference in rules
     */
    String getAlias();

    /**
     * This method returns a URI that is unique for the given version of the value set.
     *
     * @return ID + / + version.
     */
    URI getVersionedIdentifier();

    /**
     * @param o The value set identifier to compare.
     * @return True if both identifiers point to the same value set.
     */
    @Override
    default int compareTo(ValueSetIdentifier o) {
        return getVersionedIdentifier().compareTo(o.getVersionedIdentifier());
    }

    /**
     * @return True if identifier has both an ID and a version.
     */
    default boolean isValid() {
        return getId() != null && StringUtils.isNotEmpty(getVersion());
    }

}
