package org.clinicalontology.terminology.util;

import org.clinicalontology.terminology.api.model.Concept;
import org.clinicalontology.terminology.api.model.ConceptSet;
import org.clinicalontology.terminology.api.model.SemanticKey;
import org.clinicalontology.terminology.api.model.ValueSetIdentifier;
import org.clinicalontology.terminology.api.service.TerminologyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class supporting terminological operations on items that contain semantic keys.
 * By semantic key we mean a concept that is important to conveying the semantics of the class (e.g., Condition.code)
 * or the main focus of the class (e.g., MedicationRequest.code).
 * <p>
 * Predicate and Function factory methods are also provided for stream use cases.
 *
 * @param <T> The classifier type.
 */
public class KeyInValueSetGrouper<T extends SemanticKey> {

    private static final ValueSetIdentifier[] EMPTY_ARRAY = {};

    /**
     * Terminology service for item key value set membership determination.
     */
    private final TerminologyService terminologyService;

    /**
     * A map that groups keyed items in a list based on which value set the key belongs to.
     */
    private final ItemGroupByValueSetMembershipIndex<T> itemKeyToValueSetMembershipIndex = new ItemGroupByValueSetMembershipIndex<>();

    /**
     * The value sets considered for the key membership test - e.g., a group of disjoint medication class value sets and
     * a list of prescriptions keyed by medication code with the aim of grouping prescriptions by drug class.
     */
    private final List<ValueSetIdentifier> defaultValueSets;

    /**
     * A list of all relevant items contained in this bundle.
     */
    private List<T> semanticKeyItemList;

    /**
     * @param terminologyService  Terminology service for value set membership testing.
     * @param semanticKeyItemList A list of resources to group based on focal concept membership in a value set.,
     * @param defaultValueSets    Optional default value sets that will form the subgroups of items.
     */
    public KeyInValueSetGrouper(
            TerminologyService terminologyService,
            List<T> semanticKeyItemList,
            List<ValueSetIdentifier> defaultValueSets) {
        this.terminologyService = terminologyService;
        this.defaultValueSets = defaultValueSets == null ? new ArrayList<>() : defaultValueSets;
        setSemanticKeyItemList(semanticKeyItemList);
    }

    /**
     * @return The terminology service associated with this helper class.
     */
    public TerminologyService getTerminologyService() {
        return terminologyService;
    }

    /**
     * @return The ItemKeyToValueSetMembershipIndex
     */
    public ItemGroupByValueSetMembershipIndex<T> getItemGroupByValueSetMembershipIndex() {
        return itemKeyToValueSetMembershipIndex;
    }

    /**
     * @return The initial list of items.
     */
    public List<T> getSemanticKeyItemList() {
        return semanticKeyItemList;
    }

    /**
     * Sets the list of items that will be grouped by semantic key membership in a value set.
     * Resources will be automatically grouped by all default value sets.  Additional groupings
     * are done on demand.  Note, this resets the membership map.
     *
     * @param semanticKeyItemList The resource list
     */
    public void setSemanticKeyItemList(List<T> semanticKeyItemList) {
        this.semanticKeyItemList = semanticKeyItemList == null ? new ArrayList<>() : semanticKeyItemList;
        indexResources();
    }

    public void indexResources() {
        itemKeyToValueSetMembershipIndex.clear();

        for (ValueSetIdentifier valueSet : defaultValueSets) {
            this.getResourcesInValueSet(valueSet);
        }
    }

    /**
     * Returns all items whose semantic key is a member of the value set.
     *
     * @param valueSet The value set identifier.
     * @return All items whose semantic key is a member of the value set.
     */
    public List<T> getResourcesInValueSet(ValueSetIdentifier valueSet) {
        if (valueSet == null) {
            return Collections.emptyList();
        }

        List<T> filteredResources = itemKeyToValueSetMembershipIndex.get(valueSet);

        if (filteredResources == null) {
            itemKeyToValueSetMembershipIndex.put(valueSet, filteredResources = getFilteredResources(valueSet));
        }

        return filteredResources;
    }

    /**
     * @return All items that are associated with the default value set (which is the first value set
     *         in the defaultValueSets list.
     */
    public List<T> getResourcesInDefaultValueSet() {
        return getResourcesInValueSet(defaultValueSets.isEmpty() ? null : defaultValueSets.get(0));
    }

    /**
     * Tests whether an item with the specified semantic key (e.g., Observation.code, Condition.code,
     * MedicationOrder.medication.code, ...) is a member of the specified value set. For instance, one may
     * wish to get all MedicationOrder resources for smoking cessation medications.
     * <p>
     * Note: The specified value set is not limited to those in the defaultValueSets array.
     *
     * @param keyedElement Resource to test.
     * @param valueSet     The value set's identifier.
     * @return True if the resource's focal concept is a member of the valueset.
     */
    private boolean findInValueSet(
            SemanticKey keyedElement,
            ValueSetIdentifier valueSet) {
        try {
            ConceptSet semanticKey = valueSet == null ? null : keyedElement.getSemanticKey();

            if (semanticKey != null) {
                for (Concept code : semanticKey.getConcepts()) {
                    if (getTerminologyService().isMemberOfConceptSetExpansion(valueSet, code)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            //log.error("Error checking focal concept against value set", e);
        }

        return false;
    }

    /**
     * Returns a predicate that tests whether the item's semantic key is a member of
     * the associated value set.
     *
     * @param valueSet A valueset identifier.
     * @return A predicate.
     */
    public Predicate<T> getResourceInValueSetPredicate(ValueSetIdentifier valueSet) {
        return resource -> findInValueSet(resource, valueSet);
    }

    /**
     * Returns a filtered list of items whose semantic key is a member of the value set.
     *
     * @param valueSet The value set used to filter resources by their semantic key.
     * @return The filtered list (never null).
     */
    private List<T> getFilteredResources(ValueSetIdentifier valueSet) {
        if (this.semanticKeyItemList != null && !this.semanticKeyItemList.isEmpty()) {
            return this.semanticKeyItemList
                    .stream()
                    .filter(getResourceInValueSetPredicate(valueSet))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

}
