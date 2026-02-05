public class LinkedList {

    // Node structure
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Add node at a given index
    public void addAtIndex(int data, int idx) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid index");
            return;
        }

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
    }

    // Remove first node
    public void removeFirst() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        head = head.next;
        size--;
    }

    // Remove last node
    public void removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;
    }

    // Search for a value
    public int search(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // Print the linked list
    public void print() {
        if (head == null) {
            System.out.println("Empty Linked List");
            return;
        }

        Node temp = head;
        System.out.print("Head -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Demo
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        System.out.println("Size: " + ll.getSize());

        ll.addLast(6);
        ll.print();
        System.out.println("Size: " + ll.getSize());

        ll.addAtIndex(9, 2);
        ll.print();
        System.out.println("Size: " + ll.getSize());

        ll.removeFirst();
        ll.print();
        System.out.println("Size: " + ll.getSize());

        ll.removeLast();
        ll.print();
        System.out.println("Size: " + ll.getSize());

        System.out.println("Index of 5: " + ll.search(5));
    }
}

