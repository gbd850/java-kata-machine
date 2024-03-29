package dev.peter.list;

import java.util.Objects;

public class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;
    private LinkedListNode<T> prev;

    public LinkedListNode(T value, LinkedListNode<T> next, LinkedListNode<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public LinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedListNode<T> prev) {
        this.prev = prev;
    }
}
