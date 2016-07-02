package com.samodeika.collections;

import java.util.HashMap;
import java.util.Map;

public class TestEmptyHashMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        if("Y".equalsIgnoreCase(map.get("someValue"))) {
            System.out.println("Has Value");
        }
        else {
            System.out.println("No Value");
        }
    }
}
