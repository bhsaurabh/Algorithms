public class AcyclicLP {
    /* Find the longest path in an Edge weighted DAG */

    public AcyclicLP(EdgeWeightedDigraph G, int s) {
        // negate all weights in the graph
        EdgeWeightedDigraph G2 = new EdgeWeightedDigraph(G.V());
        for (DirectedEdge e : G.edges()) {
            DirectedEdge e2 = new DirectedEdge(e.from(), e.to(), -1 * e.weight());
            G2.addEdge(e2);
        }

        // now run shortest path algorithm on new graph
        AcyclicSP sp = new AcyclicSP(G2, s);
    }

    // implement API in AcyclicSP.java and call it here
}
