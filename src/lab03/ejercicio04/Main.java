package lab03.ejercicio04;

import lab03.ejercicio04.sort.*;

public class Main {
    public static void main(String[] args) {
        SortTimer timer = new SortTimer();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        int[] datos = randomDataGenerator.generateIntArray();
        SortAlgorithm sortAlgorithm;
        // sortAlgorithm = new InsertionSort();
        // sortAlgorithm = new SelectionSort();
        sortAlgorithm = new MergeSort();
        // sortAlgorithm = new QuickSort();

        long durationMillis = timer.measure(sortAlgorithm, datos);
        System.out.println("Tiempo: " + durationMillis + " ms");
    }
}
