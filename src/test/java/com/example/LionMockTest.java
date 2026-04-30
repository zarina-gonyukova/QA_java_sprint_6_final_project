package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionMockTest {

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(predatorMock, "Самец");
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFoodCallsPredatorEatMeatOnce() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(predatorMock, "Самец");
        lion.getFood();

        verify(predatorMock, times(1)).eatMeat();
    }

    @Test
    public void getKittensReturnsFelineValue() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion(felineMock, "Самка");
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
    }

    @Test
    public void getKittensCallsFelineGetKittensOnce() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion(felineMock, "Самка");
        lion.getKittens();

        verify(felineMock, times(1)).getKittens();
    }
}