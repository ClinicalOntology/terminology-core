package org.clinicalontology.terminology.impl.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.model.CodeSystem;
import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.Oid;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Implementation of {@link CodeSystem}.
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
     * The unique URN representing this code system.
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
        String... oids
    ) {
        return StringUtils.isBlank(urn) ? null : new CodeSystemImpl(URI.create(urn), null, null, oids);
    }

    /**
     * Create a code system.  Returns null if the URN is null or empty.
     *
     * @param urn The URN.
     * @return The newly created code system.
     */
    public static CodeSystem create(String urn) {
        return StringUtils.isBlank(urn) ? null : new CodeSystemImpl(urn, null, null);
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
    @SuppressWarnings("unused")
    private CodeSystemImpl() {
        urn = null;
        name = null;
        description = null;
        oids = null;
    }

    /**
     * Create a code system.
     *
     * @param urn The URN for this code system.
     */
    public CodeSystemImpl(URI urn) {
        this(urn, null, null);
    }

    /**
     * Create a code system.
     *
     * @param urn The URN for this code system as a string.
     */
    public CodeSystemImpl(String urn) {
        this(urn, null, null);
    }

    /**
     * Create a code system.
     *
     * @param urn  The URN associated with this code system.
     * @param name The name associated with this code system.
     */
    public CodeSystemImpl(
        URI urn,
        String name
    ) {
        this(urn, name, null);
    }

    /**
     * Create a code system.
     *
     * @param urn  The URN associated with this code system.
     * @param name The name associated with this code system.
     */
    public CodeSystemImpl(
        String urn,
        String name
    ) {
        this(urn, name, null);
    }

    /**
     * Create a code system.
     *
     * @param urn         The URN associated with this code system.
     * @param name        The name associated with this code system.
     * @param description A description of the code system.
     * @param oids        OIDs associated with this code system.
     */
    public CodeSystemImpl(
        URI urn,
        String name,
        String description,
        String... oids
    ) {
        Validate.notNull(urn, "URN must not be null.");
        this.urn = urn;
        this.name = name;
        this.description = description;
        this.oids = Collections.unmodifiableSet(OidImpl.toOrderedSet(oids));
    }

    /**
     * Create a code system.
     *
     * @param urn         The URN associated with this code system.
     * @param name        The name associated with this code system.
     * @param description A description of the code system.
     * @param oids        OIDs associated with this code system.
     */
    public CodeSystemImpl(
        String urn,
        String name,
        String description,
        String... oids
    ) {
        this(URI.create(urn), name, description, oids);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public URI getUrn() {
        return urn;
    }

    @Override
    public Set<Oid> getOids() {
        return oids == null ? Collections.emptySet() : oids;
    }

    @Override
    public Concept newConcept(String code, String preferredName) {
        return new ConceptImpl(this, code, preferredName);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof CodeSystem && isEqual(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urn);
    }

    @Override
    public String toString() {
        return Objects.toString(getUrn());
    }

}
