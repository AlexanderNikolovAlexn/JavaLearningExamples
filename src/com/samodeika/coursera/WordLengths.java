package com.samodeika.coursera;

import edu.duke.FileResource;

public class WordLengths {

    public void countWordLenght(FileResource fileResource, int[] counts) {
        for (String word : fileResource.words()) {
            int lenght = getWordLenght(word);
            if(lenght >= counts.length) {
                counts[counts.length] += 1;
            }
            else {
                counts[lenght] += 1;
            }
        }
    }

    private int indexOfMax(int[] counts) {
        int result = 0;
        int maxValue = 0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] > maxValue) {
                maxValue = counts[i];
                result = i;
            }
        }

        return result;
    }

    public void testCountWordLengths() {
        FileResource fileResource = new FileResource("data/smallHamlet.txt");
        int[] counts = new int[31];
        countWordLenght(fileResource, counts);
        print(counts);

        System.out.println("Most common word length is: " + indexOfMax(counts));
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0) {
                System.out.println(array[i] + " words of length " + i);
            }
        }
    }

    private int getWordLenght(String word) {
        int length = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isLetter(ch) || ch == '-' || ch == '"' || ch == '\'') {
                length += 1;
            }
            else {
                if(length > 0) {
                    return length;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        WordLengths test = new WordLengths();
        test.testCountWordLengths();
    }
}
