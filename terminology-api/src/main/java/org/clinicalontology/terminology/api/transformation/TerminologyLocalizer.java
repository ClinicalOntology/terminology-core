package org.clinicalontology.terminology.api.transformation;

import java.util.List;

/**
 * Base interface for terminology localizers that transform a resource with a logical code to zero or more
 * resources with codes localized to a given site.
 *
 * @param <T> The resource type.
 */
public interface TerminologyLocalizer<T> extends TerminologyTransformer<T> {

    /**
     * Transforms a resource containing a logical code to zero or more resources localized to the given site.
     * If a resource does not contain a logical code, a list containing the original resource should be returned.
     *
     * @param resource The resource to transform.
     * @param siteId The id for the site.
     * @return A list of normalized resources (never null, possibly empty).
     */
    List<T> localize(
            T resource,
            String siteId);

}
