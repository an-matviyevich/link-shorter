package org.example.urlshortener.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncrementalUrlShortenerTest {

    @Test
    void testShorten_singleProvider_UrlIncrement2() {
        ProviderRegistry registry = new ProviderRegistry();
        registry.register("short.com");
        IncrementalUrlShortener incrementalUrlShortener = new IncrementalUrlShortener(registry);

        String url1 = "http://looooong.com/somepath";
        String url2 = "http://looooong.com/somepath2";

        final String shortenedUrl1 = incrementalUrlShortener.shorten(url1);
        final String shortenedUrl2 = incrementalUrlShortener.shorten(url2);

        final String expectedUrl1 = "short.com/1";
        final String expectedUrl2 = "short.com/2";

        assertEquals(expectedUrl1, shortenedUrl1);
        assertEquals(expectedUrl2, shortenedUrl2);
    }
}