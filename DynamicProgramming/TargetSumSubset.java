package DynamicProgramming;

import java.util.Scanner;

public class TargetSumSubset {
    public static boolean targetSum(int [] arr,int target,int n){
     boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
       for(int i=1;i<n+1;i++){
           for(int j=1;j<target+1;j++){
               // include
               int v=arr[i-1];
               if(v<=j&& dp[i-1][j-v]== true){
                   dp[i][j]=true;
               }
               // exclude
               else if(dp[i-1][j]==true){
                   dp[i][j]=true;
               }
           }
       }
     return  dp[n][target];   //o(n*sum)
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(targetSum(arr,target,n));
    }
}
