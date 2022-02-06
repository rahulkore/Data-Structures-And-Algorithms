package Algorithms.Dynamic;
import java.util.*;

public class Fibonacci {

    /** Memoization of recursive solution  [Top Down Approach] => 
     * {from answer to base case and return}
     * Tc = O(n)
     * Sc = O(n) recursion stack space + O(n) dp array space 
     */
    public static int f(int n, int[] dp){
        if(n<=1) return n;
        
        if(dp[n]!= -1) return dp[n];
        return dp[n]= f(n-1,dp) + f(n-2,dp);
    }

    /** Tabulation [Bottom Up Approach ] => {From base case to answer}
     *  Tc = O(n)
     *  Sc = O(n) dp array space
    */
    public static int tabulation(int n, int[] dp){
        Arrays.fill(dp,-1);
        dp[0]= 0;
        dp[1]= 1;
  
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    /**Space Optimization 
     * use variables and avoid using dp 
     * Tc = O(n)
     * Sc = O(1)
     */
    public static int spaceOptimized(){

        int n=5;
  
        int prev2 = 0;
        int prev = 1;
        
        for(int i=2; i<=n; i++){
            int cur_i = prev2+ prev;
            prev2 = prev;
            prev= cur_i;
        }
        System.out.println(prev);
        return prev;

    }

    public static void main(String[] args) {

        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(f(n,dp));
        
    }
    
}
