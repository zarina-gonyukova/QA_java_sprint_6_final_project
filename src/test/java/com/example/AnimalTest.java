package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void animalHasCorrectFamily() {
        Animal animal = new Animal();
        assertEquals("Животные", animal.getFamily());
    }

    @Test
    public void animalHasOneKittenByDefault() {
        Animal animal = new Animal();
        assertEquals(1, animal.getKittens());
    }

    @Test
    public void animalReturnsCustomKittensCount() {
        Animal animal = new Animal();
        assertEquals(5, animal.getKittens(5));
    }
}

// Sprint 6 homework
