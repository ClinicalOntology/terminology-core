package org.clinicalontology.terminology.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.Oid;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a terminology namespace such as the URI assigned to an ontology. Typically, code systems represent
 * the namespace that ensure the uniqueness of codes in the terminology.
 */
@SuppressWarnings("unused")
public class CodeSystemImpl implements CodeSystem {

    /**
     * The name assigned to the code system such as SNOMED-CT, RxNorm
     */
    private final String name;

    /**
     * A description of the code system for human consumption.
     */
    private final String description;

    /**
     * The unique URI representing this code system. E.g., http://hl7.org/fhir/sid/icd-10-cm.
     */
    private final URI uri;

    /**
     * Associated OIDs for this code system.
     */
    private final Set<Oid> oids;

    /**
     * Create a code system.  Returns null if the URI is null or empty.
     *
     * @param uri  The URI.
     * @param oids Optional OIDs.
     * @return The newly created code system.
     */
    public static CodeSystem create(
            String uri,
            String... oids) {
        return StringUtils.isEmpty(uri) ? null : new CodeSystemImpl(URI.create(uri), null, null, oids);
    }

    /**
     * Create a code system.  Returns null if the URI is null.
     *
     * @param uri The URI.
     * @return The newly created code system.
     */
    public static CodeSystem create(URI uri) {
        return uri == null ? null : new CodeSystemImpl(uri, null, null);
    }

    /**
     * For deserialization.
     */
    private CodeSystemImpl() {
        uri = null;
        name = null;
        description = null;
        oids = null;
    }

    /**
     * @param uri The URI for this code system.
     */
    public CodeSystemImpl(URI uri) {
        this(uri, null, null);
    }

    /**
     * @param uri The URI for this code system as a string.
     */
    public CodeSystemImpl(String uri) {
        this(uri, null, null);
    }

    /**
     * @param uri  The URI associated with this code system.
     * @param name The name associated to this code system.
     */
    public CodeSystemImpl(
            URI uri,
            String name) {
        this(uri, name, null);
    }

    /**
     * @param uri  The URI associated with this code system.
     * @param name The name associated to this code system.
     */
    public CodeSystemImpl(
            String uri,
            String name) {
        this(uri, name, null);
    }

    /**
     * @param uri         The URI associated with this code system.
     * @param name        The name associated to this code system.
     * @param description A description of the code system.
     * @param oids        OIDs associated with this code system.
     */
    public CodeSystemImpl(
            URI uri,
            String name,
            String description,
            String... oids) {
        Validate.notNull(uri, "URI must not be null.");
        this.uri = uri;
        this.name = name;
        this.description = description;
        this.oids = Collections.unmodifiableSet(OidImpl.toOrderedSet(oids));
    }

    /**
     * @param uri         The URI associated with this code system.
     * @param name        The name associated to this code system.
     * @param description A description of the code system.
     * @param oids        OIDs associated with this code system.
     */
    public CodeSystemImpl(
            String uri,
            String name,
            String description,
            String... oids) {
        this(URI.create(uri), name, description, oids);
    }

    /**
     * @return The name of the code system.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return The description of this code system.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @return The URI of this code system.
     */
    @Override
    public URI getUrn() {
        return uri;
    }

    /**
     * @return The OIDs associated with this code system.
     */
    @Override
    public Set<Oid> getOids() {
        return oids;
    }

    @Override
    public boolean equals(Object o) {
        return isEqual(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);
    }

    @Override
    public String toString() {
        return getUrnAsString();
    }

}
