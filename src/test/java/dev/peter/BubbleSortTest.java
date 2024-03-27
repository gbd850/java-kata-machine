package dev.peter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void givenArray_shouldSort() {
        int[] array = {1, 3, 7, 4, 2, 5};

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 7}, BubbleSort.bubbleSort(array));
    }
}