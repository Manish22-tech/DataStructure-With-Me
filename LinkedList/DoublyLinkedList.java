class DoublyLinkedList {

    // Node Structure
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;

    // ✅ Insert at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
        System.out.println(data + " inserted at beginning");
    }

    // ✅ Insert at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;

        System.out.println(data + " inserted at end");
    }

    // ✅ Insert at Position
    public void insertAtPosition(int data, int pos) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;

        System.out.println(data + " inserted at position " + pos);
    }

    // ✅ Delete from Beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println(head.data + " deleted from beginning");
        head = head.next;

        if (head != null)
            head.prev = null;
    }

    // ✅ Delete from End
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            System.out.println(head.data + " deleted from end");
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        System.out.println(temp.data + " deleted from end");
        temp.prev.next = null;
    }

    // ✅ Delete from Position
    public void deleteFromPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        System.out.println(temp.data + " deleted from position " + pos);
        temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    // ✅ Search
    public void search(int key) {
        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }

        System.out.println(key + " not found");
    }

    // ✅ Display Forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // ✅ Display Backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    // ✅ MAIN METHOD (Testing All Operations)
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(10);
        dll.insertAtBeginning(5);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        dll.insertAtPosition(15, 3);

        dll.displayForward();
        dll.displayBackward();

        dll.deleteFromBeginning();
        dll.deleteFromEnd();
        dll.deleteFromPosition(2);

        dll.displayForward();

        dll.search(15);
        dll.search(100);
    }
}
