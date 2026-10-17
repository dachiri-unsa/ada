package lab05.shortestpath;

import lab05.graph.Graph;

public class FloydWarshall implements AlgorithmShortestPath {
    public String name() { return "Floyd-Warshall"; }

    public long[][] run(Graph graph) {
        int vertexCount = graph.n;
        long[][] shortestDistances = new long[vertexCount][];

        for (int s = 0; s < vertexCount; s++) {
            shortestDistances[s] = graph.matrix[s].clone();
        }

        for (int intermediate = 0; intermediate < vertexCount; intermediate++) {
            for (int source = 0; source < vertexCount; source++) {
                if (shortestDistances[source][intermediate] == Graph.INF) {
                    continue;
                }

                for (int destination = 0; destination < vertexCount; destination++) {
                    long distanceThroughIntermediate =
                            shortestDistances[source][intermediate]
                                    + shortestDistances[intermediate][destination];

                    if (distanceThroughIntermediate < shortestDistances[source][destination]) {
                        shortestDistances[source][destination] = distanceThroughIntermediate;
                    }
                }
            }
        }

        return shortestDistances;
    }
}
