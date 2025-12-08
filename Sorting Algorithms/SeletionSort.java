package Sorting;

public class SeletionSort {
    public static void main(String[] args) {
        int n=6;
        int arr[]={7,4,10,8,3,1};
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;

            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
