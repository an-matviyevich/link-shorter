package org.example.urlshortener.util;

import java.util.Random;

public class SequenceGeneratorUtil {

    public static String generateRandomString(int length) {
        String alphanumeric = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final int index = random.nextInt(alphanumeric.length());
            str.append(alphanumeric.toCharArray()[index]);
        }
        return str.toString();
    }
}
