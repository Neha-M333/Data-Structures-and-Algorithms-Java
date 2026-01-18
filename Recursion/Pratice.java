/*
 * Program: Practice of Recursion in Java
 * Author: [Your Name]
 * Description: This program demonstrates several common recursion problems:
 * 1. getPos      - Prints all indices of a key in an array.
 * 2. printWord   - Prints the digits of a number in words.
 * 3. length      - Returns the length of a string recursively.
 * 4. countSubstrs- Counts palindromic substrings in a string.
 * 5. towerOfHanoi- Solves the Tower of Hanoi puzzle recursively.
 * 
 * Usage: Uncomment the corresponding function call in main() to test it.
 */

public class Pratice {

    // Prints all indices of key in array recursively
    public static void getPos(int arr[], int key, int idx){
        //Base case
        if(idx == arr.length){
            return;
        }
        
        //working
        if(key == arr[idx]){
            System.out.print(idx+" ");
        }
        getPos(arr, key, idx+1);
    }

    // Prints a number in words recursively
    public static void printWord(int num){
        String digit[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        //Base case
        if(num == 0){
            return;
        }

        //Working
        int lastDigit = num%10;
        printWord(num/10);
        System.out.print(digit[lastDigit]+ " ");
    }

    // Returns length of string recursively
    public static int length(String str) {
        //Base care
        if(str.length() == 0){
            return 0;
        }

        //Working
        return length(str.substring(1))+1;
    }

      // Counts palindromic substrings recursively
    public static int countSubstrs(String str, int i, int j, int n) {

        // Base case 1: Single character is always a palindrome
        if (n == 1) {
            return 1;
        }

        // Base case 2: Empty or invalid substring
        if (n <= 0) {
            return 0;
        }

        // Count substrings by shrinking from left and right
        int res =
                countSubstrs(str, i + 1, j, n - 1) +      // exclude first character
                countSubstrs(str, i, j - 1, n - 1) -      // exclude last character
                countSubstrs(str, i + 1, j - 1, n - 2);   // remove overlap

        // If first and last characters match, count this substring
        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }


// Solves Tower of Hanoi recursively
    public static void towerOfHanoi(int n, String src, String helper, String dest) {

        // Base case: if only one disk, move it directly
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        // Step 1: Move (n-1) disks from source to helper
        towerOfHanoi(n - 1, src, dest, helper);

        // Step 2: Move the nth (largest) disk from source to destination
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);

        // Step 3: Move (n-1) disks from helper to destination
        towerOfHanoi(n - 1, helper, src, dest);
    }
    
    public static void main(String[] args){
        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // getPos(arr, 2, 0);
        // System.out.println();

        // printWord(2003);
        // System.out.println();

        // String str = "abcde";
        // System.out.println(length(str));

        // String str = "aba";
        // int n = str.length();
        // System.out.println(countSubstrs(str, 0, n - 1, n));

        int n = 3; // number of disks
        towerOfHanoi(n, "A", "B", "C");
    }
}
