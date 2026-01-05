package org.clinicalontology.terminology.api.model;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of concept mappings.
 */
public interface TerminologyMappings extends Serializable, Iterable<TerminologyMapping> {

    /**
     * Adds a concept mapping to the collection.
     *
     * @param mapping The concept mapping to add to the collection.
     */
    void add(TerminologyMapping... mapping);

    /**
     * Returns the set of mappings contained in this collection.
     *
     * @return The set of mappings contained in this collection.
     */
    List<TerminologyMapping> getMappings();

    /**
     * Returns true if any mappings exist.
     *
     * @return True if any mappings exist.
     */
    @Transient
    default boolean hasMappings() {
        return !CollectionUtils.isEmpty(getMappings());
    }

    /**
     * Returns the number of mappings.
     *
     * @return The number of mappings.
     */
    @Transient
    default int size() {
        return hasMappings() ? getMappings().size() : 0;
    }

    /**
     * Returns the first mapping encountered whose target concept reference's code system matches the argument.
     *
     * @param targetCodeSystem The target code system used to filter the results.
     * @return The first mapping encountered whose target concept reference's code system matches the argument. Order is not guaranteed.
     */
    TerminologyMapping findFirstMatch(CodeSystem targetCodeSystem);

    /**
     * Returns the set of mappings where the target concept of the mapping matches the targetCodeSystem argument.
     *
     * @param targetCodeSystem The target code system used to filter the results.
     * @return The set of mappings where the target concept of the mapping matches the targetCodeSystem argument.
     */
    List<TerminologyMapping> findMatches(CodeSystem targetCodeSystem);

    @Override
    default Iterator<TerminologyMapping> iterator() {
        return hasMappings() ? IteratorUtils.unmodifiableListIterator(getMappings().listIterator()) : IteratorUtils.emptyListIterator();
    }

}
