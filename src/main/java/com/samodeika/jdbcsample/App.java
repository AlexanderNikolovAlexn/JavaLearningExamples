package com.samodeika.jdbcsample;

import java.util.List;

public class App {

    public static void main(String[] args) {
        PersonDAO dao = new PersonDAOImpl();
        List<Person> personList = dao.getPersons();
        for (Person person: personList) {
            System.out.println(person);
        }
    }
}
