package Algorithms.Dynamic;
import java.util.*;
/**We are given an ‘N*M’ matrix. We need to find the maximum path sum from any 
 * cell of the first row to any cell of the last row.

At every cell we can move in three directions: to the bottom cell (↓), to the bottom-right cell(↘), 
or to the bottom-left cell(↙) */
public class MinMaxFallingPathSum {

    /**Recursive memoization solution
     * Time Complexity: O(N*N)
     * Space Complexity: O(N) + O(N*M)
     */
    static int getMaxUtil(int i, int j, int m, int[][] matrix,int[][] dp){
    
        // Base Conditions
        if(j<0 || j>=m)
            return (int)Math.pow(-10,9);
        if(i==0)
            return matrix[0][j];
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int up = matrix[i][j] + getMaxUtil(i-1,j,m,matrix,dp);
        int leftDiagonal = matrix[i][j] + getMaxUtil(i-1,j-1,m,matrix,dp);
        int rightDiagonal = matrix[i][j] + getMaxUtil(i-1,j+1,m,matrix,dp);
        
        return dp[i][j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));
        
    }

    static int getMaxPathSum(int[][] matrix){
    
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dp[][]= new int[n][m];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        
        int maxi = Integer.MIN_VALUE;
        
        for(int j=0; j<m;j++){
            int ans = getMaxUtil(n-1,j,m,matrix,dp);
            maxi = Math.max(maxi,ans);
        }
        
        return maxi;
    }


    /**Tabulation solution
     * Time Complexity: O(N*M)
     * Space Complexity: O(N*M)
     */
    static int getMaxPathSumTabulation(int[][] matrix){
    
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dp[][] = new int[n][m];
        
        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){
                
                int up = matrix[i][j] + dp[i-1][j];
                
                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(-10,9);
                
                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(-10,9);
                
                dp[i][j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));
                
            }
        }
        
        int maxi = Integer.MIN_VALUE;
        
        for(int j=0; j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }
        
        return maxi;
    }
    
    /**Space Optimized solution
     * Time Complexity: O(N*M)
     * Space Complexity: O(M)
     */
    int getMaxPathSumSpaceOptimized(int[][] matrix){
    
        int n = matrix.length;
       int m = matrix[0].length;
       
       int[] prev = new int[m];
       int[] cur = new int[m];
       
       // Initializing first row - base condition
       for(int j=0; j<m; j++){
           prev[j] = matrix[0][j];
       }
       
       for(int i=1; i<n; i++){
           for(int j=0;j<m;j++){
               
               int up = matrix[i][j] + prev[j];
               
               int leftDiagonal= matrix[i][j];
               if(j-1>=0) leftDiagonal += prev[j-1];
               else leftDiagonal += Integer.MIN_VALUE;
               
               int rightDiagonal = matrix[i][j];
               if(j+1<m) rightDiagonal += prev[j+1];
               else rightDiagonal += Integer.MIN_VALUE;
               
               cur[j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));
               
           }
           
           prev = cur;
       }
       
       int maxi = Integer.MIN_VALUE;
       
       for(int j=0; j<m;j++){
           maxi = Math.max(maxi,prev[j]);
       }
       
       return maxi;
   
   }
   
    

    public static void main(String[] args) {
        
    }
    
}
