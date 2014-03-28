public class Graph {
    // Graph parameter: Number of vertices
    private int V;
    // Graph parameter: Number of edges
    private int E;
    // Array to store adjacency list for every vertex
    private Bag<Integer>[] adj;

    /* Constructor */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        // empty array of V bags for V vertices
        this.adj = (Bag<Integer>[]) new Bag[V];
        // initialise bags
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    /* API: Add an edge to the graph */
    public void addEdge(int v, int w) {
        // add w to v's adjacency list
        adj[v].add(w);
        // add v to w's adjacency list
        adj[w].add(v);
        E++;
    }

    /* API: Return an iterable to adjacency list of vertex v */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /* API: Return number of vertices in graph */
    public int V() { return V; }
    
    /* API: Return number of edges in graph */
    public int E() { return E; }
}
