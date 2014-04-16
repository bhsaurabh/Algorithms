public class KosarajuSharirSCC {
    /* Find strongly connected components in a Digraph */
    private boolean[] marked;
    private int[] id;
    private int count;

    /* Constructor */
    public KosarajuSharirSCC(Digraph G) {
        // initialise all data members
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        this.count = 0;

        // Phase 1: Perform topological sort on reverse graph
        DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
        
        // Phase 2: Perform DFS using reverse topological order on reverse graph
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /* Recursive Depth first search implementation */
    private void dfs(Digraph G, int v) {
        // mark current vertex
        marked[v] = true;
        id[v] = count;
        // traverse all unmarked adjacent vertices
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }

    /* API: Are vertices v and w strongly connected? */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
}
