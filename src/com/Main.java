package com;

import com.chapter2effectivejava.NutritionFacts;

public class Main {

    public static void main(String[] args) {

        //Builder example
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        cocaCola.printAllNutritionFacts();

    }
}
