package com;

import com.chapter2effectivejava.NutritionFacts;
import com.chapter2effectivejava.OddNumberFinder;

public class Main {

    public static void main(String[] args) {

        //Builder example
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        cocaCola.printAllNutritionFacts();

        int[] intArray = {20, 20, 40, 40, 60, 60, 80, 80, 100};
        System.out.println(OddNumberFinder.findOddOccurance(intArray));
    }
}
