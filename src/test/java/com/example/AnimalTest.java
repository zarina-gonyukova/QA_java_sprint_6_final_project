package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void getFoodForHerbivoreReturnsPlantFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void getFoodForPredatorReturnsMeatFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionForUnknownAnimalType() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестное существо");
    }

    @Test
    public void getFamilyReturnsAnimalFamily() {
        Animal animal = new Animal();
        assertEquals("Животные", animal.getFamily());
    }
}