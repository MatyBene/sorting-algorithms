package org.example.algorithms;

import org.example.SortResult;
import org.example.Sorter;

/**
 * Implementation of the Quick Sort algorothm (Hoare partition scheme)
 * It uses two pointers (left and right) that moce towards each other
 * swapping elements that are on the wrong side of the pivot.
 */
public class QuickSort <T extends Comparable<T>> implements Sorter<T> {

    @Override
    public SortResult sort(T[] array) {
        // Counters for performance metrics
        long[] counters = new long[2]; // [0] = comparisons, [1] = arrayAccesses

        quickSort(array, 0, array.length - 1, counters);

        return new SortResult(counters[0], counters[1]);
    }

    /*
        Recursive method that applies quicksort on a subarray.
        It takes the leftmost and rightmost indices as bounds.
     */
    private void quickSort(T[] array, int left, int right, long[] counters) {
        /* Base case:
            If the subarray has 1 or 0 elements, it is already sorted.
         */
        if (left >= right) {
            return;
        }

        /*
            Partition the array and get the pivot index.
            The pivot index is the position where the pivot element ends up,
            and it divides the array into two subarrays.
         */
        int pivotIdx = partition(array, left, right, counters);

        /*
            Recursively sort both halves.
            The pivot is already in its final position.
         */
        quickSort(array, left, pivotIdx, counters);
        quickSort(array, pivotIdx + 1, right, counters);
    }

    /* Hoare partition shceme:
        Uses two pointers that start at both ends of the subarray
        and move towards each other until they cross.
        Elements are swapped when each pointer finds an element
        that belongs on the opposite side of the pivot.
     */
    private int partition(T[] array, int left, int right, long[] counters) {
        /*
            Choose the middle element as the pivot.
            This avoids worst-case behavior on already sorted arrays
            better than choosing the first or last elements.
         */
        T pivot = array[left + (right - left) / 2];

        // Count the read of the pivot
        counters[1]++;

        int i = left;
        int j = right;

        /* Main loop:
            Moves the left pointer to the right while array[i] < pivot
            and the right pointer to the left while array[j] > pivot.
            When both pointers have found elements on the wrong side,
            they swap them.
         */
        while (true) {
            /*
                Move the left pointer to the right
                until we find an element >= pivot.
             */
            while (true) {
                // Count the comparison
                counters[0]++;

                // Read array[i] for the comparison
                counters[1]++;

                if (array[i].compareTo(pivot) < 0) {
                    i++;
                } else {
                    break;
                }
            }

            /*
                Move the right pointer to the left
                until we find an element <= pivot.
             */
            while (true) {
                // Count the comparison
                counters[0]++;

                // Read array[j] for the comparison
                counters[1]++;

                if (array[j].compareTo(pivot) > 0) {
                    j--;
                } else {
                    break;
                }
            }

            /*
                If the pointers have crossed, the partition is complete.
                'j' becomes the dividing index between the two subarrays.
             */
            if (i >= j) {
                return j;
            }

            /* Swap array[i] and array[j]:
                Both are on the wrong side, so we exchange them.
             */
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            // A swap requires 2 reads and 2 writes
            counters[1] += 4;

            // Move both pointers one step closer to continue
            i++;
            j--;
        }
    }
}
