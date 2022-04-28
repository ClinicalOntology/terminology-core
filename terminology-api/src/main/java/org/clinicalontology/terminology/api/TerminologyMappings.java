package org.clinicalontology.terminology.api;

import org.apache.commons.collections4.IteratorUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
        List<TerminologyMapping> mappings = getMappings();
        return mappings != null && !mappings.isEmpty();
    }

    /**
     * @param targetCodeSystem The target code system used to filter the results.
     * @return The first mapping encountered whose target concept reference's code system matches the argument. Order is not guaranteed.
     */
    Optional<TerminologyMapping> findFirstMatch(CodeSystem targetCodeSystem);

    /**
     * @param targetCodeSystem The target code system used to filter the results.
     * @return The set of mappings where the target concept of the mapping matches the targetCodeSystem argument.
     */
    List<TerminologyMapping> findMatches(CodeSystem targetCodeSystem);

    @Override
    default Iterator<TerminologyMapping> iterator() {
        return hasMappings() ? getMappings().listIterator() : IteratorUtils.emptyListIterator();
    }

}
