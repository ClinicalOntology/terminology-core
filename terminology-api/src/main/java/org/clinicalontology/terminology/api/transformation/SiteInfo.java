package org.clinicalontology.terminology.api.transformation;

/**
 * Information about the site that is the target of a transformation.
 *
 * @param siteId The unique site ID.
 * @param siteDomain The site's domain.
 */
public record SiteInfo(
        String siteId,
        String siteDomain) {
}
