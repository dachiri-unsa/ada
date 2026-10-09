package lab04.mts;

import lab04.Edge;

import java.util.List;

public record MSTResult(
        List<Edge> edges,
        long timeNanos
) {}
