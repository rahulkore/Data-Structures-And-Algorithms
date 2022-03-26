package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
/**Tc =  O(1) \
 * Sc  = O(n)
*/
public class DesignTicTactoe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    
    /** Initialize your data structure here. */
    public DesignTicTactoe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
        {
            diagonal += toAdd;
        }
        
        if (col == (cols.length - row - 1))
        {
            antiDiagonal += toAdd;
        }
        
        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size  ||
            Math.abs(antiDiagonal) == size)
        {
            return player;
        }
        
        return 0;
    }

}

/**Tc = O(4n) 
 * Sc  = O(n*n)
*/
class TicTacToe {
    int[][]board;
    int win;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.win = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(this.win != 0){
            return this.win;
        }
        this.board[row][col] = player;
        if(row == col && checkLeftDiagnal(player)){
            return player;
        }
        if(row + col == board.length - 1 && checkRightDiagnal(player)){
            return player;
        }
        if(checkCol(col, player) || checkRow(row,player)){
            return player;
        }
        return 0;
    }
    private boolean checkCol(int col, int player){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] != player){
                return false;
            }
        }
        return true;
    }
    private boolean checkRow(int row, int player){
        for(int i = 0;  i < board.length; i++){
            if(board[row][i] != player){
                return false;
            }
        }
        return true;
    }
    private boolean checkLeftDiagnal(int player){
        for(int i = 0; i < board.length; i++){
            if(board[i][i] != player){
                return false;
            }
        }
        return true;
    }
    private boolean checkRightDiagnal(int player){
        for(int i = 0; i < board.length; i++){
            if(board[i][board.length - i - 1] != player){
                return false;
            }
        }
        return true;
    }
}