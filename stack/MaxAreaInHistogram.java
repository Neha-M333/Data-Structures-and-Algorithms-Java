
import java.util.Stack;

public class MaxAreaInHistogram {
    
    public static void MaxArea(int[] arr){
        // 1. Create a stack
        // 2. Next smallest right (j) -> Time complexity: O(n)
        // 3. Next smallest left (i) -> Time complexity: O(n)
        // 4. Current area.
        // 5. Max amount current array

        int maxNum = 0;

        // (1)
        Stack<Integer> s = new Stack<>();

        // (2)
        int[] nsr = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // (3)
        int[] nsl = new int[arr.length];
        s = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // (4)

        for(int i=0; i<arr.length; i++){
            int width = nsr[i] - nsl[i] - 1;
            int currArea = arr[i] * width;

            // (5)
            maxNum = Math.max(maxNum, currArea);
        }

        System.out.println("Area: "+ maxNum);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        MaxArea(arr);
    }
}
