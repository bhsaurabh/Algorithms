public class HeightWeightedQuickUnionUF {
    /* Union Find implementation that makes sub-trees based on height */

    private int[] id;
    private int[] ht;

    public HeightWeightedQuickUnionUF(int N) {
        /* Constructor: Initialise all data members */
        this.id = new int[N];
        this.ht = new int[N];

        // every element is in its own connected component
        for (int i = 0; i < N; i++) {
            id[i] = i;
            ht[i] = 1;
        }
    }

    private int root(int i) {
        /* Helper: Return the root of element i */
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression for flatter trees
            i = id[i];
            // path compression changes tree heights
            ht[i] -= 1;
        }
        return i;
    }       

    public boolean connected(int p, int q) {
        /* API: Are p and q connected? */
        // connected iff roots of p and q are same
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        /* API: Connect p and q if NOT connected */
        // get roots
        int pRoot = root(p);
        int qRoot = root(q);

        // return if they are connected already (Use roots to avoid re-computation)
        if (connected(pRoot, qRoot))    return;

        // connect based on heights of trees
        // Heights can increase only to ht(smaller tree) + 1
        if (ht[pRoot] < ht[qRoot]) {
            // make pRoot point to qRoot
            id[pRoot] = qRoot;
            if (ht[pRoot] + 1 > ht[qRoot])
                ht[qRoot] = ht[pRoot] + 1;
        }
        else {
            id[qRoot] = pRoot;
            if (ht[qRoot] + 1 > ht[pRoot])
                ht[pRoot] = ht[qRoot] + 1;
        }
    }
}
