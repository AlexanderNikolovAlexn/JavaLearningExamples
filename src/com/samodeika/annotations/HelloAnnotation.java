package com.samodeika.annotations;

public class HelloAnnotation {

    public static void main(String[] args) {
        Printer print = new Printer("My text should be printed");

        print.print("Blabla");
        print.print();
    }

}
