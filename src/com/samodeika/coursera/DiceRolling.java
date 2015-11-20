package com.samodeika.coursera;

import java.util.Random;

public class DiceRolling {

    public void simulate(int rolls) {
        int[] counts = new int[13];
        Random rand = new Random();
        for (int i = 0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            counts[d1 + d2] += 1;
        }
        print(counts, rolls);
    }

    private void print(int[] array, int rolls) {
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "`s=\t" + array[i] + "\t" + 100.0 * array[i] / rolls);
        }
    }

    public static void main(String[] args) {
        DiceRolling test = new DiceRolling();
        int repeats = 1000;
        test.simulate(repeats);
    }

}
