package org.clinicalontology.terminology.impl.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.model.*;
import org.clinicalontology.terminology.api.service.TerminologyService;
import org.clinicalontology.terminology.impl.model.ConceptImpl;
import org.clinicalontology.terminology.impl.model.TerminologyMappingImpl;
import org.clinicalontology.terminology.impl.model.TerminologyMappingsImpl;
import org.clinicalontology.terminology.impl.model.ValueSetExpansionImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Only use for demos and tests. Not intended for use for actual terminology services as all value set expansions
 * are kept in memory.
 */
public class InMemoryTerminologyServiceImpl implements TerminologyService {

    /**
     * Indexes concepts by code system and code.
     */
    private static class ConceptIndex extends HashMap<String, Concept> {

        void put(Concept concept) {
            put(concept.getSystemAndCode(), concept);
        }

        Concept computeIfAbsent(
            String codeSystem,
            String code) {
            return computeIfAbsent(codeSystem + "|" + code, k -> new ConceptImpl(codeSystem, code));
        }

        boolean contains(Concept concept) {
            return containsKey(concept.getSystemAndCode());
        }

    }

    /**
     * Indexes value set expansions by versioned id.
     */
    private static class ExpansionIndex extends HashMap<String, ValueSetExpansion> {

        ValueSetExpansion get(ValueSetIdentifier valueSetIdentifier) {
            return get(valueSetIdentifier.getVersionedIdAsString());
        }

        boolean contains(ValueSetIdentifier valueSetIdentifier) {
            return containsKey(valueSetIdentifier.getVersionedIdAsString());
        }

        void put(ValueSetExpansion valueSetExpansion) {
            put(valueSetExpansion.getValueSetIdentifier().getVersionedIdAsString(), valueSetExpansion);
        }

        ValueSetExpansion computeIfAbsent(ValueSetIdentifier valueSetIdentifier) {
            return computeIfAbsent(valueSetIdentifier.getVersionedIdAsString(),
                k -> new ValueSetExpansionImpl(valueSetIdentifier));
        }
    }

    /**
     * Indexes terminology mappings by source concept.
     */
    private static class MappingsIndex extends HashMap<String, TerminologyMappings> {

        TerminologyMappings get(Concept concept) {
            return get(concept.getSystemAndCode());
        }

        TerminologyMappings computeIfAbsent(Concept concept) {
            return computeIfAbsent(concept.getSystemAndCode(), k -> new TerminologyMappingsImpl());
        }
    }

    private final ConceptIndex conceptIndex = new ConceptIndex();

    private final ExpansionIndex expansionIndex = new ExpansionIndex();

    private final MappingsIndex mappingIndex = new MappingsIndex();

    public void addConcept(Concept concept) {
        conceptIndex.put(concept);
    }

    @Override
    public Concept getConcept(String codeSystem, String code) {
        return conceptIndex.computeIfAbsent(codeSystem, code);
    }

    @Override
    public boolean isValidConcept(Concept concept) {
        return conceptIndex.contains(concept);
    }

    @Override
    public TerminologyMappings getMappingsForConcept(Concept source) {
        return mappingIndex.get(source);
    }

    @Override
    public TerminologyMappings getMappingsForConcept(
        Concept source,
        Concept category
    ) {
        TerminologyMappings filtered = new TerminologyMappingsImpl();
        getMappingsForConceptAsStream(source)
            .filter(m -> category.isEqual(m.getCategory()))
            .forEach(filtered::add);
        return filtered;
    }

    @Override
    public TerminologyMappings getMappingsForConcept(
        Concept source,
        String targetCodeSystem
    ) {
        TerminologyMappings filtered = new TerminologyMappingsImpl();
        getMappingsForConceptAsStream(source)
            .filter(m -> m.getTarget().hasCodeSystem(targetCodeSystem))
            .forEach(filtered::add);
        return filtered;
    }

    /**
     * Returns a stream of mappings for the specified source concept.
     *
     * @param source The source concept.
     * @return A stream of mappings for the specified source concept.
     */
    private Stream<TerminologyMapping> getMappingsForConceptAsStream(Concept source) {
        TerminologyMappings mappings = mappingIndex.get(source);
        List<TerminologyMapping> mappingsList = mappings == null ? Collections.emptyList() : mappings.getMappings();
        return mappingsList.stream();
    }

    /**
     * Adds a terminology mapping.
     *
     * @param source The source concept.
     * @param target The target concept.
     * @param type The mapping type.  Defaults to {@link TerminologyMappingType#TARGET_EQUIVALENT TARGET_EQUIVALENT}.
     */
    public void addTerminologyMapping(
        Concept source,
        Concept target,
        TerminologyMappingType type
    ) {
        if (type == null) {
            type = TerminologyMappingType.TARGET_EQUIVALENT;
        }

        TerminologyMapping terminologyMapping = new TerminologyMappingImpl(type, source, target);
        mappingIndex.computeIfAbsent(source).add(terminologyMapping);
    }

    @Override
    public boolean isValidValueSet(ValueSetIdentifier valueSetIdentifier) {
        return expansionIndex.contains(valueSetIdentifier);
    }

    @Override
    public boolean isMemberOfValueSet(
        ValueSetIdentifier valueSetIdentifier,
        Concept concept
    ) {
        ValueSetExpansion expansion = expansionIndex.get(valueSetIdentifier);
        return expansion != null && expansion.hasConcept(concept);
    }

    /**
     * Registers a value set.  If the value set already exists, the concepts are merged.
     *
     * @param valueSetIdentifier The value set identifier.
     * @param concepts The concepts in the value set.
     */
    public void registerValueSet(
        ValueSetIdentifier valueSetIdentifier,
        List<Concept> concepts
    ) {
        expansionIndex.computeIfAbsent(valueSetIdentifier).getExpansion()
            .addAll(concepts == null ? Collections.emptySet() : concepts);
    }

    /**
     * Adds a concept to a value set.  If the value set does not exist, it is created.
     *
     * @param valueSetIdentifier The value set identifier.
     * @param concept The concept to add.
     */
    public void addConceptToValueSet(
        ValueSetIdentifier valueSetIdentifier,
        Concept concept
    ) {
        expansionIndex.computeIfAbsent(valueSetIdentifier).getExpansion().add(concept);
    }

    /**
     * Format: (code system|code|display,...)
     *
     * @param valueSetIdentifier    A value set identifier.
     * @param serializedConceptList The serialized concept list.
     */
    public void parseAndRegisterValueSet(
        ValueSetIdentifier valueSetIdentifier,
        String serializedConceptList
    ) {
        if (StringUtils.isNotBlank(serializedConceptList)) {
            List<Concept> conceptList = new ArrayList<>();
            String[] serializedConcepts = serializedConceptList.split(",");

            for (String serializedConcept : serializedConcepts) {
                String[] pcs = serializedConcept.split("\\|");
                int len = pcs.length;
                Validate.isTrue(len > 1 && len < 4, "Invalid concept format: %s", serializedConcept);
                Concept concept = new ConceptImpl(pcs[0], pcs[1], len == 3 ? pcs[2] : null);
                conceptList.add(concept);
            }

            registerValueSet(valueSetIdentifier, conceptList);
        }
    }

    @Override
    public ValueSetExpansion getValueSetExpansion(ValueSetIdentifier valueSetIdentifier) {
        return expansionIndex.get(valueSetIdentifier);
    }

    @Override
    public void registerExternalValueSet(
        ValueSetExpansion valueSetExpansion,
        boolean allowOverrides
    ) {
        if (valueSetExpansion == null || valueSetExpansion.getValueSetIdentifier() == null || valueSetExpansion.getExpansion() == null) {
            return;
        }

        if (!allowOverrides && expansionIndex.contains(valueSetExpansion.getValueSetIdentifier())) {
            throw new RuntimeException("Value set " + valueSetExpansion.getValueSetIdentifier().getVersionedIdAsString() + " already exists");
        } else {
            expansionIndex.put(valueSetExpansion);
        }
    }
}
