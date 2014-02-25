public class QuickUnionUF
{
    // data structure would be an int array
    private int[] id;
    private int N;
    
    public QuickUnionUF(int N)
    {
        id = new int[N];
        this.N = N;
        
        // put every element in its own connected component
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    // id[i] is root of i if id[i] == i
    private int root(int i)
    {
        // O(N) in worst case
        while (i != id[i])
            i = id[i];
        return i;
    }
    
    public boolean connected(int p, int q)
    {
        // O(N)
        // p & q in same component if root is same
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        // O(N)
        // make root of p sub-tree of q
        int p_root = root(p);
        int q_root = root(q);
        id[p_root] = q_root;
    }
}