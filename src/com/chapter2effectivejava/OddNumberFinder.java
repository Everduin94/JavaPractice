package com.chapter2effectivejava;

/**
 * Created by everduin on 11/22/2016.
 * This
 */
public class OddNumberFinder {

    /**
     * Finds the integer that occurs an odd number of times
     * (Does not find the odd number in the array)
     * Code Wars Challenge
     * @param args - The array passed (must have at least one number occuring odd # of times
     * @return
     */
    public static int findOddOccurance(int[] args) {
        int xor = 0;
        for (int i = 0; i < args.length; i++) {
            xor ^= args[i];
        }
        return xor;
    }
}
