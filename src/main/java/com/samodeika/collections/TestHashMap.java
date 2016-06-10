package com.samodeika.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander Nikolov on 10.6.2016 ?..
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<>();

        Person p1 = new Person("Alex", 28, "M");
        Person p2 = new Person("Georgi", 36, "M");
        Person p3 = new Person("Oksana", 22, "F");

        map.put(p1, 1);
        map.put(p2, 2);
        map.put(p3, 3);

        map.put(null, 4);

        for (Person key: map.keySet()) {
            //System.out.println("Key name" + key.getName() + ";Value = " + map.get(key));
            System.out.println("Value = " + map.get(key));
        }

    }

}
