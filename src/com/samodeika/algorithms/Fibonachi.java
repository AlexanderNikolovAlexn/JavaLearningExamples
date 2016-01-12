package com.samodeika.algorithms;

public class Fibonachi {

    public static long fib(int n) {
        if(n < 2) {
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static long fibIterational(int n) {
        long f1 = 0;
        long f2 = 1;
        while (n-- > 0) {
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f1;
    }

    public static void main(String[] args) {
        int n = 5;
        long res = fib(n);
        long res2 = fibIterational(n);
        System.out.println("Fibonachi recursive " + n + ": " + res);
        System.out.println("Fibonachi iterational " + n + ": " + res);
    }
}
