package dev.peter.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void givenEmptyStack_shouldProperlyPush() {
        Stack<Integer> stack = new Stack<>();

        Integer value = 5;
        stack.push(value);

        assertEquals(1, stack.getLength());
        assertEquals(value, stack.getHead().getValue());
    }

    @Test
    void givenNonEmptyStack_shouldProperlyPush() {
        Stack<Integer> stack = new Stack<>();
        Integer value = 5;
        stack.push(value);

        Integer value2 = 15;
        stack.push(value2);

        assertEquals(2, stack.getLength());
        assertEquals(value2, stack.getHead().getValue());
        assertEquals(value, stack.getHead().getNext().getValue());
    }

    @Test
    void givenNonEmptyStack_shouldProperlyPop() {
        Stack<Integer> stack = new Stack<>();
        Integer value = 5;
        stack.push(value);

        Integer popped = stack.pop();

        assertEquals(value, popped);
        assertEquals(0, stack.getLength());
    }

    @Test
    void givenEmptyStack_shouldThrowExceptionFromPop() {
        Stack<Integer> stack = new Stack<>();

        assertThrows(NullPointerException.class, stack::pop);
    }

    @Test
    void givenNonEmptyStack_shouldReturnValue() {
        Stack<Integer> stack = new Stack<>();
        Integer value = 5;
        stack.push(value);

        assertEquals(value, stack.peek());
    }

    @Test
    void givenNonEmptyStack_shouldThrowExceptionFromPeek() {
        Stack<Integer> stack = new Stack<>();

        assertThrows(NullPointerException.class, stack::peek);
    }
}