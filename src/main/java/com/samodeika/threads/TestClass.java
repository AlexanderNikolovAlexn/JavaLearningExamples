package com.samodeika.threads;

public class TestClass {

    public static void main(String[] args) {
        MyRunnableImpl R1 = new MyRunnableImpl( "Runnable-1");
        R1.start();

        MyRunnableImpl R2 = new MyRunnableImpl( "Runnable-2");
        R2.start();

        MyThread T1 = new MyThread( "Thread-1");
        T1.start();

        MyThread T2 = new MyThread( "Thread-2");
        T2.start();
    }

}
