/* This program calculates the total number of possible ways to tile a 2×N floor using 2×1 tiles,
considering both vertical and horizontal placements, using recursion.*/

public class Tiling {

    public static int totalWays(int num){
        // Base case
        if(num==0 || num==1){
            return 1;
        }

        // Vetical way
        int vertical = totalWays(num-1);

        // Horizontal way
        int horizontal = totalWays(num-2);

        // Total number of ways
        return vertical + horizontal;
    }

    public static void main(String[] args){
        System.out.println(totalWays(4));
    }
}
