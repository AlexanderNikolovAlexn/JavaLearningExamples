package com.samodeika.luxoft;

public class Recursion {

    public static void main(String[] args) {

        System.out.println("Test recursion!");
        //System.out.println(fact(5));
        //System.out.println(fib(6, new int[6 + 1]));
    }

    public static long fact(long num) {
        if(num == 0) {
            return 1;
        }
        return num * fact(num - 1);
    }

    public static int fib(int num, int[] existingValues) {
        if(num <= 1) {
            return num;
        }
        if(existingValues[num] > 0) return existingValues[num];
        return existingValues[num] = fib(num - 1, existingValues) + fib(num - 2, existingValues);
    }

    //Optimized variant
    public static int biggestMutualDividor(int num1, int num2) {
        if(num2 == 0) return num1;
        return biggestMutualDividor(num2, num1 % num2);
    }

}
