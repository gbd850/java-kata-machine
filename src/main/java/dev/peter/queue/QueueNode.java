package dev.peter.queue;

public class QueueNode<T> {
    private T value;
    private QueueNode<T> next;

    public QueueNode(T value, QueueNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}
