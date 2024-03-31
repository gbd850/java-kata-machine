package dev.peter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GraphTest {

    private final int[][] graph = new int[][]{
            {0, 3, 1, 0, 0, 0, 0}, // 0
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 5, 0, 2, 0},
            {0, 0, 18, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1},
    };

    @Test
    void givenAdjMatrixGraph_shouldBreadthFirstSearchReturnPath() {
        int[] expected = new int[]{0, 1, 4, 5, 6};

        assertArrayEquals(expected, Graph.breadthFirstSearch_AdjMatrix(graph, 0, 6));
    }

    @Test
    void givenAdjMatrixGraph_shouldBreadthFirstSearchReturnEmptyArray() {
        int[] expected = new int[0];

        assertArrayEquals(expected, Graph.breadthFirstSearch_AdjMatrix(graph, 6, 0));
    }
}