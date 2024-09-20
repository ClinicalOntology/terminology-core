package org.clinicalontology.terminology.impl.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.clinicalontology.terminology.api.model.*;
import org.clinicalontology.terminology.api.service.TerminologyService;
import org.clinicalontology.terminology.impl.model.ConceptImpl;
import org.clinicalontology.terminology.impl.model.TerminologyMappingImpl;
import org.clinicalontology.terminology.impl.model.TerminologyMappingsImpl;
import org.clinicalontology.terminology.impl.model.ValueSetExpansionImpl;

import java.util.*;

/**
 * Only use for demos and tests. Do not use for actual terminology services as all value set expansions are kept in memory.
 */
public class InMemoryTerminologyServiceImpl implements TerminologyService {

    private static class ConceptIndex extends HashMap<String, Concept> {
        void put(Concept concept) {
            put(concept.getSystemAndCode(), concept);
        }

        Concept computeIfAbsent(String codeSystem, String code) {
            return computeIfAbsent(codeSystem + "|" + code, k -> new ConceptImpl(codeSystem, code));
        }

        boolean contains(Concept concept) {
            return containsKey(concept.getSystemAndCode());
        }

        void putAll(Collection<Concept> concepts) {
            if (concepts != null) {
                concepts.forEach(this::put);
            }
        }
    }

    private static class ExpansionIndex extends HashMap<String, ConceptIndex> {
        ConceptIndex get(ValueSetIdentifier valueSetIdentifier) {
            return get(valueSetIdentifier.getVersionedIdentifier().toString());
        }

        boolean contains(ValueSetIdentifier valueSetIdentifier) {
            return containsKey(valueSetIdentifier.getVersionedIdentifier().toString());
        }

        void put(ValueSetIdentifier valueSetIdentifier, ConceptIndex conceptIndex) {
            put(valueSetIdentifier.getVersionedIdentifier().toString(), conceptIndex);
        }

        ConceptIndex computeIfAbsent(ValueSetIdentifier valueSetIdentifier) {
            return computeIfAbsent(valueSetIdentifier.getVersionedIdentifier().toString(), k -> new ConceptIndex());
        }
    }

    private static class MappingsIndex extends HashMap<String, TerminologyMappings> {
        TerminologyMappings get(Concept concept) {
            return get(concept.getSystemAndCode());
        }

        void put(Concept concept, TerminologyMappings mappings) {
            put(concept.getSystemAndCode(), mappings);
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
        getMappingsForConcept(source).getMappings().stream()
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
        getMappingsForConcept(source).getMappings().stream()
            .filter(m -> targetCodeSystem.equals(m.getTarget().getCodeAsString()))
            .forEach(filtered::add);
        return filtered;
    }

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
        ConceptIndex expansion = expansionIndex.get(valueSetIdentifier);
        return expansion != null && expansion.contains(concept);
    }

    public void registerValueSet(
        ValueSetIdentifier valueSetIdentifier,
        List<Concept> concepts
    ) {
        expansionIndex.computeIfAbsent(valueSetIdentifier).putAll(concepts);
    }

    public void addConceptToValueSet(
        ValueSetIdentifier valueSetIdentifier,
        Concept concept
    ) {
        expansionIndex.computeIfAbsent(valueSetIdentifier).put(concept);
    }

    /**
     * Format: (codesystem|code|display,...)
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
        ConceptIndex conceptMap = expansionIndex.computeIfAbsent(valueSetIdentifier);
        return new ValueSetExpansionImpl(valueSetIdentifier, new HashSet<>(conceptMap.values()));
    }

    @Override
    public void registerExternalValueSet(
        ValueSetExpansion valueSetExpansion,
        boolean allowOverrides
    ) {
        if (valueSetExpansion == null || valueSetExpansion.getValueSetIdentifier() == null || valueSetExpansion.getExpansion() == null) {
            return;
        } else if (!allowOverrides && expansionIndex.contains(valueSetExpansion.getValueSetIdentifier())) {
            throw new RuntimeException("Value set " + valueSetExpansion.getValueSetIdentifier().getVersionedIdentifier() + " already exists");
        } else {
            ConceptIndex conceptMap = new ConceptIndex();
            conceptMap.putAll(valueSetExpansion.getExpansion());
            expansionIndex.put(valueSetExpansion.getValueSetIdentifier(), conceptMap);
        }
    }
}
