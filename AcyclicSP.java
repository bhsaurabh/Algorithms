public class AcyclicSP {
    /* Get shortest path in an edge weighted digraph */

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    /* Constructor */
    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        // initialise arrays
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];

        // initialise all initial distances to infinity
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // consider all vertices in topologically sorted order
        Topological topological = new Topological(G);
        for (int v : topological.order())
            for (DirectedEdge e : G.adj(v))
                relax(e);
    }

    /* Helper: Relax a DirectedEdge */
    private void relax(DirectedEdge e) {
        // get vertices
        int v = e.from(), w = e.to();
        // relax
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
}
