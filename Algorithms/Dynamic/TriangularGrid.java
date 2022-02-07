package Algorithms.Dynamic;
import java.util.*;
/**We are given a Triangular matrix. We need to find the minimum path sum from the first row 
 * to the last row.

At every cell we can move in only two directions: either to the bottom cell (↓) or to the 
bottom-right cell(↘) */
public class TriangularGrid {

    /**Recursive memoization 
     * Time Complexity: O(N*N)
     * Space Complexity: O(N) + O(N*N)
    */
    static int minimumPathSumUtil(int i, int j, int[][] triangle,int n,int[][] dp) {
  
        if(i==n-1) return triangle[i][j];
          
        int down = triangle[i][j]+minimumPathSumUtil(i+1,j,triangle,n,dp);
        int diagonal = triangle[i][j]+minimumPathSumUtil(i+1,j+1,triangle,n,dp);
        
        return dp[i][j] = Math.min(down, diagonal);
        
      }
      
      static int minimumPathSum(int[][] triangle, int n){
          int dp[][]=new int[n][n];
          for(int row[]: dp)
          Arrays.fill(row,-1);
          return minimumPathSumUtil(0,0,triangle,n,dp);
          
      }
    
    /**Tabulation method
     * Time Complexity: O(N*N)
     * Space Complexity: O(N*N)
     */
    static int minimumPathSumTable(int[][] triangle, int n){
        int dp[][]= new int[n][n];
        
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle[n-1][j];
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                
                int down = triangle[i][j]+dp[i+1][j];
                int diagonal = triangle[i][j]+dp[i+1][j+1];
                
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        
        return dp[0][0];
        
    }

    /**Space Optimized
     * Time Complexity: O(N*N)
     * Space Complexity: O(N)
     */
    static int minimumPathSumSpaceOpt(int[][] triangle, int n){
     
        int front[] = new int[n];
        int cur[] = new int[n];
       
       for(int j=0;j<n;j++){
           front[j] = triangle[n-1][j];
       }
       
       for(int i=n-2; i>=0; i--){
           for(int j=i; j>=0; j--){
               
               int down = triangle[i][j]+front[j];
               int diagonal = triangle[i][j]+front[j+1];
               
               cur[j] = Math.min(down, diagonal);
           }
           front=cur;
       }
       
       return front[0];
       
   }
    

    public static void main(String[] args) {

        int triangle [][] = {{1},
                       {2,3},
                       {3,6,7},
                       {8,9,6,10}};
                            
  int n = triangle.length;
  
  System.out.println(minimumPathSum(triangle,n));
        
    }
    
}
