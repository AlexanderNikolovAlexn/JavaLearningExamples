package com.samodeika.coursera;

public class CaesarCipher {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String text, int key) {
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder result = new StringBuilder(text);
        for (int i = 0; i < result.length(); i++) {
            char ch = Character.toUpperCase(result.charAt(i));
            if(ch >= 'A' && ch <= 'Z') {
                result.setCharAt(i, sameCaseCharacter(result.charAt(i), shiftedAlphabet.charAt(alphabet.indexOf(ch))));
            }
            else {
                result.setCharAt(i, ch);
            }
        }
        return result.toString();
    }

    public String encryptTwoKeys(String text, int key1, int key2) {
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        StringBuilder result = new StringBuilder(text);
        for (int i = 0; i < result.length(); i++) {
            char ch = Character.toUpperCase(result.charAt(i));
            if(ch >= 'A' && ch <= 'Z') {
                if(i%2 == 0) {
                    result.setCharAt(i, sameCaseCharacter(result.charAt(i), shiftedAlphabet1.charAt(alphabet.indexOf(ch))));
                }
                else {
                    result.setCharAt(i, sameCaseCharacter(result.charAt(i), shiftedAlphabet2.charAt(alphabet.indexOf(ch))));
                }
            }
            else {
                result.setCharAt(i, ch);
            }
        }
        return result.toString();
    }

    private char sameCaseCharacter(char originalChar, char returnedChar) {
        char result;
        if(originalChar == Character.toLowerCase(originalChar)) {
            result = Character.toLowerCase(returnedChar);
        }
        else {
            result = Character.toUpperCase(returnedChar);
        }
        return result;
    }

    public static void main(String[] args) {
        CaesarCipher cs = new CaesarCipher();
        String text = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 15;
        System.out.println(cs.encrypt(text, key));
        System.out.println(cs.encryptTwoKeys(text, 8, 21));
    }

}
