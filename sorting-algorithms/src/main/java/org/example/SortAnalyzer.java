package org.example;

/**
 * Class responsible for executing algorithms, measuring time, and displaying results
 */
public class SortAnalyzer {

    public <T extends Comparable<T>> void analyzeAndRun(String algorithmName, Sorter<T> sorter, T[] array) {
        // Start the stopwatch right before calling the algorithm
        long startTime = System.nanoTime();

        // Execute the algorithm and capture its counters
        SortResult result = sorter.sort(array);

        // Stop the stopwatch
        long endTime = System.nanoTime();

        // Calculate duration in milliseconds
        double durationInMillis = (endTime - startTime) / 1_000_000.0;

        printMetrics(algorithmName, result.comparisons, result.arrayAccesses, durationInMillis);
    }

    private void printMetrics(String algorithmName, long comparisons, long arrayAccesses, double delay) {
        System.out.println("=== " + algorithmName + " Metrics ===");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Array Accesses: " + arrayAccesses);
        System.out.println("Delay (Execution Time): " + delay + " ms");
        System.out.println("=====================================\n");
    }
}
