package dev.peter.list;

import java.util.Objects;

import static java.util.Objects.isNull;

public class LinkedList<T> {
    private int length;

    private LinkedListNode<T> head;

    private LinkedListNode<T> tail;

    public LinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public void prepend(T value) {
        final LinkedListNode<T> node = new LinkedListNode<>(value, null, null);

        this.length++;

        if (isNull(this.head)) {
            this.head = this.tail = node;
            return;
        }
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
    }

    public void insertAt(int index, T value) {
        if(index > this.length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == this.length) {
            this.append(value);
            return;
        }
        if (index == 0) {
            this.prepend(value);
            return;
        }

        this.length++;

        LinkedListNode<T> curr = this.getAt(index);

        final LinkedListNode<T> node = new LinkedListNode<>(value, curr, curr.getPrev());

        curr.getPrev().setNext(node);
        curr.setPrev(node);
    }

    public void append(T value) {
        final LinkedListNode<T> node = new LinkedListNode<>(value, null, null);

        this.length++;

        if (isNull(this.tail)) {
            this.head = this.tail = node;
            return;
        }
        node.setPrev(this.tail);
        this.tail.setNext(node);
        this.tail = node;
    }

    public T remove(T value) {
        LinkedListNode<T> curr = this.head;

        for (int i = 0; i < this.length; i++) {
            if (curr.getValue().equals(value)) {
                break;
            }
            curr = curr.getNext();
        }

        if (isNull(curr)) {
            return null;
        }

        return this.removeNode(curr);
    }

    public T get(int index) {
        return Objects.requireNonNull(this.getAt(index)).getValue();
    }

    public T removeAt(int index) {
        final LinkedListNode<T> node = this.getAt(index);

        if (isNull(node)) {
            return null;
        }

        return this.removeNode(node);
    }

    private T removeNode(LinkedListNode<T> node) {
        this.length--;

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());

        if (node.equals(this.head)) {
            this.head = node.getNext();
        }
        if (node.equals(this.tail)) {
            this.tail = node.getPrev();
        }

        node.setNext(null);
        node.setPrev(null);

        return node.getValue();
    }

    private LinkedListNode<T> getAt(int index) {
        LinkedListNode<T> curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        return curr;
    }
}
