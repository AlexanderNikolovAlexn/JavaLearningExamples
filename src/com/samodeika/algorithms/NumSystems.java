package com.samodeika.algorithms;

public class NumSystems {

    private static String getChar(long n) {
        String s = "";
        return n < 10 ? n + s : (char) ('A' - 10 + n) + s;
    }

    public static String convert(long n, int base) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            long l = n % base;
            result.append(getChar(l));
            n /= base;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 29;
        int baseSystem = 16;
        System.out.println("Input number: " + num + " Base: " + baseSystem + " Result: " + convert(num, baseSystem));
    }

}
