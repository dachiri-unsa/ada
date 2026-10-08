package lab04.mts;

import lab04.Edge;

import java.util.List;

public record MSTGraph(
        int vertices,
        List<Edge> edges,
        List<List<Edge>> adjacency
) {}