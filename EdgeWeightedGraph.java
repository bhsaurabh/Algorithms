public class EdgeWeightedGraph {
    /* An implementation of the EdgeWeightedGraph */

    private final int V;    // number of vertices
    private int E;    // number of edges 
    private final Bag<Edge>[] adj;  // an array of bag (of edges)

    /* Constructor */
    public EdgeWeightedGraph(int V) {
        this.V = V;
        // initialise graph array
        this.adj = (Bag<Edge>[]) new Bag[V];
        // initialise every bag
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Edge>();
    }

    /* API: Add an edge to the graph */
    public void addEdge(Edge e) {
        // get vertices to add edge between
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E += 1;
    }

    /* API: Iterate through all edges adjacent to a vertex */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /* API: Get number of vertices */
    public int V() {
        return this.V;
    }

    /* API: Get number of edges */
    public int E() {
        return this.E;
    }

    /* API: Get all edges in graph */
    public Iterable<Edge> edges(boolean repeat) {
        // If repeat is true, count all edges twice as this is an undirected graph
        Bag<Edge> edges = new Bag<Edge>();
        for (int i = 0; i < this.V; i++) 
            for (Edge e : adj[i]) 
                if (repeat) edges.add(e);
                else {
                    // get other vertex
                    int other = e.other(i);
                    // ignore this edge if other < i as this edge is already added there
                    if (other > i)  edges.add(e);
                }
        return edges;
    }
}
