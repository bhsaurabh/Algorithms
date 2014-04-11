public class Edge implements Comparable<Edge> {
    /* A weighted edge */

    /* Instance variables */
    private int v, w;   // vertices
    private double weight;  //weight of edge

    /* Constructor */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /* API: Get a vertex from the edge */
    public int either() {
        return v;
    }

    /* API: Get the second vertex */
    public int other(int v) {
        if (v == this.v)    return this.w;
        else    return this.v;
    }

    /* Used for comparing edges */
    public int compareTo(Edge that) {
        // compare based on weights
        if (this.weight > that.weight)  return +1;
        else if (this.weight < that.weight) return -1;
        else    return 0;
    }

    /* API: Get the weight of the edge */
    public double weight() {
        return this.weight;
    }

    /* String representation of the edge */
    public String toString() {
        String edge = v + " -> " + w;
        return edge;
    }
}
