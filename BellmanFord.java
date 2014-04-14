public class BellmanFord {
    /* Find Shortest Path Tree with negative weights on edges
     * No negative weight cycles though */

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean hasNegativeCycle;

    public BellmanFord(EdgeWeightedGraph G, int s) {
        this.distTo = new double[G.V()];
        this.edgeTo = new DirectedEdge[G.V()];
        this.hasNegativeCycle = false;

        // initialise distances
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // repeat V times...relax all edges
        for (int v = 0; v < G.V(); v++) {
            boolean temp = false;
            for (DirectedEdge e : G.edges())
                temp |= relax(e);
            if (temp && v == G.V()-1)   hasNegativeCycle = true;
        }
    }

    /* Helper: Relax a directed edge */
    private boolean relax(DirectedEdge e) {
        // get vertices
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            return true;
        }
        return false;
    }

    /* Negative Cycles: If there is an update to distTo made in last iteration
     * There exists a negative cycle. Use edgeTo[v] to trace cycle */
    public boolean hasNegativeCycle() {
        return hasNegativeCycle;
    }
}
