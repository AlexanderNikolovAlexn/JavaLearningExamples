package com.samodeika.temp;

import java.util.ArrayList;

public class TestClass {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a);
        method2(a);
        System.out.println(a);
    }

    public static void method2(ArrayList list) {
        list = new ArrayList();
        list.add(33);
        System.out.println("Inside: " + list);
    }
}
