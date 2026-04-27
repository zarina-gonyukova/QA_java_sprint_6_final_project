package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class AlexTest {

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
    public void alexHasNoKittens() {
        Alex alex = new Alex(felineMock);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void alexHasThreeFriends() {
        Alex alex = new Alex(felineMock);
        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    public void alexLivesInZoo() {
        Alex alex = new Alex(felineMock);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void alexGetsFoodFromFeline() {
        when(felineMock.getMeatMenu()).thenReturn(Collections.singletonList("Птица"));

        Alex alex = new Alex(felineMock);

        assertEquals(1, alex.getFood().size());
        assertEquals(Collections.singletonList("Птица"), alex.getFood());
    }

    @Test
    public void alexHasDefaultNameAgeAndFavoriteFood() {
        Alex alex = new Alex(felineMock);

        assertEquals("Алекс", alex.getName());
        assertEquals(10, alex.getAge());
        assertEquals("стейк", alex.getFavoriteFood());
    }

    @Test
    public void profileContainsNameZooFriendsAndFood() {
        Alex alex = new Alex(felineMock);

        String profile = alex.getProfile();

        org.junit.Assert.assertTrue(profile.contains("Алекс"));
        org.junit.Assert.assertTrue(profile.contains("Нью-Йоркский зоопарк"));
        org.junit.Assert.assertTrue(profile.contains("Марти"));
        org.junit.Assert.assertTrue(profile.contains("Глория"));
        org.junit.Assert.assertTrue(profile.contains("Мелман"));
        org.junit.Assert.assertTrue(profile.contains("стейк"));
    }

    @Test
    public void livesInCorrectZooReturnsTrue() {
        Alex alex = new Alex(felineMock);

        org.junit.Assert.assertTrue(alex.livesInZoo("Нью-Йоркский зоопарк"));
    }

    @Test
    public void livesInOtherZooReturnsFalse() {
        Alex alex = new Alex(felineMock);

        org.junit.Assert.assertFalse(alex.livesInZoo("Лондонский зоопарк"));
    }
}

// Sprint 6