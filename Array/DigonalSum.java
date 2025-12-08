package Array;

import java.util.Scanner;

public class DigonalSum {
    public static int digonalSum(int [][]matrix){
        int sum=0,i;
        for(i=0;i<matrix.length;i++){
            sum+=matrix[i][i];
            if(i!=matrix.length-1-i){
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]matrix=new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
            System.out.println(digonalSum(matrix));


    }
}
