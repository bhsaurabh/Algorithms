public class CanonicalUF {
    /* Add method find() to get maximum element in a CC */

    private int[] id;
    private int[] sz;
    private int[] max;

    public CanonicalUF(int N) {
        /* Constructor to initialise object */
        this.id = new int[N];
        this.sz = new int[N];
        this.max = new int[N];

        // initially every element is in its own connected component
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
        }
    }

    public void union(int p, int q) { 
        /* API: Connect p and q and their CC */
        int pRoot = root(p);
        int qRoot = root(q);

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
            if (max[qRoot] < max[pRoot])    max[qRoot] = max[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
            if (max[pRoot] < max[qRoot])    max[pRoot] = max[qRoot];
        }
    }

    public boolean connected(int p, int q) {
        /* API: Are p and q connected? */
        return root(p) == root(q);
    }

    private int root(int i) {
        /* Return root of element i */
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression
            i = id[i];
        }
        return i;
    }

    public int find(int i) {
        /* Get maximum element in a connected component */
        // get root element
        int iRoot = root(i);
        // query array storing maximums
        return max[iRoot];
    }
}
