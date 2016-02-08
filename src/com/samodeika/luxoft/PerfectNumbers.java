package com.samodeika.luxoft;

public class PerfectNumbers {

    public static void main(String[] args) {

        long maxValue = Integer.MAX_VALUE;
        for (long i = 2; i <= maxValue / 2; i++) {
            long sum = 0;
            String format = "";
            for (long j = 1; j < i; j++) {
                if(i % j == 0) {
                    format +=  "" + j + " + ";
                    sum += j;
                }
            }
            if (i == sum) {
                System.out.println("Perfect number = " + i + " = " + format);
            }
        }

    }

}
