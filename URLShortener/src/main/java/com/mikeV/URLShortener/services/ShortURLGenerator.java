package com.mikeV.URLShortener.services;

import com.mikeV.URLShortener.model.UserInput;
import com.mikeV.URLShortener.repositories.Constants;

import java.util.ArrayList;
import java.util.List;

public class ShortURLGenerator implements Constants {
    public static void generateShortURL(UserInput input) {
        input.setShortURL(mapping(bijection(input)));
    }

    public static List<Integer> bijection(UserInput input) {
        List<Integer> digits = new ArrayList<>();
        Long id = input.getId();
        while(id > 0) {
            Integer remainder = id.intValue() % BASE;
            digits.add(remainder);
            id /= BASE;
        }
        return digits.reversed();
    }

    private static String mapping(List<Integer> digits) {
        StringBuilder shortURL = new StringBuilder();
        shortURL.append(DOMAIN_NAME);
        for (Integer digit : digits) {
            shortURL.append(ALPHABET.charAt(digit));
        }
        return shortURL.toString();
    }
}
