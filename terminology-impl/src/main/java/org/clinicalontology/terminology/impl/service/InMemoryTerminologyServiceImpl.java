package org.clinicalontology.terminology.impl.service;

import org.apache.commons.lang3.StringUtils;
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

    private final Map<String, Map<String, Concept>> expansionIndex = new HashMap<>();

    private final Map<String, TerminologyMappings> mappingIndex = new HashMap<>();

    @Override
    public boolean isMemberOfValueSet(
            ValueSetIdentifier valueSetIdentifier,
            Concept concept) {
        String valueSetId = valueSetIdentifier.getVersionedIdentifier().toString();
        Map<String, Concept> expansion = expansionIndex.get(valueSetId);
        return expansion != null && expansion.containsKey(getConceptIndexKey(concept));
    }

    @Override
    public TerminologyMappings getMappingsForConcept(Concept source) {
        return mappingIndex.get(source.getSystemAndCode());
    }

    @Override
    public TerminologyMappings getMappingsForConcept(
            Concept source,
            Concept category) {
        TerminologyMappings filtered = new TerminologyMappingsImpl();
        getMappingsForConcept(source).getMappings().stream()
                .filter(m -> category.isEqual(m.getCategory()))
                .forEach(filtered::add);
        return filtered;
    }

    @Override
    public TerminologyMappings getMappingsForConcept(Concept source, String targetCodeSystem) {
        TerminologyMappings filtered = new TerminologyMappingsImpl();
        getMappingsForConcept(source).getMappings().stream()
                .filter(m -> targetCodeSystem.equals(m.getTarget().getCodeAsString()))
                .forEach(filtered::add);
        return filtered;
    }

    public void addTerminologyMapping(
            Concept source,
            Concept target,
            TerminologyMappingType type) {
        if (type == null) {
            type = TerminologyMappingType.TARGET_EQUIVALENT;
        }

        TerminologyMapping terminologyMapping = new TerminologyMappingImpl(type, source, target);
        TerminologyMappings mappings = mappingIndex.get(source.getSystemAndCode());

        if (mappings == null) {
            mappings = new TerminologyMappingsImpl();
            mappingIndex.put(source.getSystemAndCode(), mappings);
        }

        mappings.add(terminologyMapping);
    }

    @Override
    public boolean isValidConcept(Concept concept) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getConceptFSN(Concept concept) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getConceptFSN(
            Concept concept,
            Language language) {
        return null;
    }

    @Override
    public String getConceptDefinition(
            Concept concept,
            Language language) {
        return null;
    }

    @Override
    public List<String> getConceptSynonyms(
            Concept concept,
            Language language) {
        return null;
    }

    @Override
    public boolean isValidValueSet(ValueSetIdentifier valueSetIdentifier) {
        throw new RuntimeException("Not implemented yet");
    }

    public void registerValueSet(
            ValueSetExpansion valueSet,
            List<Concept> concepts) {
        registerValueSet(valueSet.getVersionedIdentifier().toString(), concepts);
    }

    public void registerValueSet(
            String valueSetVersionedIdentifier,
            List<Concept> concepts) {
        Map<String, Concept> expansion = expansionIndex.computeIfAbsent(valueSetVersionedIdentifier, k -> new HashMap<>());

        if (concepts != null) {
            for (Concept concept : concepts) {
                expansion.put(getConceptIndexKey(concept), concept);
            }
        }
    }

    public void addConceptToValueSet(
            ValueSetExpansion valueSet,
            Concept concept) {
        addConceptToValueSet(valueSet.getVersionedIdentifier().toString(), concept);
    }

    public void addConceptToValueSet(
            String valueSetVersionedIdentifier,
            Concept concept) {
        Map<String, Concept> expansion = expansionIndex.computeIfAbsent(valueSetVersionedIdentifier, k -> new HashMap<>());
        expansion.put(getConceptIndexKey(concept), concept);
    }

    public String getConceptIndexKey(Concept concept) {
        return concept.getCodeSystem() + "--" + concept.getCode();
    }

    /**
     * Format: (codesystem,code,display|)+
     *
     * @param valueSetIdentifier    A value set identifier.
     * @param serializedConceptList The serialized concept list.
     */
    public void parseAndRegisterValueSet(
            ValueSetIdentifier valueSetIdentifier,
            String serializedConceptList) { //TODO add regex to validate serializedConceptList format.
        if (StringUtils.isNotBlank(serializedConceptList)) {
            List<Concept> conceptList = new ArrayList<>();
            String[] serializedConcepts = serializedConceptList.split("\\|");

            for (String serializedConcept : serializedConcepts) {
                String[] conceptComponents = serializedConcept.split(",");
                Concept concept = new ConceptImpl(conceptComponents[0], conceptComponents[1], conceptComponents[2]);
                conceptList.add(concept);
            }

            registerValueSet(valueSetIdentifier.getVersionedIdentifier().toString(), conceptList);
        }
    }

    @Override
    public ValueSetExpansion getValueSetExpansion(ValueSetIdentifier valueSetIdentifier) {
        Map<String, Concept> conceptMap = expansionIndex.get(valueSetIdentifier.getVersionedIdentifier().toString());
        Set<Concept> expansion = conceptMap == null ? null : new HashSet<>(conceptMap.values());
        return new ValueSetExpansionImpl(valueSetIdentifier, expansion);
    }

    @Override
    public String getValueSetExpansionAsString(ValueSetIdentifier valueSetIdentifier) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Set<ConceptDescription> getDescriptions(
            Concept concept,
            Language language) {
        return Collections.emptySet();
    }

    @Override
    public List<String> getConceptDescriptions(
            Concept concept,
            DescriptionType descriptionType,
            Language language) {
        return Collections.emptyList();
    }

    @Override
    public void registerExternalValueSet(ValueSetExpansion valueSetExpansion, boolean allowOverrides) {
        if(valueSetExpansion == null || valueSetExpansion.getValueSetIdentifier() == null || valueSetExpansion.getExpansion() == null) {
            return;
        } else if(expansionIndex.containsKey(valueSetExpansion.getValueSetIdentifier().getVersionedIdentifier().toString()) && !allowOverrides) {
            throw new RuntimeException("Value set " + valueSetExpansion.getValueSetIdentifier().getVersionedIdentifier() + " already exists");
        } else {
            Map<String, Concept> indexedConceptsById = new HashMap<>();
            if (valueSetExpansion.getExpansion() != null) {
                for (Concept concept : valueSetExpansion.getExpansion()) {
                    indexedConceptsById.put(getConceptIndexKey(concept), concept);
                }
            }
            expansionIndex.put(valueSetExpansion.getValueSetIdentifier().getVersionedIdentifier().toString(), indexedConceptsById);
        }
    }
}
