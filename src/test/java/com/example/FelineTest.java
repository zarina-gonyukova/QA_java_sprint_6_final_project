package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void familyForFelineIsAnimalsByDefault() {
        Feline feline = new Feline();
        assertEquals("Животные", feline.getFamily());
    }

    @Test
    public void defaultKittensIsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void kittensWithArgumentReturnsSameNumber() {
        Feline feline = new Feline();
        assertEquals(4, feline.getKittens(4));
    }

    @Test
    public void meatMenuHasExpectedOrderAndItems() {
        Feline feline = new Feline("wild");
        List<String> meat = feline.getMeatMenu();

        assertEquals(3, meat.size());
        assertEquals("Птица", meat.get(0));
        assertEquals("Рыба", meat.get(1));
        assertEquals("Мелкие млекопитающие", meat.get(2));
    }

    @Test
    public void defaultTypeIsDomestic() {
        Feline feline = new Feline();
        assertEquals("domestic", feline.getType());
    }

    @Test
    public void wildTypeReturnsLionSpecies() {
        Feline feline = new Feline("wild");
        assertEquals("Panthera leo", feline.getSpeciesName());
    }

    @Test
    public void domesticTypeReturnsCatSpecies() {
        Feline feline = new Feline("domestic");
        assertEquals("Felis catus", feline.getSpeciesName());
    }

    @Test
    public void fullClassificationContainsFamilySpeciesAndType() {
        Feline feline = new Feline("wild");
        String classification = feline.getFullClassification();

        assertNotNull(classification);
        assertTrue(classification.contains("Животные"));
        assertTrue(classification.contains("Panthera leo"));
        assertTrue(classification.contains("wild"));
    }
}

// Sprint 6