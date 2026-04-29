package com.example;

import java.util.List;

public class Lion {

    private final Predator predator;
    private final boolean hasMane;

    public Lion(Predator predator, String sex) throws Exception {
        if (!"Самец".equals(sex) && !"Самка".equals(sex)) {
            throw new Exception(
                    "Используйте допустимые значения пола животного - Самец или Самка"
            );
        }
        this.predator = predator;
        this.hasMane = "Самец".equals(sex);
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public int getKittens() {
        if (predator instanceof Feline) {
            return ((Feline) predator).getKittens();
        }
        return 0;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}