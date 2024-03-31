package dev.peter.graph;

public class GraphEdge {

    private int to;

    private int weight;

    public GraphEdge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
