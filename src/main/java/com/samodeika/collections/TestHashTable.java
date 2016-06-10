package com.samodeika.collections;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Alexander Nikolov on 10.6.2016 ?..
 */
public class TestHashTable {

    public static void main(String[] args) {
        Map<Person, Integer> table = new Hashtable<>();

        Person p1 = new Person("Alex", 28, "M");
        Person p2 = new Person("Georgi", 36, "M");
        Person p3 = new Person("Oksana", 22, "F");

        table.put(p1, 1);
        table.put(p2, 2);
        table.put(p3, 3);
        table.put(p3, 33);

        // Can`t add nulls to HashTable
        // table.put(null, 4);

        for (Person key: table.keySet()) {
            //System.out.println("Key name" + key.getName() + ";Value = " + map.get(key));
            System.out.println("Value = " + table.get(key));
        }
    }

}
