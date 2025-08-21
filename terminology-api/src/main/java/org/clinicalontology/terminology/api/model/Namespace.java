package org.clinicalontology.terminology.api.model;

import java.net.URI;

public class Namespace {
        private String alias;
        private URI uri;

        public Namespace(String alias, URI uri) {
            this.alias = alias;
            this.uri = uri;
        }

        public Namespace(String alias, String uri) {
            this.alias = alias;
            this.uri = URI.create(uri);
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public URI getUri() {
            return uri;
        }

        public String getUriAsString() {
            return uri.toString();
        }

        public void setUrl(URI uri) {
            this.uri = uri;
        }
    }
