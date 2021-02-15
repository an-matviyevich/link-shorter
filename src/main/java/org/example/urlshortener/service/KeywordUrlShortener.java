package org.example.urlshortener.service;

import org.example.urlshortener.exception.KeywordIllegalCharacterException;
import org.example.urlshortener.exception.KeywordIsEmptyException;
import org.example.urlshortener.exception.KeywordIsNullException;
import org.example.urlshortener.exception.KeywordIsTooLongException;

public class KeywordUrlShortener {
    public static final String SHORT_URL = "https://short.com/";

    private final KeywordValidationService keywordValidationService;

    public KeywordUrlShortener() {
        this.keywordValidationService = new KeywordValidationService();
    }

    public String shorten(String sourceUrl, String keyword) {
        validateKeyword(keyword);
        return SHORT_URL + keyword;
    }

    private void validateKeyword(String keyword) {
        if (!keywordValidationService.keywordIsNotNull(keyword)) {
            throw new KeywordIsNullException("keyword is null");
        }
        if (!keywordValidationService.keywordIsNotEmpty(keyword)) {
            throw new KeywordIsEmptyException("keyword is empty");
        }
        if (!keywordValidationService.keywordNotExceedLengthOfTwenty(keyword)) {
            throw new KeywordIsTooLongException("keyword is too long (exceeds 20 characters)");
        }
        if (!keywordValidationService.keywordDoesntContainSlash(keyword)) {
            throw new KeywordIllegalCharacterException("keyword contains illegal characters such as: `/`");
        }

    }
}
