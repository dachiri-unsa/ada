package lab04.mts;

import lab04.Edge;
import java.util.List;

public class MSTTimer {
    public MSTResult measure(MSTAlgorithm algorithm, MSTGraph graph) {
        return measure(algorithm, graph, 1);
    }

    public MSTResult measure(MSTAlgorithm algorithm, MSTGraph graph, int repeticiones) {
        for (int i = 0; i < repeticiones; i++) {
            algorithm.findMST(graph);
        }

        long mejor = Long.MAX_VALUE;
        List<Edge> mst = null;

        for (int i = 0; i < repeticiones; i++) {

            long inicio = System.nanoTime();
            List<Edge> resultado = algorithm.findMST(graph);
            long fin = System.nanoTime();

            if (fin - inicio < mejor) {
                mejor = fin - inicio;
                mst = resultado;
            }
        }

        return new MSTResult(mst, mejor);
    }
}
