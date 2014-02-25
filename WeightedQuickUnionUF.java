public class WeightedQuickUnionUF
{
    private int[] id;
    private int[] sz;
    private int N;
    
    public WeightedQuickUnionUF(int N)
    {
        this.id = new int[N];
        this.sz = new int[N];
        this.N = N;
        
        // every element in its connected component
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }
    
    private int root(int i)
    {
        while (i != id[i])
        {
            id[i] = id[id[i]];  // path compression...flatter trees
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        int p_root = root(p);
        int q_root = root(q);
        if (connected(p_root, q_root))  return;
        
        // make smaller tree the sub-tree of larger tree
        if (sz[p_root] < sz[q_root])
        {
            id[p_root] = q_root;
            sz[q_root] += sz[p_root];
        }
        else
        {
            id[q_root] = p_root;
            sz[p_root] += sz[q_root];
        }
    }
}