package lab05;

import lab05.graph.Graph;
import lab05.shortestpath.*;

import java.util.*;

public class Main {
    static final int WARMUP = 3, RUNS = 7;

    public static void main(String[] args) {
        List<AlgorithmShortestPath> algos = List.of(new Dijkstra(), new BellmanFord(), new FloydWarshall());

        for (int n : new int[]{100, 200, 400, 800}) {
            for (int perVertex : new int[]{5, 20}) {
                Graph g = Graph.random(n, n * perVertex, 42);
                System.out.printf("V=%d E=%d%n", n, g.from.length);

                long[][] ref = algos.get(0).run(g);
                for (AlgorithmShortestPath a : algos)
                    if (!Arrays.deepEquals(ref, a.run(g))) throw new IllegalStateException(a.name() + " difiere");

                for (AlgorithmShortestPath a : algos) {
                    for (int i = 0; i < WARMUP; i++) a.run(g);
                    double[] t = new double[RUNS];
                    for (int i = 0; i < RUNS; i++) {
                        long t0 = System.nanoTime();
                        long[][] r = a.run(g);
                        t[i] = (System.nanoTime() - t0) / 1e6;
                    }
                    Arrays.sort(t);
                    System.out.printf("  %-15s mediana %8.2f ms%n", a.name(), t[RUNS / 2]);
                }
            }
        }
    }
}
