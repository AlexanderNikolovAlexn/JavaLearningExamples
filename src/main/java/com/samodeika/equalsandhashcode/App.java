package com.samodeika.equalsandhashcode;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        Apple apple1 = new Apple("green", 2);
        Apple apple2 = new Apple("red", 2);

        System.out.println(apple1);
        System.out.println(apple2);

        //hashMap stores apple type and its quantity
        HashMap<Apple, Integer> apples = new HashMap<>();
        apples.put(apple1, 5);
        apples.put(apple2, 10);

        System.out.println("Hashcode comprison: " + (apple1.hashCode() == apple2.hashCode()));
        System.out.println("Equals comparison: " + apple1.equals(apple2));

        System.out.println("Get count of apples: " + apples.get(new Apple("green", 2)));

    }

}
