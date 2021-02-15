package org.example.urlshortener.exception;

public class KeywordIsEmptyException extends RuntimeException {
    public KeywordIsEmptyException(String message) {
        super(message);
    }
}
