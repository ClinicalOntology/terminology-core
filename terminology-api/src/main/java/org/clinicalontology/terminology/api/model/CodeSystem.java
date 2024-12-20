package org.clinicalontology.terminology.api.model;

import org.apache.commons.lang3.Validate;

import java.beans.Transient;
import java.io.Serializable;
import java.net.URI;
import java.util.Objects;
import java.util.Set;

/**
 * CodeSystem represents a terminology namespace such as the URN assigned
 * to an ontology. Typically, code systems represents the namespace that ensure
 * the uniqueness of codes in the terminology.
 */
@SuppressWarnings("unused")
public interface CodeSystem extends Serializable {

    /**
     * @return The name of the code system.
     */
    String getName();

    /**
     * @return The description of this code system.
     */
    String getDescription();

    /**
     * @return The URN of this code system.
     */
    URI getUrn();

    /**
     * @return The OIDs associated with this code system.
     */
    Set<Oid> getOids();

    /**
     * @return The URN as a string value.
     */
    @Transient
    default String getUrnAsString() {
        return getUrn() != null ? getUrn().toString() : null;
    }

    /**
     * @return Returns the first OID in the set. Order is not guaranteed.
     */
    @Transient
    default Oid getFirstOid() {
        return getOids().stream()
            .findFirst()
            .orElse(null);
    }

    /**
     * @return Returns the sole OID or throws an error if set contains more than one element. Returns null if set
     *     contains no concept.
     */
    @Transient
    default Oid getSoleOid() {
        Validate.isTrue(getOids().size() < 2,
            "There is more than one OID in this set potentially resulting in a non-deterministic outcome");
        return getFirstOid();
    }

    /**
     * Returns true if this and the target are equal.  Two code systems are considered equal if their URNs match or they
     * share a common OID.
     * <p></p>
     * <i>Note: </i>Each interface implementation's {@link #equals} method should delegate to this.  Note that the
     * {@link #equals} method of enums implementing this interface is set to final, so calling this method should
     * be the preferred way when enums are involved.  If enum behavior is desired without this restriction, consider
     * using the {@link CodeSystemEnumerator} class.
     *
     * @param target The object to compare.
     * @return True if equal.
     */
    default boolean isEqual(Object target) {
        if (this == target) {
            return true;
        }

        if (!(target instanceof CodeSystem)) {
            return false;
        }

        CodeSystem cs = (CodeSystem) target;

        if (Objects.equals(getUrn(), cs.getUrn())) {
            return true;
        }

        return getOids().stream().anyMatch(oid -> cs.getOids().contains(oid));
    }

    default Concept newConcept(String code) {
        return newConcept(code, null);
    }

    Concept newConcept(String code, String preferredName);
}
