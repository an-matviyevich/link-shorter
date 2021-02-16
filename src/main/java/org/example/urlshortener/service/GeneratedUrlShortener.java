package org.example.urlshortener.service;

import org.example.urlshortener.util.SequenceGeneratorUtil;

/**
 * Class for shortening URLs using random generated alphanumeric string
 *
 * @author Andrei Matviyevich
 */
public class GeneratedUrlShortener {

    /**
     * Shorten provided URL with random generated alphanumeric string
     *
     * @param sourceUrl - source URL
     * @return shortened string
     */
    public String shorten(String sourceUrl) {
        final String keyword = SequenceGeneratorUtil.generateRandomString(4);
        return KeywordUrlShortener.SHORT_URL + keyword;
    }
}
