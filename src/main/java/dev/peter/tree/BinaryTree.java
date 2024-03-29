package dev.peter.tree;

import java.util.List;
import java.util.Stack;

import static java.util.Objects.isNull;

public class BinaryTree<T> {

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

}
