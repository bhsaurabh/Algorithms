public class SuccessorWithDelete {
    private CanonicalUF uf; // Union-Find data structure capable of getting max in a connected component

    public SuccessorWithDelete(int N) {
        /* Constructor: Initialise data members */
        this.uf = new CanonicalUF(N+1); // N+1 handles last element

        // Initially every element is in its own CC
        // That is fine as x >= x here
    }

    public void remove(int x) {
        /* API: Remove element x from set S */
        // connect this element to the next element (which is bigger)
        uf.union(x, x+1);
    }

    public int successor(int x) {
        /* API: Get y, such that y is in S and y >= x */
        int y = uf.find(x); // get max element
        // check if y is N, as N is out of range
        if (y == N)
            y = -1;
        return y;   // -1 indicates no element in S >= x
    }
}
