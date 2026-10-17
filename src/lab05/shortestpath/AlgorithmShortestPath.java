package lab05.shortestpath;

import lab05.graph.Graph;

public interface AlgorithmShortestPath {

    String name();

    long[][] run(Graph graph);
}
