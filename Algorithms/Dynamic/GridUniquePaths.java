package Algorithms.Dynamic;
import java.util.*;
/**Given two values M and N, which represent a matrix[M][N]. We need to find the total unique 
 * paths from the top-left cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).

At any cell we are allowed to move in only two directions:- bottom and right. */
public class GridUniquePaths {

    /**Recursive memoization solution
     * Tc = O(2^m*n) => only recursive
     * 
     * Sc = O(path length)
     * 
     * Tc = O(M*N)
     * O((N-1)+(M-1)) + O(M*N)

Reason: We are using a recursion stack space:O((N-1)+(M-1)), 
here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
     */
    static int countWaysUtil(int i, int j, int[][] dp) {
        if(i==0 && j == 0)
          return 1;
        if(i<0 || j<0)
          return 0;
        if(dp[i][j]!=-1) return dp[i][j];
          
        int up = countWaysUtil(i-1,j,dp);
        int left = countWaysUtil(i,j-1,dp);
        
        return dp[i][j] = up+left;
        
      }
      
      static int countWays(int m, int n){
          int dp[][]=new int[m][n];
          for (int[] row : dp)
              Arrays.fill(row, -1);
          return countWaysUtil(m-1,n-1,dp);
          
      }

    /**Tabulation 
     * Time Complexity: O(M*N)

Reason: There are two nested loops

Space Complexity: O(M*N)

Reason: We are using an external array of size ‘M*N’’.
     */
    static int countWaysUtilTable(int m, int n, int[][] dp) {
 
        for(int i=0; i<m ;i++){
             for(int j=0; j<n; j++){
                 
                 //base condition
                 if(i==0 && j==0){
                     dp[i][j]=1;
                     continue;
                 }
                 
                 int up=0;
                 int left = 0;
                 
                 if(i>0) 
                   up = dp[i-1][j];
                 if(j>0)
                   left = dp[i][j-1];
                   
                 dp[i][j] = up+left;
             }
         }
         
         return dp[m-1][n-1];
       
       }
       
       static int countWaysTable(int m, int n){
           int dp[][]=new int[m][n];
           for (int[] row : dp)
               Arrays.fill(row, -1);
           return countWaysUtilTable(m,n,dp);
           
       }

    /**Space Optimized 
     * Time Complexity: O(M*N)

Reason: There are two nested loops

Space Complexity: O(N)

Reason: We are using an external array of size ‘N’ to store only one row.
    */
    static int countWaysSpaceOpt(int m, int n){
        int prev[]=new int[n];
        for(int i=0; i<m; i++){
            int temp[]=new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }
                
                int up=0;
                int left =0;
                
                if(i>0)
                    up = prev[j];
                if(j>0)
                    left = temp[j-1];
                    
                temp[j] = up + left;
            }
            prev = temp;
        }
        
        return prev[n-1];
        
    }
    
       

    public static void main(String[] args) {
        
    }
    
}
