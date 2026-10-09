package lab04;

import lab04.mts.*;

import java.util.List;

public class Main {

    private static final int NUMERO_VERTICES = 10;
    private static final int REPETICIONES = 20;

    public static void main(String[] args) {
        MSTGraph grafo = GraphGenerator.generateGraph(NUMERO_VERTICES);

        MSTTimer timer = new MSTTimer();

        mostrarResultado("Kruskal", timer.measure(new Kruskal(), grafo, REPETICIONES));
        mostrarResultado("Prim", timer.measure(new Prim(), grafo, REPETICIONES));
    }

    public static void mostrarResultado(String nombre, MSTResult resultado) {
        System.out.println("Algoritmo: " + nombre);
        System.out.println("Aristas del MST: " + resultado.edges().size());
        System.out.println("Peso total: " + pesoTotal(resultado.edges()));
        System.out.println("Tiempo en nanosegundos: " + resultado.timeNanos());
        System.out.println("Tiempo en milisegundos: " +
                        resultado.timeNanos() / 1_000_000.0
        );
        System.out.println();
    }

    public static int pesoTotal(List<Edge> edges) {
        int total = 0;

        for (Edge edge : edges) {
            total += edge.weight();
        }

        return total;
    }
}
