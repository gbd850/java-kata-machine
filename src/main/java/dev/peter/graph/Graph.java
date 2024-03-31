package dev.peter.graph;

import java.util.*;

public class Graph {

    public static int[] breadthFirstSearch_AdjMatrix(int[][] graph, int source, int value) {

        final boolean[] seen = new boolean[graph.length];
        final int[] prev = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < seen.length; i++) {
            seen[i] = false;
            prev[i] = -1;
        }

        seen[source] = true;
        queue.add(source);

        do {
            final int curr = queue.remove();
            if (curr == value) {
                break;
            }

            final int[] adjs = graph[curr];
            for (int i = 0; i < adjs.length; i++) {
                if (adjs[i] == 0) {
                    continue;
                }

                if (seen[i]) {
                    continue;
                }

                seen[i] = true;
                prev[i] = curr;
                queue.add(i);
            }

        } while (queue.size() > 0);

        int curr = value;
        final List<Integer> out = new ArrayList<>();

        while (prev[curr] != -1) {
            out.add(curr);
            curr = prev[curr];
        }

        if (!out.isEmpty()) {
            out.add(source);
            Collections.reverse(out);
        }
        return out.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean walk(GraphEdge[][] graph, int curr, int value, boolean[] seen, Stack<Integer> path) {


        if (seen[curr]) {
            return false;
        }

        seen[curr] = true;

        // pre
        path.push(curr);
        if (curr == value) {
            return true;
        }

        // recurse
        GraphEdge[] list = graph[curr];
        for (int i = 0; i < list.length; i++) {
            GraphEdge edge = list[i];

            if (walk(graph, edge.getTo(), value, seen, path)) {
                return true;
            }
        }

        // post
        path.pop();

        return false;
    }
    public static int[] depthFirstSearch_AdjList(GraphEdge[][] graph, int source, int value) {
        final boolean[] seen = new boolean[graph.length];
        Stack<Integer> path = new Stack<>();

        walk(graph, source, value, seen, path);

        return path.stream().mapToInt(Integer::intValue).toArray();
    }

}
