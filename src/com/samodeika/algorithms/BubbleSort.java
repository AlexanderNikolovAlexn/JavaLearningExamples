package com.samodeika.algorithms;

import java.util.Arrays;

public final class BubbleSort {

    public static void main(String[] args) {
        int[] arr = TestData.getSmallArr();
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
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

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    };

}
