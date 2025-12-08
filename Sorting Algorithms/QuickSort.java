
package Sorting;

import java.util.Scanner;

public class QuickSort {
    public  static  void printArr(int arr[]){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei)return ;


        int pidx=partition(arr,si,ei);
        quickSort(arr,si,pidx-1);
        quickSort(arr,pidx+1,ei);

    }
    public static int partition(int arr[],int si, int ei){
        int pivt=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivt){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }

        i++;
        int temp=pivt;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;



    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr,0,arr.length-1);
        printArr(arr);
    }
}
































































