package Algorithms.Dynamic;
import java.util.*;
/**We are given an “N*M” Maze. The maze contains some obstacles. A cell is ‘blockage’ in the maze
 *  if its value is -1. 0 represents non-blockage. There is no path possible through a 
 * blocked cell.

We need to count the total number of unique paths from the top-left corner of the maze to the 
bottom-right corner. At every cell, we can move either down or towards the right. */
public class GridUniquePaths2 {

    /**Recursive memoization solution 
     * Time Complexity: O(N*M)
     * Space Complexity: O((M-1)+(N-1)) + O(N*M)
    */
    static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
        if(i>0 && j>0 && maze[i][j]==-1) return 0; 
        if(i==0 && j == 0)
          return 1;
        if(i<0 || j<0)
          return 0;
        if(dp[i][j]!=-1) return dp[i][j];
          
        int up = mazeObstaclesUtil(i-1,j,maze,dp);
        int left = mazeObstaclesUtil(i,j-1,maze,dp);
        
        return dp[i][j] = up+left;
        
      }
      
      static int mazeObstacles(int n, int m, int[][] maze){
          int dp[][]=new int[n][m];
          for(int row[]: dp)
          Arrays.fill(row,-1);
          return mazeObstaclesUtil(n-1,m-1,maze,dp);
          
      }
    /**Tabulation method 
     * Time Complexity: O(N*M)
     * Space Complexity: O(N*M)
    */
    static int mazeObstaclesUtilTable(int n, int m, int[][] maze, int[][] dp) {
        for(int i=0; i<n ;i++){
             for(int j=0; j<m; j++){
                 
                 //base conditions
                 if(i>0 && j>0 && maze[i][j]==-1){
                   dp[i][j]=0;
                   continue;
                 }
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
         
         return dp[n-1][m-1];
       
       }
       
       static int mazeObstaclesTable(int n, int m, int[][] maze){
           int dp[][]=new int[n][m];
           for(int row[]: dp)
           Arrays.fill(row,-1);
           return mazeObstaclesUtilTable(n,m,maze,dp);
           
       }
    
    /**Space optimized 
     * Time Complexity: O(M*N)
     * Space Complexity: O(N)
    */
    static int mazeObstaclesSpace(int n, int m,int[][] maze){

        int prev[]=new int[n];
        for(int i=0; i<n; i++){
            int temp[]=new int[m];
            for(int j=0; j<m; j++){
                if(i>0 && j>0 && maze[i][j]==-1){
                    temp[j]=0;
                    continue;
                }
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
