package org.example.algorithms;

import org.example.SortResult;
import org.example.Sorter;

/**
 * Implementation of the Insertion Sort algorithm
 * It builds the sorted array one element at a time.
 * For each element, it finds its correct position within the sorted part
 * by shifting larger elements one position to the right.
 */
public class InsertionSort <T extends Comparable<T>> implements Sorter<T> {

    @Override
    public SortResult sort(T[] array) {
        int n = array.length;

        // Counters for performance metrics
        long comparisons = 0;
        long arrayAccesses = 0;

        /* Outer loop:
            It starts from the second element (index 1) because
            the first element (index 0) is trivially sorted by itself.
            Each iteration picks one element from the unsorted part
            and inserts it into the correct position in the sorted part.
         */
        for (int i = 1; i < n; i++) {

            /*
                We save the current element (the one we are going to insert)
                before shifting elements to the right.
             */
            T key = array[i];

            // Count the read of array[i]
            arrayAccesses++;

            // Index to traverser the sorted part backwards
            int j = i - 1;

            /* Inner loop:
                Shifts elements of the sorted part that are greater than 'key'
                one position to the right, making room for the insertion.
             */
            while (j >= 0) {
                // Count the comparison
                comparisons++;

                // Read array[j] for the comparison
                arrayAccesses++;

                if (array[j].compareTo(key) > 0) {
                    /*
                        Shift array[j] one position to the right.
                        This overwrites the element at j + 1,
                        which is either the original position of 'key'
                        or a previously shifted position.
                     */
                    array[j + 1] = array[j];

                    // Count the write
                    arrayAccesses++;

                    // Move one position to the left
                    j--;
                } else {
                    // The element is in its correct position relative to the sorted part
                    break;
                }
            }

            /* Insertion:
                Place 'key' in its correct position.
                The position is j + 1 beacuse:
                - If the loop never ran (j == i - 1), the element stays in place
                - If the loop shifted elements, j + 1 is the gap created
             */
            array[j + 1] = key;

            // Count the write of 'key'
            arrayAccesses++;
        }

        // Return only the internal counters
        return new SortResult(comparisons, arrayAccesses);
    }
}
