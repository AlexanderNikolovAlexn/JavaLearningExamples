package com.samodeika.algorithms;

public class decryptor {

    private static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static int[] positions = {
            19, 15, 14, 25, -1, 24, 16, 5, 18, 9, 1, -1, 24, 1
    };

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < positions.length; i++) {
            if(positions[i] == -1) {
                sb.append(" ");
                continue;
            }
            sb.append(letters[positions[i] - 1]);
        }

        System.out.println(sb.toString());
    }

}
