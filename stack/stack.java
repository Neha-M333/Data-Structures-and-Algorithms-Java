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

    public static void pushBottom(Stack <Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static String reverce(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }  

        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();    
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverceStack(Stack <Integer> s){
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        reverceStack(s);
        pushBottom(s, top);
    }

    public static void stockSpan(int stock[], int span[]){
        Stack <Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stock.length; i++) {
            int curr = stock[i];

            while(!s.isEmpty() && curr >= stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prev = s.peek();
                span[i] = i - prev;
            }
            s.push(i);
        }
    }

    public static void main(String[] args){
        stackA s = new stackA();

        // stackB s = new stackB();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmptyA()){
        //     System.out.println(s.peekA());
        //     s.popA();
        // }

        //pushBottom(s, 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        // String str = "abc";
        // String result = reverce(str);
        // System.out.println(result);

        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for(int i=0; i<span.length; i++){
            System.out.print(span[i]+ " ");
        }
        System.out.println();
    }   
}
