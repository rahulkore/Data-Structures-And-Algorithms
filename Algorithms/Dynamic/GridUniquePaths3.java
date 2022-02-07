package Algorithms.Dynamic;
import java.util.*;
/**We are given an “N*M” matrix of integers. We need to find a path from the top-left corner 
 * to the bottom-right corner of the matrix, such that there is a minimum cost past that we select.

At every cell, we can move in only two directions: right and bottom. The cost of a path is 
given as the sum of values of cells of the given matrix. */
public class GridUniquePaths3 {

    /**Recursive memoization 
     * Time Complexity: O(N*M)
     * Space Complexity: O((M-1)+(N-1)) + O(N*M)
    */
    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        if(i==0 && j == 0)
          return matrix[0][0];
        if(i<0 || j<0)
          return (int)Math.pow(10,9);
        if(dp[i][j]!=-1) return dp[i][j];
          
        int up = matrix[i][j]+minSumPathUtil(i-1,j,matrix,dp);
        int left = matrix[i][j]+minSumPathUtil(i,j-1,matrix,dp);
        
        return dp[i][j] = Math.min(up,left);
        
      }
      
      static int minSumPath(int n, int m, int[][] matrix){
          int dp[][]=new int[n][m];
          for(int row[]: dp)
          Arrays.fill(row,-1);
          return minSumPathUtil(n-1,m-1,matrix,dp);
          
      }

    /**Tabulation 
     * Time Complexity: O(N*M)
     * Space Complexity: O(N*M)
    */
    static int minSumPathTable(int n, int m, int[][] matrix){
    
        int dp[][]=new int[n][m];
        
        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) dp[i][j] = matrix[i][j];
                else{
                    
                    int up = matrix[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);
                    
                    int left = matrix[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left += (int)Math.pow(10,9);
                    
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        
        return dp[n-1][m-1];
        
    }

    /**Space Optimized 
     * Time Complexity: O(M*N)
     * Space Complexity: O(N)
    */
    static int minSumPathSpace(int n, int m, int[][] matrix){
    
        int prev[] = new int[n];
        for(int i=0; i<n ; i++){
            int temp[] = new int[m];
            for(int j=0; j<m; j++){
                if(i==0 && j==0) temp[j] = matrix[i][j];
                else{
                    
                    int up = matrix[i][j];
                    if(i>0) up += prev[j];
                    else up += (int)Math.pow(10,9);
                    
                    int left = matrix[i][j];
                    if(j>0) left+=temp[j-1];
                    else left += (int)Math.pow(10,9);
                    
                    temp[j] = Math.min(up,left);
                }
            }
            prev=temp;
        }
        
        return prev[m-1];
    }
    

    public static void main(String[] args) {
        
    }
    
}
