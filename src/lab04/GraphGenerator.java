package lab04;

import lab04.mts.MSTGraph;

import java.util.*;

public class GraphGenerator {

    public static MSTGraph generateGraph(int vertices) {
        Random random = new Random();
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i < vertices; i++) {
            int parent = random.nextInt(i);
            int weight = random.nextInt(100) + 1;
            edges.add(new Edge(parent, i, weight));
        }

        int extraEdges = vertices * 2;

        Set<String> existingEdges = new HashSet<>();

        for (Edge edge : edges) {
            existingEdges.add(
                    Math.min(edge.from(), edge.to()) + "-" +
                            Math.max(edge.from(), edge.to())
            );
        }

        while (extraEdges > 0) {
            int from = random.nextInt(vertices);
            int to = random.nextInt(vertices);
            if (from == to) continue;

            String key = Math.min(from, to) + "-" + Math.max(from, to);

            if (existingEdges.add(key)) {
                int weight = random.nextInt(100) + 1;
                edges.add(new Edge(from, to, weight));
                extraEdges--;
            }
        }

        return new MSTGraph(vertices, edges, buildAdjacency(vertices, edges));
    }

    public static List<List<Edge>> buildAdjacency(int vertices, List<Edge> edges) {

        List<List<Edge>> adjacency = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjacency.get(edge.from()).add(edge);
            adjacency.get(edge.to()).add(
                    new Edge(
                            edge.to(),
                            edge.from(),
                            edge.weight()
                    )
            );
        }

        return adjacency;
    }
}
