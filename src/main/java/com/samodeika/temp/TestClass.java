package com.samodeika.temp;

public class TestClass {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        foo(sb);
        System.out.println(sb.toString());

    }

    static void foo(StringBuilder x) {
        x = new StringBuilder();
        x.append("world");
    }
}
