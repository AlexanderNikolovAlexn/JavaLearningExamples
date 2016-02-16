package com.samodeika.luxoft;

public class TestEnum {

    public static void main(String[] args) {
        System.out.println(Day.valueOf("Monday"));
        System.out.println(Day.Monday);

        System.out.println("Days: ");
        for (Day day: Day.values()) {
            System.out.println("ordinal: " + day.ordinal() + " name: " + day + " dbMapping: " + day.getDbMapping());
        }
    }

}
