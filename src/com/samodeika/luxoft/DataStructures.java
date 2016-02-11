package com.samodeika.luxoft;

import java.util.HashMap;
import java.util.Map;

public class DataStructures {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alex");
        map.put(2, "Yavor");

        //System.out.println(map);

        String var = "B";
        switch (var) {
            case "a":
                System.out.println("a");
            default:
                System.out.println("default");
            case "A":
                System.out.println("A");
            case "B":
                System.out.println("B");
        }
    }



}
