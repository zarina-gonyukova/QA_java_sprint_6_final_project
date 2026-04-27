package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    @Test
    public void catSoundIsMeow() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void catKittensDelegatedToFeline() {
        Feline helper = Mockito.mock(Feline.class);
        when(helper.getKittens()).thenReturn(1);

        Cat cat = new Cat(helper);

        assertEquals(1, cat.getKittens());
    }

    @Test
    public void catFamilyDelegatedToFeline() {
        Feline helper = Mockito.mock(Feline.class);
        when(helper.getFamily()).thenReturn("Животные");

        Cat cat = new Cat(helper);

        assertEquals("Животные", cat.getFamily());
    }

    @Test
    public void catHasDefaultName() {
        Cat cat = new Cat(new Feline());
        assertEquals("Безымянный кот", cat.getName());
    }

    @Test
    public void descriptionContainsNameFamilyAndSound() {
        Feline helper = Mockito.mock(Feline.class);
        when(helper.getFamily()).thenReturn("Животные");

        Cat cat = new Cat(helper, "Барсик");

        String description = cat.getDescription();

        org.junit.Assert.assertTrue(description.contains("Барсик"));
        org.junit.Assert.assertTrue(description.contains("Животные"));
        org.junit.Assert.assertTrue(description.contains("Мяу"));
    }
}

// Sprint 6