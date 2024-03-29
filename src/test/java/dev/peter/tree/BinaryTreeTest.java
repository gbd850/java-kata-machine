package dev.peter.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void givenTree_shouldPreOrderSearch() {
        BinaryNode<Integer> head = new BinaryNode<>(1, new BinaryNode<>(2, null, null), new BinaryNode<>(3, null, null));

        BinaryTree<Integer> tree = new BinaryTree<>(head);

        List<Integer> path = tree.preOrderSearch();

        Integer[] expected = new Integer[] {1, 2, 3};

        assertArrayEquals(path.toArray(), expected);
    }

    @Test
    void givenTree_shouldInOrderSearch() {
        BinaryNode<Integer> head = new BinaryNode<>(1, new BinaryNode<>(2, null, null), new BinaryNode<>(3, null, null));

        BinaryTree<Integer> tree = new BinaryTree<>(head);

        List<Integer> path = tree.inOrderSearch();

        Integer[] expected = new Integer[] {2, 1, 3};

        assertArrayEquals(path.toArray(), expected);
    }

    @Test
    void givenTree_shouldPostOrderSearch() {
        BinaryNode<Integer> head = new BinaryNode<>(1, new BinaryNode<>(2, null, null), new BinaryNode<>(3, null, null));

        BinaryTree<Integer> tree = new BinaryTree<>(head);

        List<Integer> path = tree.postOrderSearch();

        Integer[] expected = new Integer[] {2, 3, 1};

        assertArrayEquals(path.toArray(), expected);
    }

    @Test
    void givenTreeAndValidValue_shouldBreadthFirstSearchReturnTrue() {
        BinaryNode<Integer> head = new BinaryNode<>(1, new BinaryNode<>(2, null, null), new BinaryNode<>(3, null, null));

        BinaryTree<Integer> tree = new BinaryTree<>(head);

        assertTrue(tree.breadthFirstSearch(2));
    }

    @Test
    void givenTreeAndInvalidValue_shouldBreadthFirstSearchReturnFalse() {
        BinaryNode<Integer> head = new BinaryNode<>(1, new BinaryNode<>(2, null, null), new BinaryNode<>(3, null, null));

        BinaryTree<Integer> tree = new BinaryTree<>(head);

        assertFalse(tree.breadthFirstSearch(5));
    }
}