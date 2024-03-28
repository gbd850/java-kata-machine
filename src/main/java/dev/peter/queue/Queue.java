package dev.peter.queue;

import java.util.Objects;

import static java.util.Objects.isNull;

public class Queue<T> {

    private QueueNode<T> head;

    private QueueNode<T> tail;

    private int length;

    public Queue() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public void enqueue(T val) {
        this.length++;
        QueueNode<T> node = new QueueNode<>(val, null);

        if (isNull(this.tail)) {
            this.tail = this.head = node;
            return;
        }

        this.tail.setNext(node);
        this.tail = node;
    }

    public T deque() {
        Objects.requireNonNull(this.head);

        QueueNode<T> head = this.head;
        this.head = this.head.getNext();

        head.setNext(null);

        this.length--;

        return head.getValue();
    }

    public T peek() {
        return Objects.requireNonNull(this.head.getValue());
    }

    public QueueNode<T> getHead() {
        return head;
    }

    public QueueNode<T> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
}
