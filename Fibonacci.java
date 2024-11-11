
import java.util.*;
class Fibonacci {

    //  Write a program non-recursive and recursive program to calculate Fibonacci numbers and 
    // analyze their time and space complexity. 

    static void non_recursive(int n)
    {
        int fib1=0;
        int fib2=1;

        System.out.print(fib1+" ");
        System.out.print(fib2+" ");

        for(int i=2;i<n;i++)
        {
            int fib3=fib1+fib2;
            System.out.print(fib3+" ");
            fib1=fib2;
            fib2=fib3;
        }

    }

    static int recursive(int n)
    {
       
        if(n==0 || n==1)
            return n;

        return recursive(n-1)+recursive(n-2);

    }
    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of N :");
        int n=sc.nextInt();
        System.out.println("Nth Fibonacci Series upto "+n+" using Non recursive approach is :");
        non_recursive(n);

        System.out.println();

        System.out.println("Nth Fibonacci Series upto "+n+" using Recursive approach is :");
      
        for(int i=0;i<n;i++)
        {
            System.out.print(recursive(i)+" ");
        }
        
    }
}
