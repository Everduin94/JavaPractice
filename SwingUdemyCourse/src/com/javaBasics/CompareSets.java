package com.javaBasics;

import com.sun.istack.internal.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by everduin on 12/1/2016.
 */
public final class CompareSets {

    public static void compareWithinList(List<String> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            for (int j = i + 1; j < listSize; j++) {
                String stringI = list.get(i);
                String stringJ = list.get(j);
                if (stringI.equals(stringJ)) {
                    System.out.println("I: " + stringI + " Equals J: " + stringJ);
                }
            }
        }
    }

    /**
     * The Sets class is from the Google Guava Library
     * Contains useful utility methods for Set, Lists, Maps and Queues
     *
     * @param set1 - set 1
     * @param set2 - set 2
     */
    public static void findMatchInSets(Set<String> set1, Set<String> set2) {
    //boolean intersection = Sets.intersection(set1, set2).isEmpty();
    }

    public static String iterateOverMap(Map<String,String> map, @Nullable String mapKey){
        /*Fixed - Just use the get method if you know the key*/
        String valueAtKey = map.get(mapKey);

        for(Map.Entry<String, String> entry : map.entrySet()){
            if (mapKey.equals(entry.getKey())){
                System.out.println("Value at key is: " + entry.getValue());
            }
        }
        return "Key not found";
    }

}
