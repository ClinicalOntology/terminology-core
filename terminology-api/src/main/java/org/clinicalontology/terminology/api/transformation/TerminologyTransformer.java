package org.clinicalontology.terminology.api.transformation;

/**
 * Base interface for terminology-based resource transforms.
 *
 * @param <T> The type of resource being transformed.
 */
public interface TerminologyTransformer<T> {

    /**
     * @return The resource type handled by the transform.
     */
    Class<T> getTargetClass();

}
