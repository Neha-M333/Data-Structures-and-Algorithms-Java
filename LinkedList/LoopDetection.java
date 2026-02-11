public class LoopDetection {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    
    // Floyd’s Cycle Detection Algorithm
    public static boolean checkLoop(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void DetectCycle(){
        // Detect if is a cyclic 
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }
        }
        
        if(cycle == false){
            return;
        }

        // Find start of the loop
        
            slow = head;
            Node prev = null;

            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            //Remove cycle
            prev.next = null;
        
    }

    //Merge Sort Time complexity: O(nlogn)
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //Find Middle
        Node mid = getMid(head);

        //Split the linked list
        Node rightHead = mid.next;
        mid.next = null;

        //Call merge sort for left and right linked list
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //Merge the left and right linked list
        Node merge = merge(newLeft, newRight);
        return merge;
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergeLl = new Node(-1);
        Node temp = mergeLl;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLl.next;
    }

    // Zig-Zag linked list
    public void zigZag(){
        if (head == null || head.next == null) return;

        // Find the mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Reverce the second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Combine the left and righ node
        Node left = head;
        Node right = prev;
        Node nextLh, nextRh;

        while(right != null){
            nextLh = left.next;
            nextRh = right.next;

            left.next = right;
            right.next = nextLh;

            left = nextLh;
            right = nextRh;
        }
    }

    // Print the linked list
    public static void print(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = temp;
        // System.out.println(checkLoop());

        // DetectCycle();
        // print();

        LoopDetection obj = new LoopDetection();

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        // print(); // Before sorting

        // head = obj.mergeSort(head);

        // print(); // After sorting

        print();

        obj.zigZag();
        print();

    }
}
