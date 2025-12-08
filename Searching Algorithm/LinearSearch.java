class LinearSearch {
    public static int linearSearch(int arr[], int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;   // element found
            }
        }
        return -1;  // element not found
    }

    public static void main(String[] args) {
        int arr[] = {10, 25, 30, 45, 50};
        int target = 30;

        int result = linearSearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
