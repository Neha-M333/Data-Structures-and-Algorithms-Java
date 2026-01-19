/* This program implements the Merge Sort algorithm using recursion.
It divides the array into smaller subarrays, sorts them individually,
and then merges the sorted subarrays to produce a fully sorted array
with a time complexity of O(n log n). */

public class MergeSort {
    
    public static void sort(int arr[], int si, int ei){
        // Base Case
        if(si >= ei){
            return;
        }

        //Working
        int mid = si + (ei - si)/2;       // Find The Middle
        sort(arr, si, mid);               // Sort left part
        sort(arr, mid+1, ei);             // Sort right part
        merge(arr, si, mid, ei);          // Merge Left sorted part and right sorted part
    }

    public static void merge(int arr[], int si, int mid, int ei){
        // arr[0-3]=4  && arr[4-6]=3  ---> ei-si+1 == 6-0+1 = 6
        int temp[] = new int[ei-si+1];
        int i = si;              // pointer for left part
        int j = mid+1;           // pointer for right part
        int k = 0;               // pointer for temp array

        while(j <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i < mid){              //Leftover of left part
            temp[k++] = arr[i++];
        }

        while(j <= ei){            //Leftover of right part
            temp[k++] = arr[j++];
        }
        
        for(k=0, i=si; k<temp.length; k++, i++){   //Copy temp array to original array
            arr[i] = temp[k];
        }        
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        sort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
