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
 * Represents a terminology namespace such as the URN assigned to an ontology. Typically, code systems represent
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
     * The unique URN representing this code system. E.g., http://hl7.org/fhir/sid/icd-10-cm.
     */
    private final URI urn;

    /**
     * Associated OIDs for this code system.
     */
    private final Set<Oid> oids;

    /**
     * Create a code system.  Returns null if the URN is null or empty.
     *
     * @param urn  The URN.
     * @param oids Optional OIDs.
     * @return The newly created code system.
     */
    public static CodeSystem create(
            String urn,
            String... oids) {
        return StringUtils.isEmpty(urn) ? null : new CodeSystemImpl(URI.create(urn), null, null, oids);
    }

    /**
     * Create a code system.  Returns null if the URN is null.
     *
     * @param urn The URN.
     * @return The newly created code system.
     */
    public static CodeSystem create(URI urn) {
        return urn == null ? null : new CodeSystemImpl(urn, null, null);
    }

    /**
     * For deserialization.
     */
    private CodeSystemImpl() {
        urn = null;
        name = null;
        description = null;
        oids = null;
    }

    /**
     * @param urn The URN for this code system.
     */
    public CodeSystemImpl(URI urn) {
        this(urn, null, null);
    }

    /**
     * @param urn The URN for this code system as a string.
     */
    public CodeSystemImpl(String urn) {
        this(urn, null, null);
    }

    /**
     * @param urn  The URN associated with this code system.
     * @param name The name associated to this code system.
     */
    public CodeSystemImpl(
            URI urn,
            String name) {
        this(urn, name, null);
    }

    /**
     * @param urn  The URN associated with this code system.
     * @param name The name associated to this code system.
     */
    public CodeSystemImpl(
            String urn,
            String name) {
        this(urn, name, null);
    }

    /**
     * @param urn         The URN associated with this code system.
     * @param name        The name associated to this code system.
     * @param description A description of the code system.
     * @param oids        OIDs associated with this code system.
     */
    public CodeSystemImpl(
            URI urn,
            String name,
            String description,
            String... oids) {
        Validate.notNull(urn, "URN must not be null.");
        this.urn = urn;
        this.name = name;
        this.description = description;
        this.oids = Collections.unmodifiableSet(OidImpl.toOrderedSet(oids));
    }

    /**
     * @param urn         The URN associated with this code system.
     * @param name        The name associated to this code system.
     * @param description A description of the code system.
     * @param oids        OIDs associated with this code system.
     */
    public CodeSystemImpl(
            String urn,
            String name,
            String description,
            String... oids) {
        this(URI.create(urn), name, description, oids);
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
     * @return The URN of this code system.
     */
    @Override
    public URI getUrn() {
        return urn;
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
        return Objects.hash(urn);
    }

    @Override
    public String toString() {
        return getUrnAsString();
    }

}
