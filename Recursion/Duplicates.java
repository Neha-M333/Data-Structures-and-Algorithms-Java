/*
 * This program removes duplicate characters from a given string while
 * preserving the order of their first occurrence.
 *
 * The active implementation uses a recursive approach along with a
 * boolean array to track previously encountered characters.
 *
 * The string is first converted to lowercase so that uppercase and
 * lowercase versions of the same letter are treated as duplicates.
 *
 * For each character in the string:
 * - If the character has already appeared, it is skipped.
 * - If it appears for the first time, it is added to the result string.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1) (uses a fixed-size boolean array of length 26)
 */


public class Duplicates {

    // public static void removeDup(String str) {               ---- For aaabbbcc ----
    //     str = str.toLowerCase();
    //     StringBuilder result = new StringBuilder();

    //     result.append(str.charAt(0));

    //     for (int i = 1; i < str.length(); i++) {
    //         if (str.charAt(i) != str.charAt(i - 1)) {
    //             result.append(str.charAt(i));
    //         }
    //     }

    //     System.out.println(result.toString());
    // }

    // public static void removeDup(String str) {
    //     str = str.toLowerCase();
    //     boolean[] seen = new boolean[26];
    //     StringBuilder result = new StringBuilder();

    //     for (int i = 0; i < str.length(); i++) {
    //         char ch = str.charAt(i);
    //         if (!seen[ch - 'a']) {
    //             seen[ch - 'a'] = true;
    //             result.append(ch);
    //         }
    //     }

    //     System.out.println(result.toString());
    // }

    public static void removeDup(String str, int idx, StringBuilder newStr, boolean seen[]) {
        str = str.toLowerCase();
        //Base class
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        //Work
        char currChar = str.charAt(idx);
        if(seen[currChar - 'a'] == true){
            removeDup(str, idx+1, newStr, seen);    //Duplicates
        }else{
            seen[currChar - 'a'] = true;
            removeDup(str, idx+1, newStr.append(currChar), seen);
        }
    }

    public static void main(String[] args) {
        String str = "HelloHowYouDoing";
        removeDup(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
