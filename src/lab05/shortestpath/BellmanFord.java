package lab05.shortestpath;

import lab05.graph.Graph;
import java.util.Arrays;

public class BellmanFord implements AlgorithmShortestPath {
    public String name() { return "Bellman-Ford"; }

    public long[][] run(Graph graph) {
        long[][] shortestDistances = new long[graph.n][graph.n];

        for (int s = 0; s < graph.n; s++) {
            long[] distances = shortestDistances[s];
            Arrays.fill(distances, Graph.INF);
            distances[s] = 0;

            for (int i = 0; i < graph.n - 1; i++) {
                boolean updated = false;

                for (int edgeIndex = 0; edgeIndex < graph.from.length; edgeIndex++) {
                    int fromVertex = graph.from[edgeIndex];
                    int toVertex = graph.to[edgeIndex];
                    long edgeWeight = graph.w[edgeIndex];

                    if (distances[fromVertex] != Graph.INF
                            && distances[fromVertex] + edgeWeight < distances[toVertex]) {

                        distances[toVertex] = distances[fromVertex] + edgeWeight;
                        updated = true;
                    }
                }

                if (!updated) {
                    break;
                }
            }
        }

        return shortestDistances;
    }
}
