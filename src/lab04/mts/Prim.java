package lab04.mts;

import lab04.Edge;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim implements MSTAlgorithm {
    @Override
    public List<Edge> findMST(MSTGraph graph) {
        int vertices = graph.vertices();
        List<Edge> mst = new ArrayList<>();

        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>
                (Comparator.comparingInt(Edge::weight));

        visited[0] = true;
        pq.addAll(graph.adjacency().get(0));

        while (!pq.isEmpty() && mst.size() < vertices - 1) {
            Edge edge = pq.poll();

            if (visited[edge.to()]) continue;

            visited[edge.to()] = true;
            mst.add(edge);

            for (Edge next : graph.adjacency().get(edge.to())) {
                if (!visited[next.to()]) {
                    pq.add(next);
                }
            }
        }
        return mst;
    }
}
