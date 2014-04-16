public class DepthFirstOrder {
    /* Topological sorting a Directed Acyclic Graph */
    private boolean[] marked;   // Keep track of which vertices have been visited
    private Stack<Integer> reversePost; // store reverse post order

    /* Constructor */
    public DepthFirstOrder(Digraph G) {
        this.marked = new boolean[G.V()];
        this.reversePost = new Stack<Integer>();

        // perform DFS over all vertices
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    /* Recursive Depth First Search Method */
    private void dfs(Digraph G, int v) {
        // vertex v has now been visited
        marked[v] = true;
        // visit all adjacent unmarked vertices
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
        // once done with this vertex push onto reversePost
        reversePost.push(v);
    }

    /* API: Return the topological sort order */
    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
