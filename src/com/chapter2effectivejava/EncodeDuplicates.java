package com.chapter2effectivejava;

/**
 * Created by everduin on 11/22/2016.
 */
public class EncodeDuplicates {

    /**
     * encodes all duplicates into ). If it's not a dup, (.
     * @param word - word given as input
     * @return encoded String
     */
        static String encode(String word){
            word = word.toLowerCase(); //Set word to lowercase
            String result = ""; //Init a String named result to " "
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i); //Init a char "c" set to word.charAt(i)
                result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
                // ^^ if word.lastIndexOf(c) == word.indexOf(c) not a dup. else it's a dup.
            }
            return result;
        }
}
