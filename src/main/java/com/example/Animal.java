package com.example;

public class Animal {

    private static final String DEFAULT_FAMILY = "Животные";

    private final String family;

    public Animal() {
        this(DEFAULT_FAMILY);
    }

    public Animal(String family) {
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public int getKittens() {
        return 1;
    }

    public int getKittens(int count) {
        return count;
    }
}

// Sprint 6