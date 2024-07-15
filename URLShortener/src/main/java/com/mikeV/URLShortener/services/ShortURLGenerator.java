package com.mikeV.URLShortener.services;

import com.mikeV.URLShortener.model.UserInput;

import java.util.ArrayList;
import java.util.List;

public class ShortURLGenerator {
    private static final int base = 62;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void generateShortURL(UserInput input) {
        input.setShortURL(mapping(bijection(input)));
    }

    public static List<Integer> bijection(UserInput input) {
        List<Integer> digits = new ArrayList<>();
        Long id = input.getId();
        while(id > 0) {
            Integer remainder = id.intValue() % base;
            digits.add(remainder);
            id /= base;
        }
        return digits.reversed();
    }

    private static String mapping(List<Integer> digits) {
        StringBuilder shortURL = new StringBuilder();
        shortURL.append("http://shrtRL/");
        for (Integer digit : digits) {
            shortURL.append(alphabet.charAt(digit));
        }
        return shortURL.toString();
    }
}
