package com.kata.backend.service.impl;

import com.kata.backend.exception.CustomIllegalArgumentException;
import com.kata.backend.service.IKataService;
import org.springframework.stereotype.Service;

import static com.kata.backend.utils.NumberUtils.isDivisibleBy;


@Service
public class KataService implements IKataService {

    public static final String FOO = "FOO";
    public static final String BAR = "BAR";
    public static final String QUIX = "QUIX";

    /**
     * Transform a number according to the following rules:
     * - If the number is divisible by 3, add 'FOO'
     * - If the number is divisible by 5, add 'BAR'
     * - If the number contains a 3, add 'FOO'
     * - If the number contains a 5, add 'BAR'
     * - If the number contains a 7, add 'QUIX'
     * - If none of the above, return the number as a string
     *
     * @param number the number to transform
     * @return the transformed string
     */
    public String transformNumber(int number) throws CustomIllegalArgumentException{
        if (number < 0 || number > 100) {
            throw new CustomIllegalArgumentException("Number must be between 0 and 100");
        }

        StringBuilder result = new StringBuilder();

        // Check for divisibility
        if (isDivisibleBy(number, 3)) {
            result.append(FOO);
        }
        if (isDivisibleBy(number, 5)) {
            result.append(BAR);
        }


        // Add 'FOO' for each occurrence of 3 and 'BAR' for each occurrence of 5
        String numberStr = String.valueOf(number);
        for (char digit : numberStr.toCharArray()) {

            if (digit == '3') {
                result.append(FOO);
            }
            if (digit == '5') {
                result.append(BAR);
            }
            if (digit == '7') {
                result.append(QUIX);
            }
        }
        // If nothing has been added, return the number
        return !result.isEmpty() ? result.toString() : String.valueOf(number);
    }

}