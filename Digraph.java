public class Digraph {
    // Directed Graph parameter: Number of vertices
    private int V;
    // Directed Graph parameter: Number of edges
    private int E;
    // Array to store adjacency list for every vertex
    private Bag<Integer>[] adj;

    /* Constructor */
    public Digraph(int V) {
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

    /* API: Return a reversed Directed graph */
    public Digraph reverse() {
        Digraph rev = new Digraph(V);
        for (int v = 0; v < G.V(); v++) {
            // for every edge v->w add w->v in rev
            for (int w : G.adj(v))
                rev.addEdge(w, v);
        }
        // return the reversed directed graph
        return rev;
    }
}
