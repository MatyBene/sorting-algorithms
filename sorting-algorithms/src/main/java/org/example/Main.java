package org.example;

import org.example.algorithms.InsertionSort;
import org.example.algorithms.QuickSort;
import org.example.algorithms.SelectionSort;
import org.example.utils.IntegerArrayGenerator;

public class Main {
    public static void main(String[] args) {

        SortAnalyzer analyzer = new SortAnalyzer();
        Sorter<Integer> selectionSort = new SelectionSort<>();
        Sorter<Integer> insertionSort = new InsertionSort<>();
        Sorter<Integer> quickSort = new QuickSort<>();

        // We use our new generator to create 100 random elements.
        int size = 100;
        Integer[] randomData = IntegerArrayGenerator.generateRandom(size);

        analyzer.analyzeAndRun("Selection Sort", selectionSort, randomData);
        analyzer.analyzeAndRun("Insertion Sort", insertionSort, randomData);
        analyzer.analyzeAndRun("Quick sort (LR ptrs)", quickSort, randomData);
    }
}
