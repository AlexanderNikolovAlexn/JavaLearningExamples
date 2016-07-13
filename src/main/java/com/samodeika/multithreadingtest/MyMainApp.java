package com.samodeika.multithreadingtest;

import java.text.DecimalFormat;

public class MyMainApp {

    public static void main(String[] args) {
        MyMultiThreadedClass myMultiThreadedClass = new MyMultiThreadedClass();

        long startTime = System.currentTimeMillis();

        myMultiThreadedClass.start(true);
        myMultiThreadedClass.stop();

        long stopTime = System.currentTimeMillis();

        System.out.println("Total time: " + getTotalTime(startTime, stopTime) + " s");
    }

    private static String getTotalTime(double startTime, double endTime) {
        DecimalFormat df = new DecimalFormat("#.##");
        double f = ((endTime - startTime) / 1000);
        return df.format(f);
    }

}
