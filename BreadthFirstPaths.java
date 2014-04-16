public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;

    /* Constructor */
    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        bfs(G, s);
    }

    /* Non-recursive method for breadth first search */
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(s);
        marked[s] = true;

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    /* API: Is there a path from s to v?? */
    public boolean hasPathTo(int v) {   return marked[v];   }

    /* API: Return shortest path from s to v */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))  return null;
        Stack<Integer> path = new Stack<Integer>();

        while (v != s) {
            path.push(v);
            v = edgeTo[v];
        }
        path.push(s);

        return path;
    }
}
