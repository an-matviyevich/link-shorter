package org.example.urlshortener.domain;

public class Provider {
    private String uri;

    public Provider(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
