package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int input;
    private final int expected;

    public FelineParameterizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {4, 4},
                {7, 7}
        });
    }

    @Test
    public void getKittensWithArgsReturnsExpectedNumber() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}