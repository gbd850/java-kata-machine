package dev.peter.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void givenList_shouldAppend() {
        list.append(1);
        list.append(2);
        list.append(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void givenList_shouldPrepend() {
        list.append(1);
        list.prepend(2);

        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void givenList_shouldInsertAt() {
        list.append(1);
        list.append(3);
        list.insertAt(1, 2);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void givenList_shouldRemove() {
        list.append(1);
        list.append(2);
        list.append(3);

        list.remove(2);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void givenList_shouldGet() {
        list.append(1);
        list.append(2);
        list.append(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void givenList_shouldRemoveAt() {
        list.append(1);
        list.append(2);
        list.append(3);

        list.removeAt(1);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }
}