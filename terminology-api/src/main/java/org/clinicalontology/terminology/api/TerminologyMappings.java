package org.clinicalontology.terminology.api;

import java.util.List;
import java.util.Optional;

/**
 * A collection of concept mappings.
 */
@SuppressWarnings("unused")
public interface TerminologyMappings {

    /**
     * @param mapping The concept mapping to add to the collection.
     */
    void add(TerminologyMapping... mapping);

    /**
     * @return The set of mappings contained in this collection.
     */
    List<TerminologyMapping> getMappings();

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

}
