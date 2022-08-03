package org.clinicalontology.terminology.api.transformation;

/**
 * Base interface for terminology normalizers that convert codes identifying a resource to their normalized form.
 *
 * @param <T> The resource type.
 */
public interface TerminologyNormalizer<T> extends TerminologyTransformer<T> {

    /**
     * Replace all codes identifying a resource to their normalized form.  The returned resource may be the original
     * instance whose codes are normalized in place or a clone of the original.
     *
     * @param resource The resource.
     * @return The resource with all identifying codes normalized.
     */
    T normalize(T resource);

}
