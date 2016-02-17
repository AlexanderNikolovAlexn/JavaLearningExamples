package com.samodeika.luxoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class TestException {

    public static void main(String[] args) {
//        try {
//            openFile("D:\\My docs\\Aleksandar Nikolov - CV.pdf");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        int a = checkFinally();
        System.out.println("a = " + a);
    }

    public static void openFile(String path) throws FileNotFoundException{
        File file = new File(path);
        if(!file.exists()) {
            throw new FileNotFoundException("File doesn`t exist");
        }

        System.out.println("File is here!");
    }

    public static int checkFinally() {
        int a = -1;
        try {
            throw new ParseException("Can`t parse a " + a, a);
        }
        catch (ParseException e) {
            System.out.println(e.toString());
            return 1;
        }
        finally {
            System.out.println("Finally!");
            return 2;
        }
    }

}
