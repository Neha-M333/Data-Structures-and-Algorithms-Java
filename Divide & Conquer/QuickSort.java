// This program implements the Quick Sort algorithm using recursion.
// It selects the last element as the pivot, partitions the array
// around the pivot, and recursively sorts the left and right subarrays.
// The average time complexity of this algorithm is O(n log n).


public class QuickSort {

    public static void sort(int arr[], int si, int ei){
        //Base case
        if(si >= ei){
            return;
        }

        //Working
        int pIdx = partition(arr, si, ei);   // We define the pivot and partition
        sort(arr, si, pIdx-1);               // Sorting of left part 
        sort(arr, pIdx+1, ei);               // Sorting of right part
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];                // Last element is my pivot
        int i = si-1;

        for(int j=si; j<ei; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;                     // This is for the pivot to be sorted
        int temp = pivot;             
        arr[ei] = arr[i];
        arr[i] = temp; 
        return i;
    }

    public static void main(String[] args){
        int arr[] = {6, 3, 9, 8, 2, 5};
        sort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
