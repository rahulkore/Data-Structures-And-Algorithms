package Algorithms.BackTracking;
import java.util.*;

public class NQueensBruteForce {

    /**
     * The N Queen is the problem of placing N chess queens on an N×N chessboard so that
     * 1] There is no more than one queen present in a column.
     * 2] There is no more than one queen present in a row.
     * 3]No two queens can attack each other.
     * 
     * These three conditions need to be strictly satisfied
     * 
     * NQueens has a time complexity of O(n!)
     */

    
    /**
     * This will be called when a success  is found 
     */

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col; 
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false; 
            row--;
            col--; 
        }
        
        row = duprow; 
        col = dupcol; 
        while(col >= 0) {
            if(board[row][col] == 'Q') return false; 
            col--; 
        }
        
        row = duprow; 
        col = dupcol; 
        while(col >= 0 && row < board.length) {
            if(board[row][col] == 'Q') return false; 
            col--;
            row++; 
        }
        return true; 
    }

    private static void nqueens(int col, char[][] board, List<List<String>> res) {
        /**
         * If any solution is found then that board configuration is added in the result
         */
        if(col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++) {
            if(validate(board, row, col)) {
                board[row][col] = 'Q';
                nqueens(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        nqueens(0, board, res);
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        System.out.println(res);
    }
    
}
