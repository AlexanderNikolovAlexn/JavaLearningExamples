package com.samodeika.conversion;

/**
 * Created by Alexander Nikolov on 7.11.2016 г..
 */
public class AppMain {

    public static void main(String[] args) {

        System.out.println(binToDec("0011"));

    }

    public static Long binToDec(String bin) {
        long dec = 0L;
        long pow = 1L;
        for (int i = (bin.length() - 1); i >= 0; i--) {
            char c = bin.charAt(i);
            dec = dec + (Long.parseLong(c + "") * pow);
            pow = pow * 2;
        }
        return dec;
    }

}
