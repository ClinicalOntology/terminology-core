package org.clinicalontology.terminology.util;

import org.clinicalontology.terminology.api.model.SemanticKey;
import org.clinicalontology.terminology.api.model.ValueSetIdentifier;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Associates a value set with a set of items whose semantic key are elements that set.
 *
 * @param <T> The item type.
 */
public class ItemGroupByValueSetMembershipIndex<T extends SemanticKey> {

    /**
     * The value-set-to-item-list index.
     */
    private final Map<ValueSetIdentifier, List<T>> map = new LinkedHashMap<>();

    /**
     * Returns the list of items whose key is part of this value set.
     *
     * @param valueSet Value set used for grouping.
     * @return Returns all items whose keys are in the value set.
     */
    public List<T> get(ValueSetIdentifier valueSet) {
        return map.get(valueSet);
    }

    /**
     * Returns the set of valuesets that are part of this index.
     *
     * @return Returns the value set identifiers associated with this indexer.
     */
    public Set<ValueSetIdentifier> keySet() {
        return map.keySet();
    }

    /**
     * Adds a new entry to this value set - i.e., a value set and the set of references with concept keys in this value set.
     *
     * @param valueSet Value set key for given item group.
     * @param items    The group of items associated with the value set identifier.
     */
    public void put(
            ValueSetIdentifier valueSet,
            List<T> items) {
        map.put(valueSet, items);
    }

    /**
     * Adds a new entry to this value set - i.e., a value set and the set of references with concept keys in this value set.
     *
     * @param valueSet The value set.
     * @param item     The item to add.
     */
    public void put(
            ValueSetIdentifier valueSet,
            T item) {
        map.computeIfAbsent(valueSet, k -> new ArrayList<>()).add(item);
    }

    /**
     * Method clears this index. Use with caution.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Executes for-each lambda action argument.
     *
     * @param action The action to execute.
     */
    public void forEach(BiConsumer<? super ValueSetIdentifier, ? super List<T>> action) {
        map.forEach(action);
    }

    /**
     * Returns true if the value set has at least one member.
     *
     * @param valueSet The value set.
     * @return True if the value set has at least one member.
     */
    public boolean hasMembers(ValueSetIdentifier valueSet) {
        List<T> members = get(valueSet);
        return members != null && !members.isEmpty();
    }

    /**
     * @return True if the index is empty.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * @return True if the map has one or more entries.
     */
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    /**
     * @return The size of the index.
     */
    public int size() {
        return map.size();
    }

}
