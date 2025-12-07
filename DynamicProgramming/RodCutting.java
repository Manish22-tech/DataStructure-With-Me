package DynamicProgramming;

import java.util.Scanner;

public class RodCutting {
    public static int  maximumValueOfRodCutting(int redLength, int n,int length[],int price[] ){
        int dp[][]=new int[n+1][redLength+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<redLength+1;j++){
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<redLength+1;j++){
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][redLength];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int redLength=sc.nextInt();
        int n=sc.nextInt();
        int length[]=new int[n];
        int price[]=new int[n];
        for(int i=0;i<n;i++){
            length[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            price[i]=sc.nextInt();
        }
        System.out.println(maximumValueOfRodCutting(redLength,n,length,price));
    }
}
