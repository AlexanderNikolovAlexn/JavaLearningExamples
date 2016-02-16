package com.samodeika.depinjection.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ProjectModule());
        Person person = injector.getInstance(Person.class);
        person.greetFriend();
    }
}
