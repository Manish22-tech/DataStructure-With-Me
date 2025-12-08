package Array;
import java.util.*;
public class Maximum_Subarray_Sum {
    public static void main(String[] args) {
       int n=1;
        int arr[]={1};
       /* for(int st=0;st<n;st++){
            for(int end=st;end<n;end++){
                for(int i=st;i<=end;i++){
                    System.out.print(arr[i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }*/
        // Brute Force Approach
       /* int currSum=0;
        int MaxSum=Integer.MIN_VALUE;
        for(int st=0;st<n;st++) {
            for (int end = st; end < n; end++) {
              currSum=currSum+arr[end];
              MaxSum=Math.max(currSum,MaxSum);

            }
        }
        System.out.print(MaxSum);
    */
        // Kadane's Algorithm
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            curSum+=arr[i];
            maxSum=Math.max(curSum,maxSum);
            if(curSum<0){
                curSum=0;
            }
        }
        System.out.print(maxSum);


    }
}
