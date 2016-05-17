package com.samodeika.temp;

public class ReferenceExamples {

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("hello");
//        changeValue(sb);
//        System.out.println(sb.toString());
        Person p = new Person("Pesho", 22);
        changeValue(p);
        System.out.println(p);
    }

    private static void changeValue(StringBuilder sb) {
        StringBuilder s = sb;
        s.append("world");
    }

    private static void changeValue(Person person) {
        Person p = person;
        p.setAge(33);
    }
}
