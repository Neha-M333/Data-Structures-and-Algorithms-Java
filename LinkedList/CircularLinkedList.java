public class CircularLinkedList {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    // Add a node to a single list
    public Node addToEmpty(Node last, int data){
        if(last != null){
            return last;
        }
        Node newNode = new Node(data);
        last = newNode;
        newNode.next = last;
        return last;
    }

    // Add a node at front
    public Node addFront(Node last, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    // Add a node at last
    public Node addEnd(Node last, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    // Add a node after a item/node
    public Node addAfter(Node last, int data, int item){
        if(last == null){
            return null;
        }

        Node newNode, p;
        p = last.next;

        do { 
            if(p.data == item){
                newNode = new Node(data);
                newNode.next = p.next;
                p.next = newNode;

                if(p == last)
                last = newNode;
                return last;
            }
            p = p.next;
            } while (p != last.next);
                System.out.println(item+ "The given node is not present in the list");    
                return last;
    }

    // Delete node
    public Node deleteNode(Node last, int key){

        // Case 1: Empty list
        if(last == null){
            return null;
        }
    
        Node temp = last;
    
        // Case 2: Only one node
        if(last.data == key && last.next == last){
            return null;
        }
    
        // Case 3: If last node is to be deleted
        if(last.data == key){
            while(temp.next != last){
                temp = temp.next;
            }
    
            temp.next = last.next;
            last = temp;
            return last;
        }
    
        // Case 4: Search for node before the key
        while(temp.next != last && temp.next.data != key){
            temp = temp.next;
        }
    
        // If key found
        if(temp.next.data == key){
            temp.next = temp.next.next;
        }
    
        return last;
    }
    

    // Print the circular linked list
    public void teaverse(Node last){
        Node p;
        if(last == null){
            System.out.println("EMPTY!");
            return;
        }
        
        p = last.next;
        do {
            System.out.print(p.data+ "->");
            p = p.next;
        } while (p != last.next);
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();

        Node last = null;
        last = cl.addToEmpty(last, 6);
        last = cl.addFront(last, 2);
        last = cl.addEnd(last, 8);
        last = cl.addAfter(last, 1, 2);

        cl.teaverse(last);

        cl.deleteNode(last, 8);
        cl.teaverse(last);
    }
}

