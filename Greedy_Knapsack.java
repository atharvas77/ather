import java.util.*;
public class Greedy_Knapsack
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the capacity of knapsack");
        int w=sc.nextInt();
        System.out.println("Enter the total no of items");
        int n=sc.nextInt();

        int value[]=new int[n];
        int weight[]=new int[n];

        System.out.println("Enter the value and weight of each items");
        for(int i=0;i<n;i++)
        {
            value[i]=sc.nextInt();
            weight[i]=sc.nextInt();
        }

        double ratio[][]=new double[n][2];

        for(int i=0;i<n;i++)
        {
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));

        int capacity=w;
        int Final=0;
        for(int i=ratio.length-1;i>=0;i--)
        {
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx])
            {
                Final=Final+value[idx];
                capacity=capacity-weight[idx];
            }
            else
            {
                Final=Final+capacity* (int)ratio[i][1];
            }
        }

        System.out.println("Maximum value :"+Final);
    }
}