package org.clinicalontology.terminology.api;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Interface for representing an OID.
 * <p>
 * Note that the toString() method of an implementation must return the
 * string equivalent of the OID without the URI prefix.
 */
public interface Oid extends Serializable {

    /**
     * The URN prefix for an OID.
     */
    String URN_PREFIX = "urn:oid:";

    /**
     * Removes the URN prefix from an OID.  If the OID has no prefix, the original value is returned.
     *
     * @param oid The OID.
     * @return The OID without the URN prefix.
     */
    static String stripPrefix(String oid) {
        return StringUtils.removeStart(oid, URN_PREFIX);
    }

    /**
     * Returns the OID's string value with the URN prefix.
     *
     * @return The OID's string value with the URN prefix.
     */
    default String toURNString() {
        return URN_PREFIX + this;
    }

    /**
     * Returns true if the specified string value matches this OID's string equivalent.
     *
     * @param value The string value (with or without the URN prefix).
     * @return True if equivalent.
     */
    default boolean isEquivalent(String value) {
        return stripPrefix(value).equals(toString());
    }

}
