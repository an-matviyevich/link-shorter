package org.example.urlshortener.exception;

public class InvalidURIException extends RuntimeException {
    public InvalidURIException(String message) {
        super(message);
    }
}
