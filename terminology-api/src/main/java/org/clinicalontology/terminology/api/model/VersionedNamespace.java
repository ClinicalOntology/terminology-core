package org.clinicalontology.terminology.api.model;

import java.net.URI;

public class VersionedNamespace extends Namespace {
    private String version;

    public VersionedNamespace(String alias, URI uri, String version) {
        super(alias, uri);
        this.version = version;
    }

    public VersionedNamespace(String alias, String uri, String version) {
        super(alias, uri);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
