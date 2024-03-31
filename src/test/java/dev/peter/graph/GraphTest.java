package dev.peter.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    private final GraphEdge[][] graphList1 = new GraphEdge[][]{
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

    private final GraphEdge[][] graphList2 = new GraphEdge[][]{
            {
                    new GraphEdge(1, 3),
                    new GraphEdge(2, 1)
            },
            {
                    new GraphEdge(0, 3),
                    new GraphEdge(2, 4),
                    new GraphEdge(4, 1)
            },
            {
                    new GraphEdge(1, 4),
                    new GraphEdge(3, 7),
                    new GraphEdge(0, 1)
            },
            {
                    new GraphEdge(2, 7),
                    new GraphEdge(4, 5),
                    new GraphEdge(6, 1)
            },
            {
                    new GraphEdge(1, 1),
                    new GraphEdge(3, 5),
                    new GraphEdge(5, 2)
            },
            {
                    new GraphEdge(6, 1),
                    new GraphEdge(4, 2),
                    new GraphEdge(2, 18)
            },
            {
                    new GraphEdge(3, 1),
                    new GraphEdge(5, 1)
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

        assertArrayEquals(expected, Graph.depthFirstSearch_AdjList(graphList1, 0, 6));
    }

    @Test
    void givenAdjListGraph_shouldDepthFirstSearchReturnEmptyArray() {
        int[] expected = new int[0];

        assertArrayEquals(expected, Graph.depthFirstSearch_AdjList(graphList1, 6, 0));
    }

    @Test
    void givenAdjListGraph_shouldDijkstraReturnPath() {
        int[] expected = new int[]{0, 1, 4, 5, 6};

        assertArrayEquals(expected, Graph.dijkstra_AdjList(graphList2, 0, 6));
    }
}