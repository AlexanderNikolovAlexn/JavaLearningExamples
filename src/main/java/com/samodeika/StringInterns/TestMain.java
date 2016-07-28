package com.samodeika.stringinterns;

public class TestMain {

    public static void main(String[] args) {
        String s1 = "alex";
        String s2 = "alex";
        String s3 = "alex".intern();

        if (s1 == s2) {
            System.out.println("s1 are equal to s2");
        }

        if (s1 == s3) {
            System.out.println("s1 are equal to s3");
        }

        //String s1Concat = "alex" + "nikolov";
        String s1Concat = "alex";
        s1Concat = s1Concat + "nikolov";
        String s2Concat = "alexnikolov";

        if (s1Concat == s2Concat) {
            System.out.println("s1Concat and s2Concat are equals");
        }
    }

}
