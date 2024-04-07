package org.clinicalontology.terminology.api.model;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A set of synonymous concepts (across terminologies). For collection of non-synonymous
 * concepts use a Set&lt;Concept&gt; instead.
 */
@SuppressWarnings("unused")
public interface ConceptSet extends Iterable<Concept> {

    /**
     * @return The textual representation of the concept.
     */
    String getText();

    /**
     * Sets the textual representation of the concept.
     *
     * @param text The textual representation.
     */
    void setText(String text);

    /**
     * @return True if this set has a textual representation.
     */
    default boolean hasText() {
        return StringUtils.isNotEmpty(getText());
    }

    /**
     * Returns displayable text from a concept set by concatenating the preferred names of all the member concepts.
     *
     * @return The displayable text.
     */
    default String concatenatedDisplayText() {
        StringBuilder sb = new StringBuilder();

        if (hasConcepts()) {
            for (Concept concept : this) {
                if (StringUtils.isNotBlank(concept.getPreferredName())) {
                    sb.append(!sb.isEmpty() ? "; " : "");
                    sb.append(concept.getPreferredName());
                }
            }
        }

        return sb.toString();
    }

    /**
     * @return The set of synonymous concepts.
     */
    Set<Concept> getConcepts();

    /**
     * Sets the concepts for the set.  All concepts must be considered synonymous.
     *
     * @param concepts A set of synonymous concepts.
     */
    void setConcepts(Set<Concept> concepts);

    /**
     * @return True if not the empty set.
     */
    default boolean hasConcepts() {
        return CollectionUtils.isNotEmpty(getConcepts());
    }

    /**
     * Adds a synonymous concept.
     *
     * @param concept The concept to add.
     */
    void addConcept(Concept concept);

    /**
     * Returns a stream containing all concepts with the given code system.
     *
     * @param system The code system to the match.
     * @return Stream of all concepts with the given code system.
     */
    default Stream<Concept> getStreamByCodeSystem(URI system) {
        return getConcepts().stream()
                .filter(concept -> concept.hasCodeSystem() && (
                        system.equals(concept.getCodeSystem().getUrn())));
    }

    /**
     * Returns all concepts with the given code system.
     *
     * @param system The code system to the match.
     * @return All concepts with the given code system.
     */
    default Set<Concept> getByCodeSystem(URI system) {
        return getStreamByCodeSystem(system).collect(Collectors.toSet());
    }

    /**
     * Returns all concepts with the given code system.
     *
     * @param system The code system to the match.
     * @return All concepts with the given code system.
     */
    default Set<Concept> getByCodeSystem(String system) {
        return getByCodeSystem(URI.create(system));
    }

    /**
     * Returns all concepts with the given code system.
     *
     * @param system The code system to the match.
     * @return All concepts with the given code system.
     */
    default Set<Concept> getByCodeSystem(CodeSystem system) {
        return getByCodeSystem(system.getUrn());
    }

    /**
     * Returns the first concept found for the given code system.
     *
     * @param system The code system to the match.
     * @return The first concept found for the given code system.
     */
    default Concept getFirstByCodeSystem(URI system) {
        return getStreamByCodeSystem(system).findFirst().orElse(null);
    }

    /**
     * Returns the first concept found for the given code system.
     *
     * @param system The code system to the match.
     * @return The first concept found for the given code system.
     */
    default Concept getFirstByCodeSystem(String system) {
        return getFirstByCodeSystem(URI.create(system));
    }

    /**
     * Returns the first concept found for the given code system.
     *
     * @param system The code system to the match.
     * @return The first concept found for the given code system.
     */
    default Concept getFirstByCodeSystem(CodeSystem system) {
        return getConcepts().stream()
                .filter(concept -> concept.getCodeSystem().equals(system))
                .findFirst()
                .orElse(null);
    }

    /**
     * @return Returns the first concept in the set. Order is not guaranteed.
     */
    default Concept getFirstConcept() {
        return getConcepts().stream().findFirst().orElse(null);
    }

    /**
     * Returns the first concept in the set that belongs to the specified code system.
     *
     * @param system The code system to the match.
     * @return The first concept with the specified code system, or null if there is none.
     */
    default Concept getFirstConcept(String system) {
        for (Concept element : getConcepts()) {
            if (system.equals(element.getCodeSystemAsString())) {
                return element;
            }
        }
        return null;
    }

    /**
     * @return Returns the singleton element or throws an error if set contains more than one element.
     *         Returns null if set contains no concept.
     */
    default Concept getSoleConcept() {
        Validate.isTrue(getConcepts().size() < 2,
                "There is more than one concept in this set potentially resulting in a non-deterministic outcome");
        return getFirstConcept();
    }

    /**
     * Method returns true if this concept set contains a concept that is equivalent to the target
     * concept.
     *
     * @param target The concept to be matched.
     * @return True if this concept set contains a concept that is equivalent to the target concept.
     */
    default boolean contains(Concept target) {
        return getConcepts().stream().anyMatch(concept -> concept.isEqual(target));
    }

    /**
     * Returns true if concept reference set contains a concept reference that is equivalent to any of the
     * specified targets.
     *
     * @param targets    The concept references we wish to locate in the set.
     * @return True if concept reference set contains a concept reference that is equivalent to any of the specified targets.
     */
    default boolean contains(List<Concept> targets) {
        return targets.stream().anyMatch(this::contains);
    }

    /**
     * Returns true if concept reference set contains a concept reference that is equivalent to any of the
     * specified targets.
     *
     * @param targets    The concept references we wish to locate in the set.
     * @return True if concept reference set contains a concept reference that is equivalent to any of the specified targets.
     */
    default boolean contains(Concept... targets) {
        return contains(Arrays.asList(targets));
    }

    /**
     * Returns displayable text from a concept set.  First tries the text attribute.
     * If the text attribute is blank, it tries the preferred name of each of the member concepts
     * until it finds a non-blank value.
     *
     * @return The display text (empty string if none available).
     */
    default String getDisplayText() {
        return hasText() ? getText() :
                getConcepts().stream()
                        .map(Concept::getDisplayText)
                        .filter(StringUtils::isNotEmpty)
                        .findFirst()
                        .orElse("");
    }

    /**
     * Returns the concepts common to both sets.
     *
     * @param other The other set whose intersection we are interested in
     * @return The concepts common to both sets.
     */
    default Set<Concept> getIntersection(ConceptSet other) {
        if (!this.hasConcepts() || !other.hasConcepts()) {
            return Collections.emptySet();
        } else {
            Set<Concept> intersection = new HashSet<>(this.getConcepts());
            intersection.retainAll(other.getConcepts());
            return intersection;
        }
    }

    /**
     * Returns true if the two sets share at least one concept in common.
     *
     * @param other Second concept set to compare.
     * @return True if the two sets share at least one concept in common.
     */
    default boolean intersects(ConceptSet other) {
        return !getIntersection(other).isEmpty();
    }

    /**
     * Allows iterating over concepts.
     *
     * @return A concept iterator.
     */
    @Override
    default Iterator<Concept> iterator() {
        return hasConcepts() ? IteratorUtils.unmodifiableIterator(getConcepts().iterator()) : IteratorUtils.emptyIterator();
    }

}
