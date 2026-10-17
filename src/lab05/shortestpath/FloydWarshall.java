package lab05.shortestpath;

import lab05.graph.Graph;

public class FloydWarshall implements AlgorithmShortestPath {
    public String name() { return "Floyd-Warshall"; }

    public long[][] run(Graph g) {
        int n = g.n;
        long[][] d = new long[n][];
        for (int i = 0; i < n; i++) d[i] = g.matrix[i].clone();
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++) {
                if (d[i][k] == Graph.INF) continue;
                for (int j = 0; j < n; j++)
                    if (d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
            }
        return d;
    }
}
