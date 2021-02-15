package org.example.urlshortener.exception;

public class KeywordIllegalCharacterException extends RuntimeException {
    public KeywordIllegalCharacterException(String message) {
        super(message);
    }
}
