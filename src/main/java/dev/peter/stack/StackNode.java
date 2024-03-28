package dev.peter.stack;

public class StackNode<T> {

    private T value;

    private StackNode<T> next;

    public StackNode(T value, StackNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}
