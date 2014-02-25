import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnionFindTest
{
    // Test client for Union find
    private WeightedQuickUnionUF uf;
    private Scanner sc;
    private int T;  // number of test cases
    
    public UnionFindTest()
    {
        try
        {
            this.sc = new Scanner(new File("uf_data.txt"));
        }
        catch (FileNotFoundException e)
        {
            this.sc = new Scanner(System.in);
        }
        this.T = sc.nextInt(); 
        this.uf = new WeightedQuickUnionUF(this.T);
    }
    
    public void test()
    {
        for (int i = 0; i < T; i++)
        {
            int p = sc.nextInt(), q = sc.nextInt();
            if (!uf.connected(p, q))
            {
                System.out.println("Connecting " + p + " and " + q);
                uf.union(p, q);
            }
            else
                System.out.println(p + " and " + q + " already connected");
        }
    }
    
    public static void main(String[] args)
    {
        UnionFindTest ufTest = new UnionFindTest();
        ufTest.test();
    }
}