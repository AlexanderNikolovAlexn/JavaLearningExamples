package com.samodeika.immutable;

public class ImmutableClass {

    private String name;
    private int age;

    public ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return new String(name);
    }

    public final int getAge() {
        return age;
    }
}
