public class LinkedList {

    // Node definition
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

    // Insert node at a given index
    public void addAtIndex(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove first node
    public int removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Linked list is empty");
        }

        int val = head.data;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return val;
    }

    // Remove last node
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Linked list is empty");
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

    // Iterative search
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

    // Recursive search helper
    private int recursiveSearch(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int index = recursiveSearch(head.next, key);
        return index == -1 ? -1 : index + 1;
    }

    // Recursive search
    public int recursiveSearch(int key) {
        return recursiveSearch(head, key);
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node curr = head;

        tail = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Remove Nth node from the end
    public void removeNthFromEnd(int n) {
        if (n > size) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (n == size) {
            head = head.next;
            size--;
            return;
        }

        Node prev = head;
        for (int i = 1; i < size - n; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }

    // Find middle node (slow-fast pointer)
    private Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Check if linked list is a palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node mid = getMiddle(head);

        // Reverse second half
        Node prev = null;
        Node curr = mid;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare halves
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        System.out.print("Head -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Demo
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(1);

        list.print();
        System.out.println("Is Palindrome: " + list.isPalindrome());

        list.reverse();
        list.print();
    }
}
