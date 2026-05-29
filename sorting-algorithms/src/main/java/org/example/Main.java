package org.example;

import org.example.algorithms.SelectionSort;
import org.example.utils.IntegerArrayGenerator;

public class Main {
    static void main() {

        SortAnalyzer analyzer = new SortAnalyzer();
        Sorter<Integer> selectionSort = new SelectionSort<>();

        // We use our new generator to create 10,000 random elements.
        int size = 10000;
        Integer[] randomData = IntegerArrayGenerator.generateRandom(size);

        analyzer.analyzeAndRun("Selection Sort", selectionSort, randomData);
    }
}
