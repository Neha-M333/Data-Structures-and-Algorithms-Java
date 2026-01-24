public class Array {

    // This method fills the array using backtracking
    public static void backtrack(int arr[], int idx, int val) {

        // Base case: when index reaches array length,
        // print the current state of the array
        if(idx == arr.length){
            print(arr);
            return;
        }

        // Step 1: Assign the current value to the array at index idx
        arr[idx] = val;

        // Step 2: Move to the next index with incremented value
        backtrack(arr, idx + 1, val + 1);

        // Step 3 (Backtracking step):
        // Change the value after returning from recursion
        arr[idx] = val - 2;
    }

    // Utility method to print array elements
    public static void print(int arr[]) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create an array of size 5 (initialized with 0s)
        int arr[] = new int[5];

        // Call backtracking function starting from index 0 and value 1
        backtrack(arr, 0, 1);

        // Print final state of array after backtracking completes
        print(arr);
    }
}
