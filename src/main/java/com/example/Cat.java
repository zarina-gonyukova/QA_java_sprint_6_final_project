package com.example;

public class Cat {

    private static final String DEFAULT_SOUND = "Мяу";

    private final Feline feline;
    private final String name;

    public Cat(Feline feline) {
        this(feline, "Безымянный кот");
    }

    public Cat(Feline feline, String name) {
        this.feline = feline;
        this.name = name;
    }

    public String getSound() {
        return DEFAULT_SOUND;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public String getFamily() {
        return feline.getFamily();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return "Кот по имени " + name
                + " из семейства " + getFamily()
                + ", издаёт звук \"" + getSound() + "\"";
    }
}

// Sprint 6