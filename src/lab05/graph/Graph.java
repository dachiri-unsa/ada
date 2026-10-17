package lab05.graph;
import java.util.*;


public class Graph {

    public static final long INF = Long.MAX_VALUE / 4;
    public final int n;
    public final int[] from, to, w;  // lista de aristas  -> Bellman-Ford
    public final List<int[]>[] adj;  // lista de adyacencia -> Dijkstra
    public final long[][] matrix;   // matriz de adyacencia -> Floyd-Warshall

    @SuppressWarnings("unchecked")
    public Graph(int n, int[] from, int[] to, int[] w) {
        this.n = n; this.from = from; this.to = to; this.w = w;

        adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        matrix = new long[n][n];
        for (long[] row : matrix)
            Arrays.fill(row, INF);
        for (int i = 0; i < n; i++)
            matrix[i][i] = 0;

        for (int e = 0; e < from.length; e++) {
            adj[from[e]].add(new int[]{to[e], w[e]});
            matrix[from[e]][to[e]] = Math.min(matrix[from[e]][to[e]], w[e]);
        }
    }

    public static Graph random(int vertexCount, int edgeCount, long seed) {
        Random random = new Random(seed);

        int[] from = new int[edgeCount];
        int[] to = new int[edgeCount];
        int[] w = new int[edgeCount];

        for (int e = 0; e < edgeCount; e++) {
            if (e < vertexCount) {
                from[e] = e;
                to[e] = (e + 1) % vertexCount;
            } else {
                from[e] = random.nextInt(vertexCount);
                to[e] = random.nextInt(vertexCount);
            }

            w[e] = 1 + random.nextInt(100);
        }

        return new Graph(vertexCount, from, to, w);
    }

}
