package org.example.urlshortener.service;

public class KeywordValidationService {

    public boolean keywordIsNotNull(String keyword) {
        return keyword != null;
    }

    public boolean keywordIsNotEmpty(String keyword) {
        return !keyword.trim().isEmpty();
    }

    public boolean keywordNotExceedLengthOfTwenty(String keyword) {
        return keyword.length() <= 20;
    }

    public boolean keywordDoesntContainSlash(String keyword) {
        return !keyword.contains("/");
    }
}
