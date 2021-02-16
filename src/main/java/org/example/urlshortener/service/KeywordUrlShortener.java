package org.example.urlshortener.service;

import org.example.urlshortener.exception.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class for shortening URLs with provided SEO keyword
 *
 * @author Andrei Matviyevich
 */
public class KeywordUrlShortener {
    public static final String SHORT_URL = "https://short.com/";
    public static final String APP_HOST = "short.com";

    private final KeywordValidationService keywordValidationService;

    public KeywordUrlShortener() {
        this.keywordValidationService = new KeywordValidationService();
    }

    /**
     * Method for shortening URLs
     *
     * @param sourceUrl - source URL that needs to be shortened
     * @param keyword   - SEO keyword
     * @return string that represents shortened source URL
     */
    public String shorten(String sourceUrl, String keyword) {
        validateKeyword(keyword);
        return buildShortenedURI(keyword);
    }

    private String buildShortenedURI(String keyword) {
        try {
            URI uri = new URI("https", APP_HOST, keyword);
            return uri.toString();
        } catch (URISyntaxException e) {
            System.err.println();
            throw new InvalidURIException("Exception occurred during URI building: incorrect syntax");
        }
    }

    private void validateKeyword(String keyword) {
        if (keywordValidationService.keywordIsNull(keyword)) {
            throw new KeywordIsNullException("keyword is null");
        }
        if (keywordValidationService.keywordIsEmpty(keyword)) {
            throw new KeywordIsEmptyException("keyword is empty");
        }
        if (keywordValidationService.keywordExceedLengthOfTwenty(keyword)) {
            throw new KeywordIsTooLongException("keyword is too long (exceeds 20 characters)");
        }
        if (keywordValidationService.keywordContainSlash(keyword)) {
            throw new KeywordIllegalCharacterException("keyword contains illegal characters such as: `/`");
        }

    }
}
