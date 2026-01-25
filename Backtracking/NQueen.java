// This program solves the N-Queen problem using recursion and backtracking.
// The goal is to place N queens on an N×N chessboard such that
// no two queens attack each other.

public class NQueen {

    // This method checks if placing a queen at (row, col) is safe
    public static boolean isSafe(char board[][], int row, int col){

        // Check vertically upwards (same column)
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // Check diagonal left-up direction
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Check diagonal right-up direction
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // If no queen is attacking, it's safe to place
        return true;
    }

    // This method places queens row by row using recursion
    public static void nQueen(char board[][], int row){

        // Base case: all rows are filled
        if(row == board.length){
            printBoard(board);
            return;
        }

        // Try placing a queen in each column of the current row
        for(int j = 0; j < board.length; j++){

            // Check if current position is safe
            if(isSafe(board, row, j)){

                // Place queen
                board[row][j] = 'Q';

                // Recursive call for next row
                nQueen(board, row + 1);

                // Backtracking: remove queen
                board[row][j] = 'X';
            }
        }
    }

    // This method prints the chess board
    public static void printBoard(char board[][]){
        System.out.println("----- Chess Board ------");

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args){

        int n = 4;  // Size of the chessboard (4x4)
        char board[][] = new char[n][n];

        // Initialize board with 'X' (empty cells)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = 'X';
            }
        }

        // Start solving N-Queen problem
        nQueen(board, 0);
    }
}
