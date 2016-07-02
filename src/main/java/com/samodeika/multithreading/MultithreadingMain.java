package com.samodeika.multithreading;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadingMain {

    public static int cnt = 0;

    public static void main(String[] args) {
        Integer cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cpus: " + cpuCount);

        ExecutorService executorService = Executors.newFixedThreadPool(cpuCount);

        MySyncClass mySyncClass = new MySyncClass(10000);

        for (int i = 0; i < cpuCount; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    mySyncClass.incrementWithThousand();
                    // incrementWithThousand();
                }
            });
        }

        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is " + mySyncClass.getCnt());
    }

    static void incrementWithThousand() {
        for (int i = 0; i < 100000; i++) {
            increment();
        }
    }

    static void increment() {
        synchronized (MultithreadingMain.class) {
            cnt++;
        }
    }

}
