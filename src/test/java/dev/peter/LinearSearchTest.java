package dev.peter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LinearSearchTest {

    @Test
    void givenNonEmptyArray_shouldReturnTrue() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer val = 5;

        assertTrue(LinearSearch.linearSearch(array, val));
    }

    @Test
    void givenNonEmptyArray_shouldReturnFalse() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer val = 15;

        assertFalse(LinearSearch.linearSearch(array, val));
    }

    @Test
    void givenEmptyArray_shouldReturnFalse() {
        Integer[] array = {};
        Integer val = 15;

        assertFalse(LinearSearch.linearSearch(array, val));
    }
}