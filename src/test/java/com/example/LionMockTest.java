package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionMockTest {

    @Mock
    private Feline felineMock;

    private AutoCloseable mocks;

    @Before
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        if (mocks != null) {
            mocks.close();
        }
    }

    @Test
    public void getKittensDelegatesToFeline() {
        when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion(felineMock, "Самец");
        int actual = lion.getKittens();

        assertEquals(1, actual);
    }
}

// Sprint 6