import java.util.*;

class AllArrayOperations {

    //  Display
    static void display(int arr[], int size) {
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    //  Insert at First
    static int insertFirst(int arr[], int size, int capacity, int value) {
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
        return size + 1;
    }

    //  Insert at Last
    static int insertLast(int arr[], int size, int capacity, int value) {
        arr[size] = value;
        return size + 1;
    }

    //  Insert at Position
    static int insertAtPos(int arr[], int size, int capacity, int pos, int value) {
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        return size + 1;
    }

    //  Delete from First
    static int deleteFirst(int arr[], int size) {
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return size - 1;
    }

    //  Delete from Last
    static int deleteLast(int arr[], int size) {
        return size - 1;
    }

    //  Delete from Position
    static int deleteAtPos(int arr[], int size, int pos) {
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return size - 1;
    }

    //  Search
    static void search(int arr[], int size, int key) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Element " + key + " found at index " + i + "\n");
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Element not found\n");
    }

    //  Update
    static void update(int arr[], int pos, int value) {
        arr[pos] = value;
        System.out.println("Element updated successfully!\n");
    }

    //  MAIN METHOD (Direct Execution)
    public static void main(String[] args) {

        int capacity = 15;
        int arr[] = new int[capacity];

        int size = 5;
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.println("Original Array:");
        display(arr, size);

        //  Insert First
        size = insertFirst(arr, size, capacity, 5);
        System.out.println("After Insert First:");
        display(arr, size);

        //  Insert Last
        size = insertLast(arr, size, capacity, 60);
        System.out.println("After Insert Last:");
        display(arr, size);

        // Insert at Position
        size = insertAtPos(arr, size, capacity, 3, 25);
        System.out.println("After Insert at Position 3:");
        display(arr, size);

        //  Delete First
        size = deleteFirst(arr, size);
        System.out.println("After Delete First:");
        display(arr, size);

        //  Delete Last
        size = deleteLast(arr, size);
        System.out.println("After Delete Last:");
        display(arr, size);

        //  Delete at Position
        size = deleteAtPos(arr, size, 2);
        System.out.println("After Delete at Position 2:");
        display(arr, size);

        // Search
        search(arr, size, 40);

        //  Update
        update(arr, 2, 99);
        System.out.println("After Update:");
        display(arr, size);
    }
}
