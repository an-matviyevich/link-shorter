package org.example.urlshortener.service;

import org.example.urlshortener.util.SequenceGeneratorUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SequenceGeneratorUtilTest {

    @Test
    void testGenerateRandomString_20RandomStringsSize4_AllAlphanumeric() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(SequenceGeneratorUtil.generateRandomString(4));
        }

        strings.forEach(s -> assertEquals(4, s.length()));
        strings.forEach(s -> assertTrue(s.chars().allMatch(Character::isLetterOrDigit)));
    }
}
