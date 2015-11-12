package com.samodeika.algorithms;

import java.util.Random;

public final class TestData {

    private static final int SMALL = 10;

    public static int[] getSmallArr() {
        int[] arr = new int[SMALL];
        Random ran = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(SMALL);
        }

        return arr;
    }

}
