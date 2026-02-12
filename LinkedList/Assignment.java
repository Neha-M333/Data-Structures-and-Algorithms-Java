public class Assignment {
    
    static class Node {
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }

    // Create a list of linked list
    static Node createList(int[] arr){
        if(arr.length == 0){
            return null;
        }

        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i = 1; i < arr.length; i++){
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Skip M number of nodes and delete N nodes
    static void skipMdeleteN(Node head, int m, int n){
        Node curr = head;

        while(curr != null){

            // Skip M-1 nodes
            for(int i = 1; i < m && curr != null; i++){
                curr = curr.next;
            }

            if(curr == null){
                return;
            }

            // Start deleting from next node
            Node temp = curr.next;
            for(int i = 0; i < n && temp != null; i++){
                temp = temp.next;
            }

            // Connect after deletion
            curr.next = temp;
            curr = temp;
        }
    }

    // Find the node where two nodes intersect
    public Node getIntersectionNode(Node head1, Node head2){
        while (head2 != null) {
            Node temp = head1;
        
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    // Print list
    static void print(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Assignment list = new Assignment();

        // -------------------------------
        // INTERSECTION EXAMPLE 1
        // -------------------------------
        Node head1 = new Node(10);

        Node head2 = new Node(3);
        Node newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30);
        head1.next.next = newNode;

        Node insertionPoint = list.getIntersectionNode(head1, head2);

        if(insertionPoint != null)
            System.out.println("Intersection point is: " + insertionPoint.data);
        else
            System.out.println("No intersection");


        // -------------------------------
        // SKIP M DELETE N EXAMPLE
        // -------------------------------
        int[] values = {1,2,3,4,5,6,7,8,9,10};

        Node head = createList(values);

        int M = 2;
        int N = 3;

        System.out.println("\nOriginal List:");
        print(head);

        skipMdeleteN(head, M, N);

        System.out.println("After Deletion:");
        print(head);
    }
}
