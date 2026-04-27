package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final String inputType;
    private final String expectedSpecies;

    public FelineParameterizedTest(String inputType, String expectedSpecies) {
        this.inputType = inputType;
        this.expectedSpecies = expectedSpecies;
    }

    @Parameterized.Parameters(name = "type={0}, species={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"wild", "Panthera leo"},
                {"domestic", "Felis catus"},
                {"", "Felis catus"},
                {null, "Felis catus"},
                {"street", "Felis catus"}
        });
    }

    @Test
    public void speciesDependsOnType() {
        Feline feline = new Feline(inputType);
        assertEquals(expectedSpecies, feline.getSpeciesName());
    }
}

// Sprint 6