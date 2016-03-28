package com.samodeika.jdbcsample;

import java.util.List;

public interface PersonDAO {

    public List<Person> getPersons();
    public Person getPerson(int id);
    public void update(Person person);
    public void remove(Person person);
    public boolean insert(Person person);
    public void getPersonsAsXLS();

}
