public class DijkstraSP {
    /* Find the shortest path from a source vertex to all
     * other vertices in an Edge weighted Digraph */

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    /* Constructor */
    public void DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        this.pq = new IndexMinPQ<Double>(G.V());

        // initialise initial distances 
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        // PQ takes care of taking vertices in order of distance
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            // relax all outgoing edges from v
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }
    }

    /* Helper: Relax an edge */
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
            // update the changes in the PQ also
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else    pq.insert(w, distTo[w]);
        }
    }
}
