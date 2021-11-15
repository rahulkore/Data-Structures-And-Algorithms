package Algorithms.Arrays;
import java.util.*;
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
public class UniquePaths {

    /** 
    recursive approach is the brute force approach.
    */
    public int recursiveSolution(int i, int j,int m, int n,int[][] dp){
        if(i == m-1 && j == n-1) return 1;
        if(i>=m || j>=n) return 0;
        //the below modifications are the dp modifications so that 
        // if a certain path is already computed then no need to visit and compute again
        // just use from the stored result.
        if(dp[i][j]!=-1) return dp[i][j];
        else return dp[i][j] = recursiveSolution(i+1,j,m,n,dp) + recursiveSolution(i,j+1,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] ele : dp)
        Arrays.fill(ele,-1);
        //return 
        // here if the matrix is 1x1 then need to do ans check , cause in this case 
        // dp[0][0]=-1;
        int ans =recursiveSolution(0,0,m,n,dp);
        //return ans==1? ans:dp[0][0];
        /** 
        more optimized solution is below 
        */
        double res=1;
        int N = m+n-2;
        int r  = m-1;// we can also take n-1 , either way it will give the correct ans.
        for(int i=1;i<=r;i++){
            res = res * (N-r+i)/i;
        }
        return (int)res;
    }
    public static void main(String[] args) {
        
    }
    
}
