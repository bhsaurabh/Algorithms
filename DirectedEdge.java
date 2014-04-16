public class DirectedEdge {
    /* A directed edge for an edge weighted digraph */

    private final int v, w;
    private final double weight;

    /* Constructor */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /* API: Source of edge */
    public int from() {
        return this.v;
    }

    /* API: Destination of edge */
    public int to() {
        return this.w;
    }

    /* API: Get edge weight */
    public double weight() {
        return this.weight;
    }

    /* Used when printing this edge */
    public String toString() {
        return (v + " -> " + w);
    }
}
