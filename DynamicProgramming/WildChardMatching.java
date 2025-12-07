package DynamicProgramming;

import java.util.Scanner;

public class WildChardMatching {
    public static boolean IsMatch(String str,String pattern) {
        int n=str.length();
        int m=pattern.length();
        boolean[][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        for( int j=1;j<m+1;j++){
            if(pattern.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        for(int i=1;i<n+1;i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(pattern.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String pattern=sc.nextLine();
        System.out.println(IsMatch(str1,pattern));
    }
}
