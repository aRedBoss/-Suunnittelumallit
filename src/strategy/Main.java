package strategy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        SorterContext context = new SorterContext();

        context.setStrategy(new BubbleSort());
        testPerformance("Bubble Sort - Small", context, smallArray);
        testPerformance("Bubble Sort - Large", context, largeArray);

        context.setStrategy(new QuickSort());
        testPerformance("Quick Sort - Small", context, smallArray);
        testPerformance("Quick Sort - Large", context, largeArray);

        context.setStrategy(new MergeSort());
        testPerformance("Merge Sort - Small", context, smallArray);
        testPerformance("Merge Sort - Large", context, largeArray);
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    private static void testPerformance(String testName, SorterContext context, int[] originalArray) {
        int[] arrCopy = originalArray.clone();
        long start = System.nanoTime();
        context.executeStrategy(arrCopy);
        long end = System.nanoTime();
        long duration = (end - start) / 1_000_000; // ms
        System.out.println(testName + " took: " + duration + " ms");
    }
}

