package com.example;

import java.util.List;

public class Lion {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";

    private final String gender;
    private final Feline feline;

    public Lion(Feline feline, String gender) {
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException(
                    "Пол животного должен быть указан как \"Самец\" или \"Самка\""
            );
        }
        this.feline = feline;
        this.gender = normalizeGender(gender);
    }

    private boolean isValidGender(String gender) {

        return MALE.equalsIgnoreCase(gender) || FEMALE.equalsIgnoreCase(gender);
    }

    private String normalizeGender(String gender) {

        return Character.toUpperCase(gender.charAt(0))
                + gender.substring(1).toLowerCase();
    }

    public String getGender() {
        return gender;
    }

    public boolean hasMane() {
        return MALE.equalsIgnoreCase(gender);
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public List<String> getFood() {
        return feline.getMeatMenu();
    }

    public String getDescription() {
        return "Лев, пол: " + gender + ", хищник, рацион: " + getFood();
    }
}

// Sprint 6