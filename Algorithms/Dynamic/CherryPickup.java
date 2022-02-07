package Algorithms.Dynamic;
import java.util.*;
/**We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it,
 *  mat[i][j] gives us the number of chocolates. We have two friends ‘Alice’ and ‘Bob’.
 *  initially, Alice is standing on the cell(0,0) and Bob is standing on the cell(0, M-1).
 *  Both of them can move only to the cells below them in these three directions: to the
 *  bottom cell (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).

When Alica and Bob visit a cell, they take all the chocolates from that cell with them.
 It can happen that they visit the same cell, in that case, the chocolates need to be 
 considered only once.

They cannot go out of the boundary of the given matrix, we need to return the maximum 
number of chocolates that Bob and Alice can together collect. */
public class CherryPickup {

    /**Recursive memoization
     * Time Complexity: O(N*M*M) * 9
     * Space Complexity: O(N) + O(N*M*M)
     */

    static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid, 
  int[][][] dp) {
    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
      return (int)(Math.pow(-10, 9));

    if (i == n - 1) {
      if (j1 == j2)
        return grid[i][j1];
      else
        return grid[i][j1] + grid[i][j2];
    }

    if (dp[i][j1][j2] != -1)
      return dp[i][j1][j2];

    int maxi = Integer.MIN_VALUE;
    for (int di = -1; di <= 1; di++) {
      for (int dj = -1; dj <= 1; dj++) {
        int ans;
        if (j1 == j2)
          ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
        else
          ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj,n,
          m, grid, dp);
        maxi = Math.max(maxi, ans);
      }
    }
    return dp[i][j1][j2] = maxi;
  }

  static int maximumChocolates(int n, int m, int[][] grid) {

    int dp[][][] = new int[n][m][m];

    for (int row1[][]: dp) {
      for (int row2[]: row1) {
        Arrays.fill(row2, -1);
      }
    }

    return maxChocoUtil(0, 0, m - 1, n, m, grid, dp);
  }


  /**Tabulation method
   * Time Complexity: O(N*M*M)*9
   * Space Complexity: O(N*M*M)
   */

  static int maximumChocolatesTable(int n, int m, int[][] grid) {

    int dp[][][] = new int[n][m][m];

    for (int j1 = 0; j1 < m; j1++) {
      for (int j2 = 0; j2 < m; j2++) {
        if (j1 == j2)
          dp[n - 1][j1][j2] = grid[n - 1][j1];
        else
          dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
      }
    }

    //Outer Nested Loops for travering DP Array
    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {

          int maxi = Integer.MIN_VALUE;

          //Inner nested loops to try out 9 options
          for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

              int ans;

              if (j1 == j2)
                ans = grid[i][j1];
              else
                ans = grid[i][j1] + grid[i][j2];

              if ((j1 + di < 0 || j1 + di >= m) ||
                (j2 + dj < 0 || j2 + dj >= m))

                ans += (int) Math.pow(-10, 9);
              else
                ans += dp[i + 1][j1 + di][j2 + dj];

              maxi = Math.max(ans, maxi);
            }
          }
          dp[i][j1][j2] = maxi;
        }
      }
    }

    return dp[0][0][m - 1];
  }

  /**Space Optimized
   * Time Complexity: O(N*M*M)*9
   * Space Complexity: O(M*M)
   */

  static int maximumChocolatesSpaceOptimized(int n, int m, int[][] grid) {

    int[][] front = new int[m][m];
    int[][] cur = new int[m][m];

    for (int j1 = 0; j1 < m; j1++) {
      for (int j2 = 0; j2 < m; j2++) {
        if (j1 == j2)
          front[j1][j2] = grid[n - 1][j1];
        else
          front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
      }
    }

    //Outer Nested Loops for travering DP Array
    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {

          int maxi = Integer.MIN_VALUE;

          //Inner nested loops to try out 9 options
          for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

              int ans;

              if (j1 == j2)
                ans = grid[i][j1];
              else
                ans = grid[i][j1] + grid[i][j2];

              if ((j1 + di < 0 || j1 + di >= m) ||
                (j2 + dj < 0 || j2 + dj >= m))

                ans += (int) Math.pow(-10, 9);
              else
                ans += front[j1 + di][j2 + dj];

              maxi = Math.max(ans, maxi);
            }
          }
          cur[j1][j2] = maxi;
        }
      }

      for (int a = 0; a < m; a++) {
        front[a] = (int[])(cur[a].clone());
      }
    }

    return front[0][m - 1];
  }


    public static void main(String[] args) {
        
    }
    
}
