/*
 * This program calculates the total number of ways to pair or keep
 * individuals single from a given group using recursion.
 *
 * For a group of 'n' people:
 * - A person can stay single, leaving (n - 1) people to be arranged.
 * - Or the person can pair up with any of the remaining (n - 1) people,
 *   and the remaining (n - 2) people are arranged recursively.
 *
 * The program uses a recursive approach based on the classic
 * "Friends Pairing Problem" to compute the total number of valid
 * pairings and single arrangements.
 *
 * Time Complexity  : O(2^n) (without optimization)
 * Space Complexity : O(n) (recursion stack)
 */


public class Pairing {
    public static int totalWays(int pair){
        //Base class
        if(pair==1 || pair==2){
            return pair;
        }
        //Work
        // int singlePair = totalWays(pair-1);
        // int multiPair = (pair-1) * totalWays(pair-2);
        // return singlePair + multiPair;

        return totalWays(pair-1) + (pair-1) * totalWays(pair-2);
    }

    public static void main(String[] args) {
        System.out.println(totalWays(3));
    }
}
