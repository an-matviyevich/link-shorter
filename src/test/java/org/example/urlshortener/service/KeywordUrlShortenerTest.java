package org.example.urlshortener.service;

import org.example.urlshortener.exception.KeywordIllegalCharacterException;
import org.example.urlshortener.exception.KeywordIsEmptyException;
import org.example.urlshortener.exception.KeywordIsNullException;
import org.example.urlshortener.exception.KeywordIsTooLongException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KeywordUrlShortenerTest {

    KeywordUrlShortener keywordUrlShortener = new KeywordUrlShortener();

    @Test
    void testShorten_ValidKeyword_ValidShortenedUrl() {
        String keyword = "tEst";
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        final String shortenedUrl = keywordUrlShortener.shorten(sourceUrl, keyword);
        final String expectedUrl = KeywordUrlShortener.SHORT_URL + keyword;

        assertEquals(expectedUrl, shortenedUrl);

    }

    @Test
    void testShorten_EmptyKeyword_KeywordIsEmptyException() {
        String keyword = "";
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        assertThrows(KeywordIsEmptyException.class, () -> keywordUrlShortener.shorten(sourceUrl, keyword));
    }

    @Test
    void testShorten_SpaceKeyword_KeywordIsEmptyException() {
        String keyword = " ";
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        assertThrows(KeywordIsEmptyException.class, () -> keywordUrlShortener.shorten(sourceUrl, keyword));
    }

    @Test
    void testShorten_NullKeyword_KeywordIsNullException() {
        String keyword = null;
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        assertThrows(KeywordIsNullException.class, () -> keywordUrlShortener.shorten(sourceUrl, keyword));
    }

    @Test
    void testShorten_LongKeyword_KeywordIsTooLongException() {
        String keyword = "qqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        assertThrows(KeywordIsTooLongException.class, () -> keywordUrlShortener.shorten(sourceUrl, keyword));
    }

    @Test
    void testShorten_KeywordWithSlash_KeywordIllegalCharacterException() {
        String keyword = "key/word";
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        assertThrows(KeywordIllegalCharacterException.class, () -> keywordUrlShortener.shorten(sourceUrl, keyword));
    }
}