package dev.peter.tree;

import java.util.*;

import static java.util.Objects.isNull;

public class BinaryTree<T extends Number> {

    private BinaryNode<T> head;

    public BinaryTree() {
        this.head = null;
    }

    public BinaryTree(BinaryNode<T> head) {
        this.head = head;
    }

    private Stack<T> walkPreOrder(BinaryNode<T> curr, Stack<T> path) {
        if (isNull(curr)) {
            return path;
        }

        path.push(curr.getValue());

        walkPreOrder(curr.getLeft(), path);
        walkPreOrder(curr.getRight(), path);

        return path;
    }

    private Stack<T> walkInOrder(BinaryNode<T> curr, Stack<T> path) {
        if (isNull(curr)) {
            return path;
        }

        walkPreOrder(curr.getLeft(), path);

        path.push(curr.getValue());

        walkPreOrder(curr.getRight(), path);

        return path;
    }

    private Stack<T> walkPostOrder(BinaryNode<T> curr, Stack<T> path) {
        if (isNull(curr)) {
            return path;
        }

        walkPreOrder(curr.getLeft(), path);
        walkPreOrder(curr.getRight(), path);

        path.push(curr.getValue());

        return path;
    }

    public List<T> preOrderSearch() {
        return walkPreOrder(this.head, new Stack<>()).stream().toList();
    }
    public List<T> inOrderSearch() {
        return walkInOrder(this.head, new Stack<>()).stream().toList();
    }

    public List<T> postOrderSearch() {
        return walkPostOrder(this.head, new Stack<>()).stream().toList();
    }

    public boolean breadthFirstSearch(T value) {
        Queue<BinaryNode<T>> queue = new LinkedList<>();

        queue.add(this.head);

        BinaryNode<T> curr;

        while (queue.size() > 0) {
            curr = queue.remove();

            if (curr.getValue().equals(value)) {
                return true;
            }

            if (!isNull(curr.getLeft())) {
                queue.add(curr.getLeft());
            }
            if (!isNull(curr.getRight())) {
                queue.add(curr.getRight());
            }
        }

        return false;
    }

    private boolean search(BinaryNode<T> curr, T value) {
        if (isNull(curr)) {
            return false;
        }

        if (curr.getValue().equals(value)) {
            return true;
        }

        if (curr.getValue().doubleValue() < value.doubleValue()) {
            return search(curr.getRight(), value);
        }

        return search(curr.getLeft(), value);
    }

    public boolean depthFirstSearchBST(T value) {
        return search(this.head, value);
    }

    private boolean compareTrees(BinaryNode<T> node1, BinaryNode<T> node2) {
        if (isNull(node1) && isNull(node2)) {
            return true;
        }

        if (isNull(node1) || isNull(node2)) {
            return false;
        }

        if (!node1.getValue().equals(node2.getValue())) {
            return false;
        }

        return compareTrees(node1.getLeft(), node2.getLeft()) && compareTrees(node1.getRight(), node2.getRight());
    }
    public boolean compare(BinaryTree<T> tree) {
        return compareTrees(this.head, tree.head);
    }

}
