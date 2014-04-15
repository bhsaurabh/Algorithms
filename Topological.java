public class Topological {
    /* An implementation of topological sort for
     * Edge weighted DAGs */

    private boolean[] marked;
    private Stack<Integer> reversePost;

    /* Constructor */
    public Topological(EdgeWeightedDigraph G) {
        // initialise arrays
        this.marked = new boolean[G.V()];
        this.reversePost = new Stack<Integer>();

        // perform DFS over all vertices
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    /* Recursive Depth First Search method */
    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        // visit all adjacent unmarked vertices
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
        // once done with this vertex, push on stack
        reversePost.push(v);
    }

    /* API: Return topological sort order */
    public Iterable<Integer> order() {
        return reversePost;
    }
}
