package com.samodeika.anonymousblocks;

public class Animal {

    private String type;
    private int age;

    static {
        System.out.println("Static anonymous block call Animal");
    }

    {
        age = 10;
        System.out.println("Anonymous block call Animal");
    }

    public Animal(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
