package com.samodeika.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloAnnotation {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Printer printer = new Printer("My text should be printed", 2);

        System.out.println("Annotation example");

        printer.print("Blabla");
        printer.print();

        System.out.println("Reflection!!!");

        PrintingDevice annotation = printer.getClass().getAnnotation(PrintingDevice.class);
        Method printMethod = printer.getClass().getMethod(annotation.defaultPrintMethod(), int.class);

        printMethod.invoke(printer, annotation.defaultNumberOfCopies());

    }

}
