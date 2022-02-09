package org.clinicalontology.terminology.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.Oid;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Implementation of an OID with full validation.
 */
public class OidImpl implements Oid {

    private static final Pattern validator = Pattern.compile("^([0-2])((\\.0)|(\\.[1-9][0-9]*))*$");

    private final String oid;

    /**
     * Converts a list of string values to a set of OIDs.  Insertion order is maintained.
     *
     * @param values String values to convert.
     * @return A set of OIDS.
     */
    public static Set<Oid> toOrderedSet(String... values) {
        return Arrays.stream(values)
                .map(OidImpl::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * For deserialization.
     */
    @SuppressWarnings("unused")
    private OidImpl() {
        oid = null;
    }

    /**
     * Create and OID from its string equivalent.
     *
     * @param oid The string value. The URN prefix is optional.
     */
    public OidImpl(String oid) {
        this.oid = StringUtils.removeStart(oid.replaceAll("\\s", ""), URN_PREFIX);
        Validate.isTrue(validator.matcher(this.oid).matches(), "Not a valid OID: %s", this.oid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return oid.equals(((OidImpl) o).oid);
    }

    @Override
    public int hashCode() {
        return oid.hashCode();
    }

    /**
     * @return The string equivalent of the OID.
     */
    @Override
    public String toString() {
        return oid;
    }

}
