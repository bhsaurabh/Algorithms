public class QuickFindUF
{
    // data structure is an integer array
    private int[] id;
    private int N;
    
    public QuickFindUF(int N)
    {
        // O(N)
        id = new int[N];
        this.N = N;
        
        // each element is in its own connected component
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    public boolean connected(int p, int q)
    {
        // O(1)
        assert (p < N && q < N && p > 0 && q > 0);
        return id[p] == id[q];
    }
    
    public void union(int p, int q)
    {
        // O(N)
        assert (p < N && q < N && p > 0 && q > 0);
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < N; i++)
            if (id[i] == pid)
                id[i] = qid;
    }
}