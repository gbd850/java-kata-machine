package dev.peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<T extends Number> {

    private int length;

    private final List<T> data;

    public MinHeap() {
        this.data = new ArrayList<>();
        this.length = 0;
    }

    public void insert(T value) {
        this.data.add(value);
        heapifyUp(this.length);
        this.length++;
    }

    public T delete() {
        if (this.data.isEmpty()) {
            return null;
        }

        final T out = this.data.get(0);
        this.length--;

        if (this.length == 0) {
            this.data.clear();
            return out;
        }

        this.data.set(0, this.data.get(this.length));
        this.data.remove(this.length);
        heapifyDown(0);

        return out;
    }

    private void heapifyDown(int index) {
        if (index >= this.length) {
            return;
        }

        final int leftIndex = leftChild(index);
        final int rightIndex = rightChild(index);

        if (leftIndex >= this.length) {
            return;
        }

        final T leftValue = this.data.get(leftIndex);
        final T rightValue = this.data.get(rightIndex);
        final T value = this.data.get(index);

        if (leftValue.doubleValue() > rightValue.doubleValue() && value.doubleValue() > rightValue.doubleValue()) {
            Collections.swap(this.data, index, rightIndex);
            heapifyDown(rightIndex);
        } else if (rightValue.doubleValue() > leftValue.doubleValue() && value.doubleValue() > leftValue.doubleValue()) {
            Collections.swap(this.data, index, leftIndex);
            heapifyDown(leftIndex);
        }

    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }
        final int parent = this.parent(index);
        final T parentValue = this.data.get(parent);
        final T value = this.data.get(index);

        if (parentValue.doubleValue() > value.doubleValue()) {
            Collections.swap(this.data, index, parent);
            heapifyUp(parent);
        }
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int getLength() {
        return length;
    }

    public List<T> getData() {
        return data;
    }
}
