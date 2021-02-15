package org.example.urlshortener.service;

import org.example.urlshortener.domain.Provider;

import java.util.Map;
import java.util.TreeMap;

public class IncrementalUrlShortener {
    private Map<String, Integer> dictionary;
    private ProviderRegistry providerRegistry;

    public IncrementalUrlShortener() {
        this.dictionary = new TreeMap<>();
        initProviderRegistry();
    }

    public IncrementalUrlShortener(ProviderRegistry providerRegistry) {
        this.dictionary = new TreeMap<>();
        this.providerRegistry = providerRegistry;
    }

    public String shorten(String sourceUrl) {
        Provider provider = providerRegistry.getRandomProvider();
        int increment = getIncrement(provider.getUri());

        return provider.getUri() + "/" + increment;
    }

    private int getIncrement(String sourceUrl) {
        int increment;
        if (!dictionary.containsKey(sourceUrl)) {
            dictionary.put(sourceUrl, 1);
            increment = 1;
        } else {
            increment = dictionary.get(sourceUrl) + 1;
            dictionary.put(sourceUrl, increment);
        }
        return increment;
    }

    private void initProviderRegistry() {
        this.providerRegistry = new ProviderRegistry();
        for (int i = 1; i < 11; i++) {
            providerRegistry.register("short" + i + ".com");
        }
    }
}
