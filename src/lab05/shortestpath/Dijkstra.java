package lab05.shortestpath;

import lab05.graph.Graph;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra implements AlgorithmShortestPath {
    public String name() { return "Dijkstra"; }

    public long[][] run(Graph g) {
        long[][] res = new long[g.n][g.n];
        for (int s = 0; s < g.n; s++) {
            long[] d = res[s];
            Arrays.fill(d, Graph.INF);
            d[s] = 0;
            PriorityQueue<long[]> pq = new PriorityQueue<>(
                    (a, b) -> Long.compare(a[0], b[0])
            );
            pq.add(new long[]{0, s});
            while (!pq.isEmpty()) {
                long[] top = pq.poll();
                int u = (int) top[1];
                if (top[0] > d[u]) continue;
                for (int[] e : g.adj[u]) {
                    long nd = d[u] + e[1];
                    if (nd < d[e[0]]) { d[e[0]] = nd; pq.add(new long[]{nd, e[0]}); }
                }
            }
        }
        return res;
    }
}
