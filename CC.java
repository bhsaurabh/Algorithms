public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    /* Constructor */
    public CC(Graph G) {
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        this.count = 0;

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /* Recursive routine for depth-first search */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    /* API: Return number of connected components */
    public int count() {    return count;   }

    /* API: Return ID of connected component to which an element belongs */
    public int id(int v) {  return id[v];   }

    /* API: Are v and w connected? */
    public boolean connected(int v, int w) {    return id[v] == id[w];  }
    
}
