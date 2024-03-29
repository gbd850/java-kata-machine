package dev.peter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void givenArray_shouldSort() {
        int[] array = new int[] {1, 5, 7, 6, 2, 3, 9, 10, 4, 8};

        QuickSort.quickSort(array);

        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals(expected, array);
    }
}