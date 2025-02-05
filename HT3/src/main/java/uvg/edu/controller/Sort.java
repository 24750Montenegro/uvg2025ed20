package uvg.edu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to perform various sorting algorithms.
 *
 * @param <T> the type of elements to be sorted
 * Authors:
 *     Javier Alvarado - 24546
 *     Juan Montenegro - 24750
 */
public class Sort<T> {
    public IComparator<T> comparator;

    /**
     * Constructor to initialize the Sort object with a comparator.
     *
     * @param comparator the comparator to be used for sorting
     */
    public Sort(IComparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Performs insertion sort on the given array.
     *
     * @param array the array to be sorted
     */
    public void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && comparator.Compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Performs merge sort on the given array.
     *
     * @param array the array to be sorted
     */
    public void mergeSort(T[] array) {
        if (array.length <= 1) return;
        int mid = array.length / 2;
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.Compare(left[i], right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    /**
     * Performs quick sort on the given array.
     *
     * @param array the array to be sorted
     */
    public void quickSort(T[] array) {
        int low = 0, high = array.length - 1;
        quickSortHelper(array, low, high);
    }

    /**
     * Helper method for quick sort.
     *
     * @param array the array to be sorted
     * @param low the starting index
     * @param high the ending index
     */
    private void quickSortHelper(T[] array, int low, int high) {
        if (low < high) {
            T pivot = array[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (comparator.Compare(array[j], pivot) <= 0) {
                    i++;
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            T temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
            int pi = i + 1;
            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }

    /**
     * Performs radix sort on the given array of integers.
     *
     * @param array the array to be sorted
     */
    public void radixSort(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            int n = array.length;
            int[] output = new int[n];
            int[] count = new int[10];

            for (int i = 0; i < n; i++) count[(array[i] / exp) % 10]++;
            for (int i = 1; i < 10; i++) count[i] += count[i - 1];
            for (int i = n - 1; i >= 0; i--) {
                output[count[(array[i] / exp) % 10] - 1] = array[i];
                count[(array[i] / exp) % 10]--;
            }
            System.arraycopy(output, 0, array, 0, n);
        }
    }

    /**
     * Performs bucket sort on the given array of floats.
     *
     * @param array the array to be sorted
     */
    public void bucketSort(float[] array) {
        int n = array.length;
        if (n <= 0) return;

        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();
        for (float v : array) {
            int bucketIndex = (int) (v * n);
            buckets[bucketIndex].add(v);
        }
        for (List<Float> bucket : buckets) Collections.sort(bucket);
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (Float value : bucket) {
                array[index++] = value;
            }
        }
    }

    /**
     * Performs shell sort on the given array.
     *
     * @param array the array to be sorted
     */
    public void shellSort(T[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && comparator.Compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}