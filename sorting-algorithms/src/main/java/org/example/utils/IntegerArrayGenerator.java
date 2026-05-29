package org.example.utils;

import java.util.Random;

/**
 * Utility to automatically generate test arrays
 */
public class IntegerArrayGenerator {
    // Single Random instance for better efficiency
    private static final Random random = new Random();

    /**
     * Generates an Integer array with random values
     * @param
     */
    public static Integer[] generateRandom(int size) {
        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++){
            // Generate numbers between 0 and the array size
            array[i]  = random.nextInt(size * 10);
        }

        return array;
    }
}
