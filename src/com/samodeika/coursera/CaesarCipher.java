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

    public String decrypt(String text) {
        int[] counts = getLetterCount(text);
        // print(counts);
        int maxDen = maxIndex(counts);
        int dkey = maxDen - 4; //4 - letter 'e'
        if(maxDen < 4) {
            dkey = 26 - (4 - maxDen);
        }
        return encrypt(text, 26 - dkey);
    }

    private int maxIndex(int[] counts) {
        int maxNumber = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] > maxNumber) {
                maxNumber = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int[] getLetterCount(String text) {
        int[] result = new int[alphabet.length()];
        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.indexOf(Character.toUpperCase(text.charAt(i)));
            if(index != -1) {
                result[index] += 1;
            }
        }
        return result;
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Index: " + i + "; Value: " + array[i]);
        }
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

    public String decryptTwoKeys(String text) {
        String[] texts = getTwoTexts(text);
        texts[0] = decrypt(texts[0]);
        texts[1] = decrypt(texts[1]);
        String result = getOriginalText(texts);
        return result;
    }

    private String getOriginalText(String[] texts) {
        String result = "";
        for (int i = 0; i < Math.max(texts[0].length(), texts[1].length()); i++) {
            if (texts[0].length() > i) {
                result += texts[0].charAt(i);
            }
            if (texts[1].length() > i) {
                result += texts[1].charAt(i);
            }
        }
        return result;
    }
    
    private String[] getTwoTexts(String text) {
        String res1 = "";
        String res2 = "";
        for (int i = 0; i < text.length(); i++) {
            if(i%2==0) {
                res1 += text.charAt(i);
            }
            else {
                res2 += text.charAt(i);
            }
        }
        String[] result = {res1, res2};
        return result;
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

    public void eyeBallDecrypt(String text) {
        for (int i = 0; i < alphabet.length(); i++) {
            System.out.println(i + " " + encrypt(text, i));
        }
    }

    public void textFingerPrint(String text) {
        int[] counters = new int[alphabet.length() - 1];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(ch));
            if(index != -1) {
                counters[index] +=1;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            System.out.println(alphabet.charAt(i) + "\t" + counters[i]);
        }
    }

    public static void main(String[] args) {
        CaesarCipher cs = new CaesarCipher();
        String text = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD! me, me, me, me";
        String text2 = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        int key = 15;
        // System.out.println(cs.encrypt(text, key));
        // Brute force algorith
        //cs.eyeBallDecrypt(cs.encrypt(text, key));
        System.out.println(cs.encryptTwoKeys(text2, 23, 2));
        //cs.textFingerPrint(text);
        System.out.println(cs.decryptTwoKeys(text2));

    }

}
