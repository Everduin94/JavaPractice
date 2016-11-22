package com.chapter2effectivejava;

/**
 * Created by everduin on 11/22/2016.
 */
public class OddNumberFinder {

    public static int findOdd(int[] args) {
        int xor = 0;
        for (int i = 0; i < args.length; i++) {
            xor ^= args[i];
        }
        return xor;
    }
}
