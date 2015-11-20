package com.samodeika.coursera;

import edu.duke.FileResource;

public class WordCounting {

    public String[] getCommon() {
        FileResource fileResource = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for (String s : fileResource.words()) {
            common[index] = s;
            index += 1;
        }
        return common;
    }

    private int indexOf(String[] list, String word) {
        for (int i = 0; i < list.length; i++) {
            if(list[i].equalsIgnoreCase(word)) {
                return i;
            }
        }
        return -1;
    }

    public void countWords(FileResource resource, String[] common, int[] counts) {
        for (String word : resource.words()) {
            int index = indexOf(common, word);
            if (index != -1) {
                counts[index] += 1;
            }
        }
    }

    public void countShakespeare() {
        String[] plays = {"text.txt", "caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};

        String[] common = getCommon();
        int[] counts = new int[common.length];
        for (int k = 0; k < 1; k++) {
            FileResource resourse = new FileResource("data/" + plays[k]);
            countWords(resourse, common, counts);
            System.out.println("done with " + plays[k]);
        }

        print(common, counts);
    }

    private void print(String[] array, int[] counts) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "\t" + counts[i]);
        }
    }

    public static void main(String[] args) {
        WordCounting test = new WordCounting();
        test.countShakespeare();
    }

}
