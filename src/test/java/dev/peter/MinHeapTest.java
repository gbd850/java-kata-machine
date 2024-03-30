package dev.peter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void givenHeap_shouldInsert() {
        MinHeap<Integer> heap = new MinHeap<>();

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);

        List<Integer> expected = List.of(1, 2, 3);

        assertEquals(3, heap.getLength());
        assertArrayEquals(expected.toArray(new Integer[0]), heap.getData().toArray(new Integer[0]));
    }

    @Test
    void givenHeap_shouldDelete() {
        MinHeap<Integer> heap = new MinHeap<>();

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);

        Integer deleted = heap.delete();

        List<Integer> expected = List.of(2, 4, 3);

        assertEquals(1, deleted);
        assertEquals(3, heap.getLength());
        assertArrayEquals(expected.toArray(new Integer[0]), heap.getData().toArray(new Integer[0]));
    }
}