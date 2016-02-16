package com.samodeika.algorithms;

import java.util.Random;

public final class TestData {

    private static final int SMALL = 10;
    private static final int AVG = 1000;
    private static final int BIG = 10000;

    public static int[] getSmallArr() {
        return getArr(SMALL);
    }

    public static int[] getAvgArr() {
        return getArr(AVG);
    }

    public static int[] getBigArr() {
        return getArr(BIG);
    }

    private static int[] getArr(int amount) {
        int[] arr = new int[amount];
        Random ran = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(amount);
        }

        return arr;
    }

}
