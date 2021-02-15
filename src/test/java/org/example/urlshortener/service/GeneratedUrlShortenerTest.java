package org.example.urlshortener.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneratedUrlShortenerTest {
    GeneratedUrlShortener generatedUrlShortener = new GeneratedUrlShortener();

    @Test
    void testShorten_ValidShortenedUrl() {
        String sourceUrl = "https://loooooooong.com/aaaaaaaaaa";

        final String shortenedUrl = generatedUrlShortener.shorten(sourceUrl);
        final String[] split = shortenedUrl.split(KeywordUrlShortener.SHORT_URL);
        String charSequence = split[split.length - 1];

        assertEquals(4, charSequence.length());
        assertTrue(charSequence.chars().allMatch(Character::isLetterOrDigit));
    }
}
