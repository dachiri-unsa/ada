package lab03.ejercicio04.sort;

import java.time.Duration;

public class SortTimer {
    public long measure(SortAlgorithm algorithm, int[] datos) {
        long inicio = System.nanoTime();
        algorithm.sort(datos);
        long fin = System.nanoTime();

        Duration duration = Duration.ofNanos(fin - inicio);
        return duration.toMillis();
    }
}
