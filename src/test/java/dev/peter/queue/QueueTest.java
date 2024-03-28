package dev.peter.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void givenEmptyQueue_shouldProperlyEnqueue() {
        Queue<Integer> queue = new Queue<>();

        Integer value = 5;
        queue.enqueue(value);

        assertEquals(1, queue.getLength());
        assertEquals(value, queue.getHead().getValue());
        assertEquals(value, queue.getTail().getValue());
    }

    @Test
    void givenNonEmptyQueue_shouldProperlyEnqueue() {
        Queue<Integer> queue = new Queue<>();
        Integer value = 5;
        queue.enqueue(value);

        Integer value2 = 15;
        queue.enqueue(value2);

        assertEquals(2, queue.getLength());
        assertEquals(value, queue.getHead().getValue());
        assertEquals(value2, queue.getTail().getValue());
    }

    @Test
    void givenQueue_shouldProperlyDeque() {
        Queue<Integer> queue = new Queue<>();
        Integer value = 5;
        queue.enqueue(value);

        Integer dequed = queue.deque();

        assertEquals(value, dequed);
        assertEquals(0, queue.getLength());
    }

    @Test
    void givenEmptyQueue_shouldThrowExceptionForDeque() {
        Queue<Integer> queue = new Queue<>();

        assertThrows(NullPointerException.class, queue::deque);
    }

    @Test
    void givenQueue_shouldReturnValue() {
        Queue<Integer> queue = new Queue<>();
        Integer value = 5;
        queue.enqueue(value);

        assertEquals(value, queue.peek());
    }

    @Test
    void givenEmptyQueue_shouldThrowExceptionForPeek() {
        Queue<Integer> queue = new Queue<>();

        assertThrows(NullPointerException.class, queue::peek);
    }
}