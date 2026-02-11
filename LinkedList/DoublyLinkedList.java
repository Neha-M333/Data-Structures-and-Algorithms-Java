public class DoublyLinkedList {

    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add a node first
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add a node last
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        newNode.next = null;
    }

    // Remove the first node
    public int removeFirst(){
        if(head == null){
            System.out.println("EMPTY!");
            size = 0;
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // Remove the last node
    public void removeLast(){
        if(head == null){
            System.out.println("EMPTY!");
            size = 0;
            return;
        }

        if(size == 1){
            head = tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    // Print Doubly Linked List
    public void print(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+ "<->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Reverce the doubly linked list
    public void  reverce(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addFirst(5);
        dl.addFirst(4);
        dl.addFirst(3);
        dl.addFirst(2);
        dl.addFirst(1);
        dl.addLast(6);
        dl.addLast(7);
        dl.print();

        dl.removeFirst();
        dl.print();

        dl.removeLast();
        dl.print();

        dl.reverce();
        dl.print();
    }
}
