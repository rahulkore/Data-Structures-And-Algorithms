package Algorithms.TopAmazonAskedQuestionsLeetCode;
/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */
public class wordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == word.charAt(0) && isFound(board, i, j, word, 0))
                    return true;
        
        return false;
    }
    
    private boolean isFound(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(word.charAt(index) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        // recursively going in all four directions to check whether match is found or not 
        if(isFound(board, i + 1, j, word, index + 1) ||
            isFound(board, i - 1, j, word, index + 1) ||
            isFound(board, i, j + 1, word, index + 1) ||
            isFound(board, i, j - 1, word, index + 1))
            return true;
        board[i][j] = temp;
        return false;
    }
    public static void main(String[] args) {
        
    }
    
}
