package com.homework.common;

public class Dog {

    private String name;
    private int age;
    private float weight;
    private boolean male;
    private int height;

    public Dog() {
    }

    public Dog(String name, int age, float weight, boolean male, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.male = male;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", male=" + male +
                ", height=" + height +
                '}';
    }
}
