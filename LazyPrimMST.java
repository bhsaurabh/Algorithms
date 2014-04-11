public class LazyPrimMST {
    /* Compute the MST of an EWG using Prim's algorithm */

    /* Instance variables */
    private boolean[] marked;   
    // no need for a UF data structure...tree is built continuously...not in discrete steps
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    /* Constructor */
    public LazyPrimMST(EdgeWeightedGraph G) {
        this.marked = new boolean[G.V()];
        this.mst = new Queue<Edge>();
        this.pq = new MinPQ<Edge>();

        // Start with vertex 0
        visit(G, 0);

        while (!pq.isEmpty() && mst.size() < G.V()-1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);

            // disregard edge if already on MST
            if (marked[v] && marked[w]) continue;

            mst.enqueue(e);
            if (!marked[v])  visit(G, v);
            if (!marked[w])  visit(G, w);
        }
    }

    /* Visit vertex v and add adjacent edges not in MST to PQ */
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)])
                pq.insert(e);
    }

    /* API: Iterate through all edges of the MST */
    public Iterable<Edge> edges() {
        return mst;
    }
}
