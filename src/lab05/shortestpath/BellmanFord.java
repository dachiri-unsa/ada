package lab05.shortestpath;

import lab05.graph.Graph;
import java.util.Arrays;

public class BellmanFord implements AlgorithmShortestPath {
    public String name() { return "Bellman-Ford"; }

    public long[][] run(Graph g) {
        long[][] res = new long[g.n][g.n];
        for (int s = 0; s < g.n; s++) {
            long[] d = res[s];
            Arrays.fill(d, Graph.INF);
            d[s] = 0;
            for (int i = 0; i < g.n - 1; i++) {
                boolean changed = false;
                for (int e = 0; e < g.from.length; e++) {
                    if (d[g.from[e]] != Graph.INF && d[g.from[e]] + g.w[e] < d[g.to[e]]) {
                        d[g.to[e]] = d[g.from[e]] + g.w[e];
                        changed = true;
                    }
                }
                if (!changed) break;
            }
        }
        return res;
    }
}
