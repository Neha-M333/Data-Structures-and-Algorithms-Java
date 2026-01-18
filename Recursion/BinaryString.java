/*
 * This program generates all possible binary strings of length 'n'
 * such that no two consecutive '1's appear in the string.
 *
 * It uses a recursive approach where:
 * - 'n' represents the number of positions left to fill
 * - 'lastPlace' keeps track of the previously placed bit
 * - 'str' stores the binary string formed so far
 *
 * A '0' can always be placed, but a '1' is placed only if the previous
 * position contained a '0'. This ensures the constraint of no
 * consecutive '1's is maintained.
 *
 * The program prints all valid binary strings that satisfy this rule.
 *
 * Time Complexity  : O(2^n)
 * Space Complexity : O(n) (recursion stack and string construction)
 */


public class BinaryString {

    public static void totalWays(int n, int lastPlace, String str) {
        //Base class
        if(n == 0){
            System.out.println(str);
            return;
        }

        //Work
        totalWays(n-1, 0, str+"0");
        if(lastPlace == 0){
            totalWays(n-1, 1, str+"1");
        }
        
    }
    public static void main(String[] args) {
        totalWays(3, 0, " ");
    }
}
