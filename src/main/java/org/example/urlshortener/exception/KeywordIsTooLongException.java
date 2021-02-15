package org.example.urlshortener.exception;

public class KeywordIsTooLongException extends RuntimeException {
    public KeywordIsTooLongException(String message) {
        super(message);
    }
}
