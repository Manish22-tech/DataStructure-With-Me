package Array;
import java.util.Scanner;

public class SpiralMatrix {
    public static void printSpiral(int [] [] matrix) {
        int startrow = 0;
        int endrow = matrix.length - 1;
        int startcol = 0;
        int endcol = matrix[0].length - 1;
        while (startrow <= endrow && startcol <= endcol) {
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }
            for (int i = startrow + 1; i <= endcol; i++) {
                System.out.print(matrix[i][endcol] + " ");
            }
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) break;
                System.out.print(matrix[endrow][j] + " ");
            }
            for (int i = endrow - 1; i >= startrow + 1; i--) {
                if (startcol == endcol) break;
                System.out.print(matrix[i][startcol] + " ");
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] [] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        printSpiral(matrix);
    }
}
