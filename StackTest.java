import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StackTest
{
    private StackLL<String> stack;
    private Scanner sc;
    
    public StackTest()
    {
        try
        {
            this.sc = new Scanner(new File("stack_data.txt"));
        }
        catch (FileNotFoundException e)
        {
            this.sc = new Scanner(System.in);
        }
        stack = new StackLL<String>();
    }
    
    public void test()
    {
        while (sc.hasNext())
        {
            String str = sc.next();
            if (str.equals("-"))
                System.out.println(">>> " + stack.pop());
            else
                stack.push(str);
        }
    }
    
    public void testIteration()
    {
        while (sc.hasNext())
        {
            String str = sc.next();
            stack.push(str);
        }
        System.out.println("Iterating...");
        for (String item : stack)
            System.out.println("-> " + item);
    }
    
    public static void main(String[] args)
    {
        StackTest stest = new StackTest();
        stest.testIteration();
    }
}