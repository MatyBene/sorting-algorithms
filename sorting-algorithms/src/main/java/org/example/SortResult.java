package org.example;

/**
 * Immutable class to store the internal metrics of the algorithm
 */
public class SortResult {
    public final long comparisons;
    public final long arrayAccesses;

    public SortResult(long comparisons, long arrayAccesses){
        this.comparisons = comparisons;
        this.arrayAccesses = arrayAccesses;
    }
}
