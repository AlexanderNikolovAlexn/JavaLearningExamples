package com.samodeika.temp;

import java.util.Arrays;

public class TestClass {

    public static boolean hasLetter(String word, char letter)
    {
        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) == letter)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "Hurray!!#! It's Friday! finally...";
        String[] words = text.split("!+");
        System.out.println(Arrays.toString(words));
    }
}
