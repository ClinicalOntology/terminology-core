package org.clinicalontology.terminology.impl;

import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.CodeSystem;
import org.clinicalontology.terminology.api.Oid;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Class represents a terminology namespace such as the URI assigned
 * to an ontology. Typically code systems represents the namespace that ensure
 * the uniqueness of codes in the terminology.
 */
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
     * For deserialization.
     */
    @SuppressWarnings("unused")
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
        this(URI.create(urn));
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
        Validate.isTrue(urn != null, "URN must not be null.");
        this.urn = urn;
        this.name = name;
        this.description = description;
        this.oids = Collections.unmodifiableSet(OidImpl.toOrderedSet(oids));
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
