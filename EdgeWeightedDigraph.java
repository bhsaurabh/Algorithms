public class EdgeWeightedDigraph {
    /* An implementation of the EdgeWeightedDigraph */

    private final int V;    // number of vertices
    private int E;    // number of edges 
    private final Bag<DirectedEdge>[] adj;  // an array of bag (of edges)

    /* Constructor */
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        // initialise graph array
        this.adj = (Bag<DirectedEdge>[]) new Bag[V];
        // initialise every bag
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<DirectedEdge>();
    }

    /* API: Add an edge to the graph */
    public void addEdge(DirectedEdge e) {
        // get vertices to add edge between
        int v = e.from();
        adj[v].add(e);
        E += 1;
    }

    /* API: Iterate through all edges adjacent to a vertex */
    public Iterable<DirectedEdge> adj(int v) {
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
    public Iterable<DirectedEdge> edges() {
        // If repeat is true, count all edges twice as this is an undirected graph
        Bag<DirectedEdge> edges = new Bag<DirectedEdge>();
        for (int i = 0; i < this.V; i++) 
            for (DirectedEdge e : adj[i]) 
                    edges.add(e);
        return edges;
    }

    /* Get a string representation of the graph */
    public String toString() {
        StringBuilder graph = new StringBuilder();
        for (DirectedEdge e : edges())
            graph.append(e.toString() + "\n");
        return graph.toString();
    }
}
