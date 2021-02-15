package org.example.urlshortener.service;

import org.example.urlshortener.util.SequenceGeneratorUtil;

public class GeneratedUrlShortener {

    public String shorten(String sourceUrl) {
        final String keyword = SequenceGeneratorUtil.generateRandomString(4);
        return KeywordUrlShortener.SHORT_URL + keyword;
    }
}
