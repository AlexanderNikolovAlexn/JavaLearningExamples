package com.samodeika.hibernate;

import org.hibernate.Session;

public class PersonDAO {

    /* Method to CREATE an Person in the database */
    public Integer addPerson(Session session, String name, int age) {
        Person person = new Person(name, age);
        session.save(person);
        return person.getId();
    }

}
