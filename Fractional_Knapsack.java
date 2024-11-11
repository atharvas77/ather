import java.util.*;
public class Fractional_Knapsack
{

    static int knapsackTab(int val[],int wt[],int W)
    {
        int n=val.length;
        int dp[][]=new int[n+1][W+1];


        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }

        for(int j=0;j<dp[0].length;j++)
        {
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<W+1;j++)
            {
                int v=val[i-1];
                int w=wt[i-1];
                if(w<=j)
                {
                    int incProfit=v+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }
                else
                {
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
    
        return dp[n][W];
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the capacity of knapsack");
        int W=sc.nextInt();
        System.out.println("Enter the total no of items");
        int n=sc.nextInt();

        int val[]=new int[n];
        int wt[]=new int[n];

        System.out.println("Enter the value and weight of each items");
        for(int i=0;i<n;i++)
        {   
            val[i]=sc.nextInt();
            wt[i]=sc.nextInt();
        }

        System.out.println("Maximum Value: "+knapsackTab(val,wt,W));
      
    }
}
