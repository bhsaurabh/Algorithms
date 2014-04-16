public class DirectedDFS {
    // mark all vertices that have been visited
    private boolean[] marked;
    // maintain how we 1st reached a vertex
    private int[] edgeTo;
    // source vertex
    private int s;

    /* Constructor */
    public DirectedDFS(Digraph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];

        dfs(G, s);
    }

    /* Recursive depth-first search method */
    private void dfs(Digraph G, int v) {
        marked[v] = true;   // has been visited
        for (int w : G.adj(v)) {
            // visit every unmarked vertex adjacent to v
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    /* API: Is vertex v connected to s? */
    public boolean hasPathTo(int v) {
        // O(1)
        return marked[v];
    }

    /* API: Return an iterable having the path from s to v */
    public Iterable<Integer> pathTo(int v) {
        // O(N)
        // if no path return null
        if (!hasPathTo(v))  return null;
        // Stack is an iterable!
        Stack<Integer> path = new Stack<Integer>();
        while (v != s) {
            path.push(v);
            v = edgeTo[v];
        }
        path.push(s);   // push source vertex
        return path;
    }
}
