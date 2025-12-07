package LinkedList;

public class CreateLikedList {
    public static class Node{
        int data;
        Node next;
         public Node(int data){
             this.data=data;
             this.next=null;
         }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node node=new Node(data);
        size++;
        if(head==null){
            head=tail=node;
            return;
        }

        node.next=head;
        head=node;

    }
    public void addLast(int data){ //o(1)
        Node node=new Node(data);
        size++;
        if(head==null){
            head=tail=node;
            return;
        }
        tail.next=node;
        tail=node;
    }
    public void printLinkedList(){    //o(n)
        if(head==null){
            System.out.println("LL IS EMPTY");
            return;
        }

        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int idx,int data){
        Node node=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        node.next=temp.next;
        temp.next=node;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        else {
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
    }
   public int removeLast(){
        if(size==0){
            System.out.println("LL is Empty");
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
         Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
            int val=tail.data;
            prev.next=null;
            tail=prev;
            size--;
            return val;

   }

   public int SearchElement( int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key) {
                return i;
            }
            temp=temp.next;
            i++;
        }
    return -1;
   }
   public void reverse() {
       Node prev = null;
       Node curr = tail = head;
       Node next;
       while (curr != null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }

       head =prev;
   }
   public Node findMiddle(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
   }
   public boolean isPalindrome(){
        if(head==null && head.next==null){
            return true;
        }
        // step 1 to find midd
          Node  midNode=findMiddle(head);


       // step 2 reverse 2 half
             Node prev=null;
             Node curr=midNode;
             Node next;
             while(curr!=null){
                 next=curr.next;
                 curr.next=prev;
                 prev=curr;
                 curr=next;
             }
             Node right=prev;
             Node left=head;

       // step 3 check left and right half
           while(right!=null){
               if(left.data!=right.data){
                   return false;

               }
               left=left.next;
               right=right.next;
           }

       return true;
   }
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;


        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeLoopOrCycle(){
        // detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(cycle==false)
            return;


        // find meeting point
        slow=head;
        Node prev=null;
        while (slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }


        // remove cycle
        prev.next=null;
    }
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null) return head;
        Node mid=getMid(head);
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        return merge(newLeft,newRight);

    }



    public static void main(String[] args) {
           CreateLikedList l1=new CreateLikedList();
          ///l1.printLinkedList();
          //l1.removeFirst();
           //l1.printLinkedList();
           //l1.addFirst(1);
        //l1.printLinkedList();
          // l1.addLast(2);
        //l1.printLinkedList();
       //    l1.addLast(1);
          // l1.printLinkedList();
          // l1.addMiddle(2,5);
       //    l1.printLinkedList();
          // System.out.println(l1.size);
          // System.out.println(l1.removeLast());
        // l1.printLinkedList();
           //System.out.println(l1.SearchElement(3));
        //l1.reverse();
        //l1.printLinkedList();
       // System.out.println(l1.isPalindrome());
        //head=new Node(1);
       // Node temp=new Node(2);
        //head.next=temp;
        //head.next.next=new Node(3);
        //head.next.next.next=temp;
       // System.out.println(isCycle());
      // removeLoopOrCycle();
       // System.out.println(isCycle());


        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(4);
        l1.addFirst(5);
        l1.addFirst(6);
        l1.printLinkedList();
        l1.head=l1.mergeSort(l1.head);
        l1.printLinkedList();


    }
}
