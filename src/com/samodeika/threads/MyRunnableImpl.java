package com.samodeika.threads;

public class MyRunnableImpl implements Runnable {

    private Thread t;
    private String threadName;

    public MyRunnableImpl(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interupted");
        }
        System.out.println("Thread " + threadName + " exiting");
    }

    public void start ()
    {
        System.out.println("Starting " +  threadName);
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
