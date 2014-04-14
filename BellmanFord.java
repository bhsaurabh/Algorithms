public class BellmanFord {
    /* Find Shortest Path Tree with negative weights on edges
     * No negative weight cycles though */

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public BellmanFord(EdgeWeightedGraph G, int s) {
        this.distTo = new double[G.V()];
        this.edgeTo = new DirectedEdge[G.V()];

        // initialise distances
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // repeat V times...relax all edges
        for (int v = 0; v < G.V(); v++)
            for (DirectedEdge e : G.edges())
                relax(e);
    }

    /* Helper: Relax a directed edge */
    private void relax(DirectedEdge e) {
        // get vertices
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
}
