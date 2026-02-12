public class Assignment {
    
    static class Node {
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node head;

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

    //Swap Nodes in linked list
    public void swapNode(int x, int y){
        if(x == y){
            return;
        }

        // Find x
        Node currX = head;
        Node prevX = null;
        while(currX != null && currX.data != x){
            prevX = currX;
            currX = currX.next;
        }

        // Find y
        Node currY = head;
        Node prevY = null;
        while(currY != null && currY.data != y){
            prevY = currY;
            currY = currY.next;
        }

        // If both or one of them is not found just return.
        if(currX == null || currY == null){
            return;
        }

        // Point prevX to currX
        if(prevX != null){
            prevX.next = currY;
        }else{
            head = currY;
        }

        // Point prevY to currY
        if(prevY != null){
            prevY.next = currX;
        }else{
            head = currX;
        }
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        }

        // Odd Even Linked List
        void segregateEvenOdd(){
            if(head == null){
                return;
            }

            Node evenStart = null, evenEnd = null;
            Node oddStart = null, oddEnd = null;
            Node curr = head;

            while(curr != null){
                if(curr.data % 2 == 0){
                    if(evenStart == null){
                        evenStart = curr;
                        evenEnd = evenStart;
                    }else{
                        evenEnd.next = curr;
                        evenEnd = evenEnd.next;
                    }
                }else{
                    if(oddStart == null){
                        oddStart = curr;
                        oddEnd = oddStart;
                    }else{
                        oddEnd.next = curr;
                        oddEnd = oddEnd.next;
                    }
                }
                curr = curr.next;
            }

            // There is no even or odd
            if(evenStart == null || evenEnd == null){
                return;
            }

            evenEnd.next = oddStart;
            oddEnd.next = null;
            head = evenStart;
        }

        // Merge two sorted lists (simple recursive)
        public static Node mergeTwo(Node a, Node b) {

            if (a == null) return b;
            if (b == null) return a;

            if (a.data <= b.data) {
                a.next = mergeTwo(a.next, b);
                return a;
            } else {
                b.next = mergeTwo(a, b.next);
                return b;
            }
        }

        // Merge K lists (simple version)
        public static Node mergeKLists(Node[] arr, int k) {

            Node result = arr[0];

            for (int i = 1; i < k; i++) {
                result = mergeTwo(result, arr[i]);
            }
            return result;
        }
    
        // Insert at beginning
        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
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


        // // -------------------------------
        // // SKIP M DELETE N EXAMPLE
        // // -------------------------------
        int[] values = {1,2,3,4,5,6,7,8,9,10};

        Node head = createList(values);

        int M = 2;
        int N = 3;

        System.out.println("\nOriginal List:");
        print(head);

        skipMdeleteN(head, M, N);

        System.out.println("After Deletion:");
        print(head);

        // -------------------------------
        // SWAP NODES IN LINKED LIST
        // -------------------------------
        list.push(7);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.print("Linked list before: ");
        list.print(head);

        list.swapNode(4, 3);

        System.out.print("\nLinked list after: ");
        list.print(head);

        // -------------------------------
        // SEPARATE ODD OR EVEN
        // -------------------------------
        list.push(6);
        list.push(1);
        list.push(4);
        list.push(5);
        list.push(10);
        list.push(12);
        list.push(8);
        list.print(head);

        list.segregateEvenOdd();
        list.print(head);

        // -------------------------------
        // MERGE K SORTED LIST
        // -------------------------------
        int k = 3;
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        head = mergeKLists(arr, k);
        list.print(head);

    }
}