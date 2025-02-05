package uvg.edu;

import uvg.edu.controller.IComparator;
import uvg.edu.controller.Sort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[3000];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000); // Genera números aleatorios entre 0 y 9999
        }

        Integer[] numbersForSort = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersForSort[i] = numbers[i];
        }

        IComparator<Integer> comparator = new IComparator<>() {
            @Override
            public int Compare(Integer _object1, Integer _object2) {
                return _object1.compareTo(_object2);
            }
        };

        Sort<Integer> sort = new Sort<>(comparator);

        // Insertion Sort
        sort.insertionSort(numbersForSort.clone());
        System.out.println("Insertion Sort completed.");

        // Merge Sort
        sort.mergeSort(numbersForSort.clone());
        System.out.println("Merge Sort completed.");

        // Quick Sort
        sort.quickSort(numbersForSort.clone());
        System.out.println("Quick Sort completed.");

        // Radix Sort
        sort.radixSort(numbers);
        System.out.println("Radix Sort completed.");

        // Bucket Sort
        float[] floatNumbers = new float[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            floatNumbers[i] = numbers[i] / 10000.0f;
        }
        sort.bucketSort(floatNumbers);
        System.out.println("Bucket Sort completed.");

        // Shell Sort
        sort.shellSort(numbersForSort.clone());
        System.out.println("Shell Sort completed.");
    }
}