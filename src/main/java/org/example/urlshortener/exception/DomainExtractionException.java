package org.example.urlshortener.exception;

public class DomainExtractionException extends RuntimeException {
    public DomainExtractionException(String message) {
        super(message);
    }
}
