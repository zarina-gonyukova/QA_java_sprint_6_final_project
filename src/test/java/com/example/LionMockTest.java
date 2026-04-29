package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionMockTest {

    @Test
    public void getFoodUsesPredatorEatMeat() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные"));

        Lion lion = new Lion(predatorMock, "Самец");
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные"), food);
        verify(predatorMock, times(1)).eatMeat();
    }

    @Test
    public void getKittensDelegatesToFelineWhenPredatorIsFeline() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion(felineMock, "Самка");
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        verify(felineMock, times(1)).getKittens();
    }
}