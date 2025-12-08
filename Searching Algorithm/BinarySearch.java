package Array;

public class BinarySearch {
    public static  void binarySerach(int []arr,int first,int last,int key){
        int mid=(first+last)/2;
        while(first<=last){
            if(arr[mid]<key){
                first=mid+1;
            }
            else if(arr[mid]==key){
                System.out.println(mid);
                break;
            }
            else{
                last=mid-1;
            }
        }
        if(first>last){
            System.out.println("Element is not found");
        }
    }
    public static void main(String[] args) {
      int arr[]={10,20,30,40,50};
      int key=50;
      binarySerach(arr,0,arr.length-1,key);
    }
}
