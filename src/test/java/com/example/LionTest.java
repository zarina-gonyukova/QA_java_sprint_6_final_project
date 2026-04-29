package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void maleLionHasManeTest() throws Exception {
        Predator predator = mock(Predator.class);
        Lion lion = new Lion(predator, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleLionHasNoManeTest() throws Exception {
        Predator predator = mock(Predator.class);
        Lion lion = new Lion(predator, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void invalidSexThrowsExceptionTest() throws Exception {
        Predator predator = mock(Predator.class);
        new Lion(predator, "Лев");
    }

    @Test
    public void getFoodUsesPredatorEatMeatTest() throws Exception {
        Predator predator = mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные"));

        Lion lion = new Lion(predator, "Самец");

        assertEquals(List.of("Животные"), lion.getFood());
        verify(predator, times(1)).eatMeat();
    }

    @Test
    public void getKittensReturnsFelineKittensTest() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(feline, "Самец");

        assertEquals(3, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void getKittensReturnsZeroForNonFelinePredatorTest() throws Exception {
        Predator predator = mock(Predator.class);
        Lion lion = new Lion(predator, "Самец");

        assertEquals(0, lion.getKittens());
    }
}