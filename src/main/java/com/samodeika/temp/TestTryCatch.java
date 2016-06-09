package com.samodeika.temp;

public class TestTryCatch {

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        try {
            throw new RuntimeException();
        }
        catch (RuntimeException ex) {
            System.out.println("Before catch return");
            return getNumber(1);
        }
        finally {
            System.out.println("Before finally return");
            return getNumber(2);
        }
    }

    private static int getNumber(int res) {
        System.out.println("Get number: " + res);
        return res;
    }

}
