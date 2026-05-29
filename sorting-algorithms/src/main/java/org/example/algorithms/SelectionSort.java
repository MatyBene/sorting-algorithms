package org.example.algorithms;

import org.example.SortResult;
import org.example.Sorter;

/**
 * Implementation of the Selection Sort algorithm
 * It divides the array into two parts: sorted and unsorted.
 * In each iteration, it finds the smallest element in the unsorted part
 * and swaps it with the first element of that part.
 */
public class SelectionSort <T extends Comparable<T>> implements Sorter<T> {

    @Override
    public SortResult sort(T[] array) {
        int n = array.length;

        // Counters for performance metrics
        long comparisons = 0;
        long arrayAccesses = 0;

        /* Outer loop:
            Controls the boundary between the sorted and unsorted parts.
            It goes from the first element (0) to the second to last (n - 1)
         */
        for (int i = 0; i < n - 1; i++){
            // We temporarily asume the first element of the unsorted part is the smallest
            int minIdx = i;

            /* Inner loop:
                Iterates through the unsorted part to check if there is any smaller element
             */
            for (int j = i + 1; j < n; j++){
                // Count the comparison
                comparisons++;

                // Read array[j] y array[minIdx]
                arrayAccesses += 2;

                // Compare the current element with the smallest found so far
                if (array[j].compareTo(array[minIdx]) < 0){
                    // If we find a smaller element, we save its position
                    minIdx = j;
                }
            }

            /* Swap:
                If 'mindIdx' changed, it means we found a smaller number and must swap them
             */
            if (minIdx != i) {
                T temp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = temp;

                // A swap requires 2 reads and 2 writes
                arrayAccesses += 4;
            }
        }

        // Return only the internal counters
        return new SortResult(comparisons, arrayAccesses);
    }
}
