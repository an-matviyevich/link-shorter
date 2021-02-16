package org.example.urlshortener.service;

/**
 * Class for validating SEO keywords
 *
 * @author Andrei Matviyevich
 */
public class KeywordValidationService {

    public boolean keywordIsNull(String keyword) {
        return keyword != null;
    }

    public boolean keywordIsEmpty(String keyword) {
        return !keyword.trim().isEmpty();
    }

    public boolean keywordExceedLengthOfTwenty(String keyword) {
        return keyword.length() <= 20;
    }

    public boolean keywordContainSlash(String keyword) {
        return !keyword.contains("/");
    }
}
