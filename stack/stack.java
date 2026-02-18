import java.util.*;

public class stack {
    
    // ArrayList
    static class stackA{
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.size() == 0;
        }
    
        //push
        public void push(int data){
            list.add(data);
        }
    
        //pop
        public int pop(){
            if (isEmpty()) {
                return -1; 
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        } 
    
        //peek
        public int peek(){
            return list.get(list.size()-1);
        }
    }

    //Linked List
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    
    static class stackB{
        static Node head = null;

        // isEmpty
        public boolean isEmptyA(){
            return head == null;
        }

        // Push
        public void pushA(int data){
            Node newNode = new Node(data);

            if(isEmptyA()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // Pop
        public int popA(){
            if(isEmptyA()){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek
        public int peekA(){
            if(isEmptyA()){
                return -1;
            }
            return head.data;
        }
    }

    public static void pushBottom(stackA s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args){
        stackA s = new stackA();

        // stackB s = new stackB();
        s.push(1);
        s.push(2);
        s.push(3);

        // while(!s.isEmptyA()){
        //     System.out.println(s.peekA());
        //     s.popA();
        // }
        pushBottom(s, 4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }   
}
