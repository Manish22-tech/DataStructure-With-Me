package Stack;

import java.util.Scanner;
import java.util.Stack;

public class TrappingRainWater {
    public static int maxWater(int height[]) {
        Stack<Integer>s=new Stack<>();
        int n=height.length;
        int ans=0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && height[s.peek()]<height[i]){
                int pop_height=height[s.peek()];
                s.pop();
                if(s.isEmpty())
                    break;
                int distance=i-s.peek()-1;
                int minHeight=Math.min(height[s.peek()],height[i])-pop_height;
                ans+=distance*minHeight;
            }
            s.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt(); //7 0 4 2 5 0 6 4 0 6
        }
        System.out.println(maxWater(arr));
    }
}







