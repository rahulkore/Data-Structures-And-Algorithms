package Algorithms.BackTracking;

import java.util.*;
class NQueensEfficient {

    /**
     * The N Queen is the problem of placing N chess queens on an N×N chessboard so that
     * 1] There is no more than one queen present in a column.
     * 2] There is no more than one queen present in a row.
     * 3]No two queens can attack each other.
     * 
     * These three conditions need to be strictly satisfied
     * 
     */

    
    /**
     * This will be called when a success  is found 
     */
    public static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    /**
     * Initialize board , leftRow, upperDiagonal, lowerDiagonal
     */
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1]; 
        int lowerDiagonal[] = new int[2*n-1]; 
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    /**
     * Actual Solve method 
     */
    public static void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        /**
         * If any solution is found then that board configuration is added in the result
         */
        if(col == board.length) {
            res.add(construct(board));
            return;
        }
        
        /**
         * check for all the rows of a column 
         * when a queen is placed then call with next column 
         * and then after success or failure remove the queen and 
         * backtrack to its previous state for other possibilities.
         */
        for(int row = 0; row < board.length; row++) {
            /**
             * check if for (board{row}{col}) its leftrow is empty , lowerdiagnoal is empty , upperdiagonal is empty then place the queen
             * call solve method with next column
             * then remove the placed queen // backtrack
             */
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length -1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1 + col - row] = 1;
                solve(col+1, board, res, leftRow, lowerDiagonal, upperDiagonal );
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    public static void main(String[] args) {

        List<List<String>> res =  solveNQueens(4);
        System.out.println(res);
        
    }
}