package com.samodeika.algorithms;

import java.util.Arrays;

public class Sorts {

    public static void main(String[] args) {

        int[] arr = TestData.getSmallArr();
        System.out.println("Original array!");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("Bubble sort!");
        System.out.println(Arrays.toString(arr));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        insertionSort(arr2);
        System.out.println("Bubble sort!");
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = Arrays.copyOf(arr, arr.length);
        insertionSort(arr3);
        System.out.println("Selection sort!");
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = Arrays.copyOf(arr, arr.length);
        mergeSort(arr4);
        System.out.println("Merge sort!");
        System.out.println(Arrays.toString(arr4));
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean exit = true;
        while (exit) {
            exit = false;
            for (int i = 0; i < length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    exit = true;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while ((j - 1 >= 0) && (arr[j - 1] > arr[j])) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    pos = j;
                }
            }
            swap(arr, i, pos);
        }

    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int[] first = new int[arr.length / 2];
        int[] second = new int[arr.length - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, arr);
    }

    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    ;
}
