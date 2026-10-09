package lab04.mts;

import lab04.Edge;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Kruskal implements MSTAlgorithm {
    @Override
    public List<Edge> findMST(MSTGraph graph) {
        List<Edge> sortedEdges = new ArrayList<>(graph.edges());
        sortedEdges.sort(Comparator.comparingInt(Edge::weight));
        List<Edge> mst = new ArrayList<>();
        DSU dsu = new DSU(graph.vertices());
        for (Edge edge : sortedEdges) {
            if (dsu.union(edge.from(), edge.to())) {
                mst.add(edge);
            }
            if (mst.size() == graph.vertices() - 1) {
                break;
            }
        }

        return mst;
    }

    private static class DSU {
        private final int[] parent;
        private final int[] rank;

        DSU(int vertices) {
            parent = new int[vertices];
            rank = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
        }
    }
}
