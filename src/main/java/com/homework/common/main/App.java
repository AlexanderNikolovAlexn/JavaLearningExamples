package com.homework.common.main;

import com.homework.common.Dog;
import com.homework.common.jdbc.JdbcBusinessProcessor;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        //saveDogJdbc();
        JdbcBusinessProcessor jdbcBusinessProcessor = new JdbcBusinessProcessor();
        jdbcBusinessProcessor.getDataFromDatabaseToExcell();


    }

    private static void saveDogJdbc() {
        Dog dog = new Dog("Jack", 3, 5.5f, true, 15);
        JdbcBusinessProcessor jdbc = new JdbcBusinessProcessor();
        jdbc.save(dog);
        List<Dog> dogs = jdbc.getAllDogs();
        System.out.println(Arrays.toString(dogs.toArray()));

        jdbc.closeConnection();
    }

}
