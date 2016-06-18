package com.samodeika.singleton;

public class TestSingletonMain {

    public static void main(String[] args) throws InterruptedException {
        ShowTime showTime1 = ShowTime.getInstance();
        System.out.println(showTime1.getTime() + "     obj: " + showTime1);
        Thread.sleep(2000);
        System.out.println(showTime1.getTime() + "     obj: " + showTime1);
        Thread.sleep(2000);
        ShowTime showTime2 = ShowTime.getInstance();
        System.out.println(showTime2.getTime() + "     obj: " + showTime2);
    }

}
