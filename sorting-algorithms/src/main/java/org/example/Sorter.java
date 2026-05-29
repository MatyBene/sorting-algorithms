package org.example;

/**
 * Common interface for all sorting algorithms
 */
public interface Sorter <T extends Comparable<T>> {
    /**
     * Sorts the array and returns the operation metrics
     * @param array Array to sort
     * @return SortResult with comparisons and accesses
     */
    SortResult sort(T[] array);
}
