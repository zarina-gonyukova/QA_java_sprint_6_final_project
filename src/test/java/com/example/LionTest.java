package com.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void maleLionHasMane() {
        Feline feline = new Feline("wild");
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.hasMane());
    }

    @Test
    public void femaleLionHasNoMane() {
        Feline feline = new Feline("wild");
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.hasMane());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidGenderThrowsException() {
        Feline feline = new Feline("wild");
        new Lion(feline, "Лев");
    }

    @Test
    public void getFoodDelegatesToFeline() {
        Feline feline = new Feline("wild");
        Lion lion = new Lion(feline, "Самец");

        assertEquals(
                Arrays.asList("Птица", "Рыба", "Мелкие млекопитающие"),
                lion.getFood()
        );
    }

    @Test
    public void genderIsNormalizedToTitleCase() {
        Feline feline = new Feline("wild");
        Lion lion = new Lion(feline, "сАмеЦ");

        assertEquals("Самец", lion.getGender());
    }

    @Test
    public void descriptionReturnsNonEmptyString() {
        Feline feline = new Feline("wild");
        Lion lion = new Lion(feline, "Самец");

        String description = lion.getDescription();

        assertNotNull(description);
        org.junit.Assert.assertFalse(description.isEmpty());
        org.junit.Assert.assertTrue(description.contains("Самец"));
    }
}

// Sprint 6