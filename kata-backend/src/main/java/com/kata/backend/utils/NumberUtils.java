package com.kata.backend.utils;

/**
 * Utility class containing number-related utility methods.
 */
public class NumberUtils {


    /**
     * Checks if a number is divisible by a specified divisor.
     *
     * @param number  the number to be checked
     * @param divisor the divisor to check against
     * @return true if the number is divisible by the divisor, false otherwise
     * @throws IllegalArgumentException if the divisor is zero
     */
    public static boolean isDivisibleBy(int number, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        return number % divisor == 0;
    }

}
