import java.util.*;

class CountingSort {

    static void countingSort(int arr[]) {
        int n = arr.length;

        // 1️⃣ Find maximum element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // 2️⃣ Create count array
        int[] count = new int[max + 1];

        // 3️⃣ Store frequency
        for (int num : arr) {
            count[num]++;
        }

        // 4️⃣ Build sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // ✅ Main method to test
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};

        countingSort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
