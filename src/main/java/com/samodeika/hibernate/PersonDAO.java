package com.samodeika.hibernate;

import org.hibernate.Session;

public class PersonDAO {

    /* Method to CREATE an Person in the database */
    public Integer addPerson(Session session, String name, int age) {
        Integer PersonID = null;
        Person Person = new Person(name, age);
        PersonID = (Integer) session.save(Person);
        return PersonID;
    }

}
