package com.samodeika.clones;

public class Employee {

    private int id;
    private Name name;

    public Employee(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.name = new Name(firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
