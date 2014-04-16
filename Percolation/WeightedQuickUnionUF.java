public class WeightedQuickUnionUF {
    /* A union find data structure to avoid long trees */

    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        /* Constructor */
        this.id = new int[N];
        this.sz = new int[N];

        // every node is in its own connected component
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;  // connected component has only the element
        }
    }

    public void union(int p, int q) {
        /* API methhod: Connect component containing p
         * with component containing q */

        // Get roots of connected components
        int pRoot = root(p);
        int qRoot = root(q);

        // Make smaller CC a child of the larger CC
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
    
    public boolean connected(int p, int q) {
        /* API method: Are p and q in the same component? */

        // connected iff they have the same roots
        return root(p) == root(q);
    }

    private int root(int k) {
        /* Helper: Returns the root of the component containing k */
        while (k != id[k]) {
            id[k] = id[id[k]];  // path compression
            k = id[k];
        }
        return k;
    }

}
