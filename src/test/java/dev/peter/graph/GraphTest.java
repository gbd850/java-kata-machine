package dev.peter.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private final GraphEdge[][] graphList = new GraphEdge[][]{
            {
                    new GraphEdge(1, 3),
                    new GraphEdge(2, 1)
            },
            {
                    new GraphEdge(4, 1)
            },
            {
                    new GraphEdge(3, 7)
            },
            {

            },
            {
                    new GraphEdge(1, 1),
                    new GraphEdge(3, 5),
                    new GraphEdge(5, 2)
            },
            {
                    new GraphEdge(2, 18),
                    new GraphEdge(6, 1)
            },
            {
                    new GraphEdge(3, 1)
            }
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

    @Test
    void givenAdjListGraph_shouldDepthFirstSearchReturnPath() {
        int[] expected = new int[]{0, 1, 4, 5, 6};

        assertArrayEquals(expected, Graph.depthFirstSearch_AdjList(graphList, 0, 6));
    }

    @Test
    void givenAdjListGraph_shouldDepthFirstSearchReturnEmptyArray() {
        int[] expected = new int[0];

        assertArrayEquals(expected, Graph.depthFirstSearch_AdjList(graphList, 6, 0));
    }
}