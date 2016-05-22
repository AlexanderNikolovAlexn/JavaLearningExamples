package com.samodeika.enums;

public class TestMain {

    public static void main(String[] args) {

        for (DayOfWeek day: DayOfWeek.values()) {
            System.out.println(day + ": " + day.getValue());
        }

    }

}
