package com.samodeika.clones;

public class MainApp {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp = new Employee(1, "Alex", "Nikolov");

        Employee emp2 = (Employee) emp.clone();

        System.out.println(emp.getName().hashCode());
        System.out.println(emp2.getName().hashCode());
    }

}
