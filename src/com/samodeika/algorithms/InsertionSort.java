package com.samodeika.algorithms;

import java.util.Arrays;

public final class InsertionSort {


    public static void main(String[] args) {
        int[] arr = TestData.getSmallArr();
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while((j - 1 >= 0) && (arr[j - 1] > arr[j])) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    };

}
