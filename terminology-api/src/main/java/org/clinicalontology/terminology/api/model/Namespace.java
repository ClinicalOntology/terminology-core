package org.clinicalontology.terminology.api.model;

import java.net.URI;
import java.util.Objects;

/**
 * A namespace is a conceptual space that qualifies classes, identifiers, etc. to avoid conflicts with unrelated items
 * that have the same names.
 */
public interface Namespace {

    /**
     * Returns the alias of the namespace.
     *
     * @return The alias of the namespace.
     */
    String getAlias();

    /**
     * Returns the identifier of the namespace.
     *
     * @return The identifier of the namespace.
     */
    URI getId();

    /**
     * Returns the namespace identifier as a string.
     *
     * @return The namespace identifier as a string.
     */
    default String getIdAsString() {
        return Objects.toString(getId());
    }

}
