package com.samodeika.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PersonDAOImpl implements PersonDAO, HibernateSession {

    private Session session;
    private SessionFactory factory;

    public PersonDAOImpl() {
        factory = new Configuration().configure().addAnnotatedClass(Person.class).buildSessionFactory();
        session = null;
    }

    @Override
    public Session getSession() {
        session = factory.openSession();
        return session;
    }

    /* Method to CREATE an Person in the database */
    public Integer addPerson(Session session, String name, int age) {
        Person person = new Person(name, age);
        session.save(person);
        return person.getId();
    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void remove(Person person) {

    }

    @Override
    public boolean insert(Person person) {
        return false;
    }

    @Override
    public void getPersonsAsXLS() {

    }
}
