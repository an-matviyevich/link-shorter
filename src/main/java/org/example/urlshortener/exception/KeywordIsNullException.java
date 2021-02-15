package org.example.urlshortener.exception;

public class KeywordIsNullException extends RuntimeException {
    public KeywordIsNullException(String message) {
        super(message);
    }
}
