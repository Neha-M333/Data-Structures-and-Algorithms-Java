// This program implements a modified Binary Search to find a target element
// in a rotated sorted array using recursion. It determines which half of the
// array is sorted at each step and efficiently reduces the search space,
// achieving a time complexity of O(log n).

public class RotatedSort {

    public static int search(int arr[], int target, int si, int ei){
        //Base case
        if(si > ei){
            return -1;
        }

        //Working
        int mid = si+(ei-si)/2;

        // Find middle
        if(arr[mid] == target){
            return mid;
        }

        //middle on line 1
        if(arr[si] <= arr[mid]){
            if(arr[si] <= target && target <= arr[mid]){         // case a: Left
                return search(arr, target, si, mid-1);
            }else{                                               // case b: Right
                return search(arr, target, mid+1, ei);
            }
        }

        //middle on L2
        else{
            if(arr[mid] <= target && arr[target] <= arr[ei]){        //case c: Right
                return search(arr, target, mid+1, ei);
            }else{                                                   //case d: Left
                return search(arr, target, si, mid-1);
            }
        }
    }

    public static void main(String[] args){
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0, 0, arr.length));
    }
}
