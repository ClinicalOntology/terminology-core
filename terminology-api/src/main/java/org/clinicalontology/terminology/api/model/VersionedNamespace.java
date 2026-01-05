package org.clinicalontology.terminology.api.model;

import org.apache.commons.lang3.StringUtils;

import java.beans.Transient;
import java.net.URI;
import java.util.Objects;

/**
 * A {@link Namespace} with a version.
 */
public interface VersionedNamespace extends Namespace {

    /**
     * Returns the version of the namespace.
     *
     * @return The version of the namespace.
     */
    String getVersion();

    /**
     * Returns an identifier that is unique for the given version of the namespace.  It is formed from
     * the identifier and the version separated by a forward slash.
     *
     * @return The versioned identifier.
     */
    URI getVersionedId();

    /**
     * @deprecated Use {@link #getVersionedId()} instead.
     */
    @Deprecated
    default URI getVersionedIdentifier() {
        return getVersionedId();
    }

    /**
     * Returns the versioned identifier as a string.
     *
     * @return The versioned identifier as a string.
     */
    default String getVersionedIdAsString() {
        return Objects.toString(getVersionedId());
    }

    /**
     * Returns true if the namespace has both an identifier and a version.
     *
     * @return True if the namespace has both an identifier and a version.
     */
    @Transient // Don't serialize this.
    default boolean isValid() {
        return getId() != null && StringUtils.isNotBlank(getVersion());
    }

}
