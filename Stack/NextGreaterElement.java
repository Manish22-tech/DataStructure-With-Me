package Stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Integer>s=new Stack<>();
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int nextGreater[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&& arr[s.peek()]<=arr[i]) {
                s.pop();
            }
                if(s.isEmpty()){
                }
                s.push(i);

        }
        for(int i=0;i<n;i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}
