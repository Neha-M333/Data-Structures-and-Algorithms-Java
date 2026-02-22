
    import java.util.ArrayList;
    import java.util.Stack;

    public class Stack1 {
        
        static class stackArrayList{
            ArrayList<Integer> list = new ArrayList<>();

            //Empty
            public boolean isEmpty(){
                return list.size() == 0;
            }

            //push
            public void push(int data){
                list.add(data);
            }

            //pop
            public int pop(){
                if(isEmpty()){
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

        public static class Node{
            int data;
            Node next;

            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;

        public class stackLinkedList{

            //Empty
            public static boolean isEmpty(){
                return head == null;
            }

            //push
            public static void push(Node newNode){
                if(isEmpty()){
                    head = newNode;
                }

                newNode.next = head;
                head = newNode;
            }

            //pop
            public static int pop(){
                if(isEmpty()){
                    return -1;
                }

                int top = head.data;
                head = head.next;
                return top;
            }

            //peek
            public static int peek(){
                if(isEmpty()){
                    return -1;
                }

                return head.data;
            }
        }

        // Find the next greatest of right side
        public static void ngr(int[] arr){
            // 1. Create stack.
            // 2. Pop till you find the greated or the stack is empty.
            // 3. If stack is empty return  in ndr = -1 or  ndr = currunt top of stack.
            // 4. Push in stack.

            // (1)
            Stack<Integer> s = new Stack<>();
            int ngr[] = new int[arr.length];

            // (2)
            for(int i=arr.length-1 ; i >= 0; i--){
                while(!s    .isEmpty() && arr[s.peek()] <= arr[i]){
                    s.pop();
                }

                //(3)
                if(s.isEmpty()){
                    ngr[i] = -1;
                }
                else{
                    ngr[i] = arr[s.peek()];
                }

                // (4)
                s.push(i);
            }

            for(int i=0; i<ngr.length; i++){
                System.out.print(ngr[i] + ",");
                }
                System.out.println();
            }

            public static void main(String[] args) {
                int arr[] = {6, 8, 0, 1, 3};
                ngr(arr);
        }  
    }
