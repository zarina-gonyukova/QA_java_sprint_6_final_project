package com.example;

import java.util.Arrays;
import java.util.List;

public class Feline extends Animal implements Predator {

    private static final String TYPE_WILD = "wild";
    private static final String TYPE_DOMESTIC = "domestic";

    private final String type;

    public Feline() {
        this(TYPE_DOMESTIC);
    }

    public Feline(String type) {
        if (type == null || type.isBlank()) {
            this.type = TYPE_DOMESTIC;
        } else {
            this.type = type.trim().toLowerCase();
        }
    }

    public String getSpeciesName() {
        if (TYPE_WILD.equals(type)) {
            return "Panthera leo";
        }
        return "Felis catus";
    }

    public String getType() {
        return type;
    }

    @Override
    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int count) {
        return super.getKittens(count);
    }

    @Override
    public List<String> getMeatMenu() {
        return Arrays.asList("Птица", "Рыба", "Мелкие млекопитающие");
    }

    public String getFullClassification() {
        return getFamily() + " - " + getSpeciesName() + " [" + type + "]";
    }
}

// Sprint 6