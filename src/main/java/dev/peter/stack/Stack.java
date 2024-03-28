package dev.peter.stack;

import java.util.Objects;

import static java.util.Objects.isNull;

public class Stack<T> {

    private int length;

    private StackNode<T> head;

    public Stack() {
        this.length = 0;
        this.head = null;
    }

    public void push(T value) {
        this.length++;

        StackNode<T> node = new StackNode<>(value, null);

        if(isNull(this.head)) {
            this.head = node;
            return;
        }

        node.setNext(this.head);
        this.head = node;
    }

    public T pop() {
        Objects.requireNonNull(this.head);

        this.length--;

        StackNode<T> head = this.head;
        this.head = this.head.getNext();

        head.setNext(null);

        return head.getValue();
    }

    public T peek() {
        return Objects.requireNonNull(this.head.getValue());
    }

    public int getLength() {
        return length;
    }

    public StackNode<T> getHead() {
        return head;
    }
}
