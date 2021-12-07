package misc;
/**
 * On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.

 

Example 1:

Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.

 */
public class KNightProbabilityInChessBoard {
    
    public double knightProbability(int n, int k, int row, int column) {
        int[] x = new int[]{-1, -1, 1, 1, -2, -2, 2, 2};
        int[] y = new int[]{-2, 2, -2, 2, -1, 1, -1, 1};
        
        double[][][] dp = new double[n][n][k+1];
        
        dp[row][column][0] = 1;
        
        for(int m=1;m<k+1;m++){ 
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int d=0;d<8;d++){
                        int newRow = i+x[d];
                        int newCol = j+y[d];
                        if(newRow>=0 && newRow<n && newCol<n && newCol>=0){
                            dp[newRow][newCol][m] += (dp[i][j][m-1]/8.0);
                        }
                    }
                }
            }
        }
        
        double ans = 0.0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans += dp[i][j][k];
                //System.out.println(dp[i][j][k]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
