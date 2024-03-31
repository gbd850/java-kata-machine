package dev.peter.lru;

public class LRUNode<T> {
    private T value;
    private LRUNode<T> next;
    private LRUNode<T> prev;

    public LRUNode(T value, LRUNode<T> next, LRUNode<T> prev) {
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

    public LRUNode<T> getNext() {
        return next;
    }

    public void setNext(LRUNode<T> next) {
        this.next = next;
    }

    public LRUNode<T> getPrev() {
        return prev;
    }

    public void setPrev(LRUNode<T> prev) {
        this.prev = prev;
    }
}
