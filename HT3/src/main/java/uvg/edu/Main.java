package uvg.edu;

import uvg.edu.controller.IComparator;
import uvg.edu.controller.Sort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Main class to demonstrate various sorting algorithms.
 * Authors:
 *      Javier Alvarado - 24546
 *      Juan Montenegro - 24750
 */
public class Main {
    /**
     * The main method to execute the sorting algorithms.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[3000];
        Random random = new Random();

        // Generate random numbers between 0 and 9999
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        // Save the numbers to a CSV file
        try (FileWriter writer = new FileWriter("numbers.csv")) {
            for (int number : numbers) {
                writer.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert int array to Integer array for sorting
        Integer[] numbersForSort = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersForSort[i] = numbers[i];
        }

        // Create a comparator for Integer
        IComparator<Integer> comparator = new IComparator<>() {
            @Override
            public int Compare(Integer _object1, Integer _object2) {
                return _object1.compareTo(_object2);
            }
        };

        // Create a Sort object with the comparator
        Sort<Integer> sort = new Sort<>(comparator);

        // Perform Insertion Sort
        sort.insertionSort(numbersForSort.clone());
        System.out.println("Insertion Sort completed.");

        // Perform Merge Sort
        sort.mergeSort(numbersForSort.clone());
        System.out.println("Merge Sort completed.");

        // Perform Quick Sort
        sort.quickSort(numbersForSort.clone());
        System.out.println("Quick Sort completed.");

        // Perform Radix Sort
        sort.radixSort(numbers.clone());
        System.out.println("Radix Sort completed.");

        // Perform Bucket Sort
        float[] floatNumbers = new float[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            floatNumbers[i] = numbers[i] / 10000.0f;
        }
        sort.bucketSort(floatNumbers);
        System.out.println("Bucket Sort completed.");

        // Perform Shell Sort
        sort.shellSort(numbersForSort.clone());
        System.out.println("Shell Sort completed.");
    }
}