package com.example;

import java.util.Arrays;
import java.util.List;

public class Alex extends Lion {

    private static final List<String> FRIENDS =
            Arrays.asList("Марти", "Глория", "Мелман");
    private static final String ZOO_NAME = "Нью-Йоркский зоопарк";

    private final String name;
    private final int age;
    private final String favoriteFood;

    public Alex(Feline felineHelper) {
        this(felineHelper, "Алекс", 10, "стейк");
    }

    public Alex(Feline felineHelper, String name, int age, String favoriteFood) {
        super(felineHelper, "Самец");
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return FRIENDS;
    }

    public String getPlaceOfLiving() {
        return ZOO_NAME;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getProfile() {
        return "Лев " + name + ", возраст: " + age
                + ", живёт в " + ZOO_NAME
                + ", друзья: " + FRIENDS
                + ", любимая еда: " + favoriteFood;
    }

    public boolean livesInZoo(String zooName) {
        return ZOO_NAME.equalsIgnoreCase(zooName);
    }

    public java.util.List<String> getFood() {
        return super.getFood();
    }
}

// Sprint 6