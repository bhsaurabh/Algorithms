import java.util.Scanner;

public class GraphClient implements Runnable {
    private Scanner sc;

    public GraphClient() {
        sc = new Scanner(System.in);
    }
    
    /* Application entry point */
    public static void main(String[] args) {
        GraphClient obj = new GraphClient();
        obj.run();
    }

    /* Abstract method to override */
    public void run() {
        int V = sc.nextInt();
        // create a graph
        Graph G = new Graph(V);

        while (sc.hasNextInt()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            // connect p and q
            G.addEdge(p, q);
        }
    }

    /* Return the degree of vertex v */
    public int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v))  degree++;
        return degree;
    }

    /* Return the maximum degree in the graph */
    public int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            int d = degree(G, v);
            if (d > max)    max = d;
        }
        return max;
    }

    /* Return the average degree of the graph */
    public int averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /* Return the number of self loops */
    public int numberOfSelfLoops(Graph G) {
        int count = 0;
        // loop over adjacency list of every vertex
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v))
                if (w == v) count++;
        }
        return count / 2;   // undirected graph API
    }
}
