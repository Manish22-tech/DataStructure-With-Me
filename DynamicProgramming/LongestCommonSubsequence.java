package DynamicProgramming;
import java.util.Scanner;

public class LonestCommonSubsequences {
    public static int longestCommonSubsequence(String s1,String s2){
        int n=s1.length(),m=s2.length();
        int dp[] []=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(longestCommonSubsequence(s1,s2));
    }
}
