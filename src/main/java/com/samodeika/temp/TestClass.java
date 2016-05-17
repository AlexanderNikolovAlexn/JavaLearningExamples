package com.samodeika.temp;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(11);
        list.add(2);
        list.add(30);
        list.add(13);
        list.removeIf(e -> e%2 !=0);

        System.out.println(list);

    }
}
