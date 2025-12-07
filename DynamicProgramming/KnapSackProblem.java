package DynamicProgramming;

import java.util.Scanner;

public class KnapSackProblem {
    public static int knapSack(int [] val,int []wt,int Wt,int n){
        int dp[][]=new int[n+1][Wt+1];
        dp[0][0]=0;
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<Wt+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w<=j){
                    dp[i][j]=Math.max(v+dp[i-1][j-w],dp[i-1][j-w]);
                }else{
                    dp[i][j]=dp[i-1][j-w];
                }


            }
        }
        return dp[n][Wt];

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];
        int Wt=sc.nextInt();
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();

        }
        System.out.println(knapSack(val,wt,Wt,n));

    }
}
