package com.samodeika.algorithms;

import java.util.Arrays;

public class Sorts {

    public static void main(String[] args) {

        int[] arr = TestData.getSmallArr();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Original array!");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("Bubble sort!");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);
        System.out.println("Bubble sort!");
        System.out.println(Arrays.toString(arr));

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

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    ;
}
