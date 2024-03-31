package dev.peter.lru;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class LRUCache<K, V> {

    private int length;

    private int capacity;

    private LRUNode<V> head;

    private LRUNode<V> tail;

    private Map<K, LRUNode<V>> lookup;

    public LRUCache(int capacity) {
        this.length = 0;
        this.head = this.tail = null;
        this.lookup = new HashMap<>();
        this.capacity = capacity;
    }

    public void update(K key, V value) {
        LRUNode<V> node = this.lookup.get(key);

        if (isNull(node)) {
            node = new LRUNode<>(value, null, null);
            this.length++;
            this.prepend(node);
            this.trimCache(key);
            this.lookup.put(key, node);
        } else {
            this.detach(node);
            this.prepend(node);
            node.setValue(value);
        }
    }

    public V get(K key) {
        final LRUNode<V> node = this.lookup.get(key);

        if (isNull(node)) {
            return null;
        }

        this.detach(node);
        this.prepend(node);

        return node.getValue();
    }

    private void detach(LRUNode<V> node) {
        if (!isNull(node.getNext())) {
            node.getPrev().setNext(node.getNext());
        }

        if (!isNull(node.getPrev())) {
            node.getNext().setPrev(node.getPrev());
        }

        if (this.length == 1) {
            this.head = this.tail = null;
        }

        if (this.head == node) {
            this.head = this.head.getNext();
        }

        if (this.tail == node) {
            this.tail = this.tail.getPrev();
        }

        node.setNext(null);
        node.setPrev(null);
    }

    private void prepend(LRUNode<V> node) {
        if (isNull(this.head)) {
            this.head = this.tail = node;
            return;
        }

        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
    }

    private void trimCache(K key) {
        if (this.length > this.capacity) {
            final LRUNode<V> tail = this.tail;
            this.detach(this.tail);
            this.lookup.remove(key);
            this.length--;
        }
    }

    public int getLength() {
        return length;
    }

    public LRUNode<V> getHead() {
        return head;
    }

    public LRUNode<V> getTail() {
        return tail;
    }

    public Map<K, LRUNode<V>> getLookup() {
        return lookup;
    }
}
