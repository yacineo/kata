package com.kata.backend.utils;

public class NumberUtils {

    public static boolean isDivisibleBy(int number, int divisor) {

        return number % divisor == 0;
    }

    public static boolean containsDigit(int number, char digit) {

        return String.valueOf(number).indexOf(digit) >= 0;
    }
}
