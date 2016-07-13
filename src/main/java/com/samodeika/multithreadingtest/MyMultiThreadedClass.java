package com.samodeika.multithreadingtest;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.*;

public class MyMultiThreadedClass {

    private Queue<Integer> queue;
    private final int size = 5000000;
    private final int cpuCore = 4;
    private ExecutorService executor;

    public MyMultiThreadedClass() {
        queue = new ArrayDeque<>();
        executor = Executors.newFixedThreadPool(cpuCore);
        try {
            fillInQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Queue size is " + queue.size());
    }

    public void start(boolean multiThreaded){
        if(multiThreaded) {
            emptyQueue();
        }
        else {
            singleThreadEmptyQueue();
        }
    }

    public void stop() {
        executor.shutdown();
        System.out.println("Queue size is " + queue.size());
    }

    private void singleThreadEmptyQueue() {
        while (!queue.isEmpty()) {
            pull();
        }
    }

    private void emptyQueue() {
        while (!queue.isEmpty()) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    int i = pull();
                    // do some math
                    i = i * i;
                }
            });
        }
    }

    private int pull() {
        int result;
        synchronized (this) {
            result = queue.poll();
        }
        return result;
    }

    private void fillInQueue() throws InterruptedException {
        for (int i = 0; i < size; i++) {
            queue.offer(i);
        }
    }
}
