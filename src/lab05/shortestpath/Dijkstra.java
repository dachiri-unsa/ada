package lab05.shortestpath;

import lab05.graph.Graph;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra implements AlgorithmShortestPath {
    public String name() { return "Dijkstra"; }

    public long[][] run(Graph graph) {
        long[][] shortestDistances = new long[graph.n][graph.n];

        for (int s = 0; s < graph.n; s++) {
            long[] distances = shortestDistances[s];
            Arrays.fill(distances, Graph.INF);
            distances[s] = 0;

            PriorityQueue<long[]> pq = new PriorityQueue<>(
                    (first, second) -> Long.compare(first[0], second[0])
            );
            pq.add(new long[]{0, s});

            while (!pq.isEmpty()) {
                long[] currentEntry = pq.poll();

                long currentDistance = currentEntry[0];
                int currentVertex = (int) currentEntry[1];

                if (currentDistance > distances[currentVertex]) {
                    continue;
                }

                for (int[] edge : graph.adj[currentVertex]) {
                    int neighbor = edge[0];
                    long edgeWeight = edge[1];
                    long newDistance = distances[currentVertex] + edgeWeight;

                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;

                        pq.add(new long[]{newDistance, neighbor});
                    }
                }
            }
        }

        return shortestDistances;
    }
}
