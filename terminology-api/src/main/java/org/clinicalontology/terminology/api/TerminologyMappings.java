package org.clinicalontology.terminology.api;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;

import java.util.Iterator;
import java.util.List;

/**
 * A collection of concept mappings.
 */
@SuppressWarnings("unused")
public interface TerminologyMappings extends Iterable<TerminologyMapping> {

    /**
     * @param mapping The concept mapping to add to the collection.
     */
    void add(TerminologyMapping... mapping);

    /**
     * @return The set of mappings contained in this collection.
     */
    List<TerminologyMapping> getMappings();

    /**
     * @return True if any mappings exist.
     */
    default boolean hasMappings() {
        return !CollectionUtils.isEmpty(getMappings());
    }

    /**
     * @return The number of mappings.
     */
    default int size() {
        return hasMappings() ? getMappings().size() : 0;
    }

    /**
     * @param targetCodeSystem The target code system used to filter the results.
     * @return The first mapping encountered whose target concept reference's code system matches the argument. Order is not guaranteed.
     */
    TerminologyMapping findFirstMatch(CodeSystem targetCodeSystem);

    /**
     * @param targetCodeSystem The target code system used to filter the results.
     * @return The set of mappings where the target concept of the mapping matches the targetCodeSystem argument.
     */
    List<TerminologyMapping> findMatches(CodeSystem targetCodeSystem);

    @Override
    default Iterator<TerminologyMapping> iterator() {
        return hasMappings() ? IteratorUtils.unmodifiableListIterator(getMappings().listIterator()) : IteratorUtils.emptyListIterator();
    }

}
