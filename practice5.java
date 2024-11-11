import java.util.*;
public class practice5
{
    public static void printCode(HuffmanNode root ,String s)
    {
        if(root.left==null && root.right==null)
        {
            System.out.println("Character: " + root.c + ", Code: " + s);
            System.out.println("Frequency: " + root.data);
            return;
        }
        
        System.out.println("Internal Node Frequency: " + root.data);
        printCode(root.left,s+"0");
        printCode(root.right,s+"1");
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the total no of characters ");
        int n=sc.nextInt();

        char[] chararray=new char[n];
        int [] freq=new int[n];

        System.out.println("Enter the character and their frequency ");
        for(int i=0;i<n;i++)
        {
            chararray[i]=sc.next().charAt(0);
            freq[i]=sc.nextInt();
        }

        PriorityQueue <HuffmanNode> q=new PriorityQueue<HuffmanNode>(n,new MyComparator());

        for(int i=0;i<n;i++)
        {
            HuffmanNode hnn=new HuffmanNode();
            hnn.c=chararray[i];
            hnn.data=freq[i];
            hnn.left=null;
            hnn.right=null;

            q.add(hnn);
        }
          

        HuffmanNode root=null;

        while(q.size()>1)
        {
            HuffmanNode x= q.peek();
            q.poll();
            HuffmanNode y= q.peek();
            q.poll();
            HuffmanNode f=new HuffmanNode();
            f.data=x.data+y.data;
            f.c='-';
            f.left=x;
            f.right=y;
            root=f;
            q.add(f);
            
        }
        
        System.out.println("Printing Huffman codes");
        printCode(root,"");
        

    }
}

class HuffmanNode{
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>
{
    public int compare(HuffmanNode x,HuffmanNode y)
    {
        return x.data-y.data;
    }
}