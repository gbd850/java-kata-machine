package dev.peter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void givenSortedArray_shouldReturnProperIndex() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int val = 7;

        assertEquals(6, BinarySearch.binarySearch(array, val));
    }

    @Test
    void givenSortedArray_shouldReturnImproperIndex() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int val = 15;

        assertEquals(-1, BinarySearch.binarySearch(array, val));
    }
}