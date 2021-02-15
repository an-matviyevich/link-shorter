package org.example.urlshortener.service;

import org.example.urlshortener.domain.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProviderRegistry {
    private List<Provider> registry;

    public ProviderRegistry() {
        this.registry = new ArrayList<>();
    }

    public void register(String uri) {
        Provider provider = new Provider(uri);
        registry.add(provider);
    }

    public Provider getRandomProvider() {
        Random random = new Random();
        return registry.get(random.nextInt(registry.size()));
    }
}
