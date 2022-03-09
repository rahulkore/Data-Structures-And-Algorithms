package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**Given an m x n board of characters and a list of strings words, return all words on the 
 * board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells 
are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"] */
class WordSearch2 {
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
        if(isFound(board, i + 1, j, word, index + 1) ||
            isFound(board, i - 1, j, word, index + 1) ||
            isFound(board, i, j + 1, word, index + 1) ||
            isFound(board, i, j - 1, word, index + 1)){
            board[i][j] = temp;
            return true;
        }
            
        board[i][j] = temp;
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for(String str : words){
            // System.out.println(str);
            if(exist(board,str))
                ans.add(str);
        }
        return ans;
    }
}
