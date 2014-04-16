public class KruskalMST {
    /* Builds a MST from an EWG using Kruskal's algorithm */

    // represent the MST as a queue
    private Queue<Edge> mst;

    /* Constructor */
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();

        // Step 1: Get edges in orger of weights (use a priority queue)
        MinPQ<Edge> pq = new MinPQ<Edge>();
        // add edges to the priority queue
        for (Edge e : G.edges(false))
            pq.insert(e);

        // Step 2: Add edges to the MST in order, if they do not create a cycle
        // Check for cycles using the Union Find data structure
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        while (!pq.isEmpty && mst.size() < (G.V()-1)) {
            // get edge with minimum weight in the PQ
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);

            if (!uf.connected(v, w)) { // cycle is not created 
                uf.union(v, w);
                mst.enqueue(e);
            }
        }
    }

    /* API: Get all edges in the MST */
    public Iterable<Edge> edges() {
        return mst;
    }
}
