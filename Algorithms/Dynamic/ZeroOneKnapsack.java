package Algorithms.Dynamic;
import java.util.*;
/** */
public class ZeroOneKnapsack {


    /**recursive memoization method
     * Tc = O(n*w)
     * Sc = O(n*w) + O(n)
     */
    public static int helper(int ind,int m,int[] weight, int[] value,int[][] dp){
        if(ind == 0){
            if(weight[0] <= m)
                return value[0];
            else return 0;
        }
        if(dp[ind][m] != -1)
            return dp[ind][m];
        int notTake = 0+helper(ind-1,m,weight,value,dp);
        int take=Integer.MIN_VALUE;
        if(weight[ind] <= m){
          take = value[ind] + helper(ind-1,m-weight[ind],weight,value,dp);  
        }
        return dp[ind][m] = Math.max(notTake,take);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        
        int[][] dp = new int[n][maxWeight+1];
        for(int[] ele:dp)
            Arrays.fill(ele,-1);
        return helper(n-1,maxWeight,weight,value,dp);
    }

    /**Tabulation method
     * Tc = O(n*w)
     * Sc = O(n*w)
     */

    static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight) {
        
        int[][] dp = new int[n][maxWeight+1];
        for(int m=weight[0];m<maxWeight+1;m++){
            dp[0][m] = value[0];
        }
        for(int i=1;i<n;i++){
            for(int m = 0;m<maxWeight+1;m++){
                
                int notTake = 0+dp[i-1][m];
                int take=Integer.MIN_VALUE;
                if(weight[i] <= m){
                  take = value[i] + dp[i-1][m-weight[i]];  
                }
                dp[i][m] = Math.max(notTake,take);
            }
        }
        return dp[n-1][maxWeight];
    }

    /**Space Optimized solution 
     * Tc = O(n*w)
     * Sc = O(w)
     */

    static int knapsackSpaceOptimized(int[] weight, int[] value, int n, int maxWeight) {
        
        int[] prev = new int[maxWeight+1];
        for(int m=weight[0];m<maxWeight+1;m++){
           prev[m] = value[0];
        }
        for(int i=1;i<n;i++){
            int[] cur = new int[maxWeight+1];
            cur[0] = 0;
            for(int m = 0;m<maxWeight+1;m++){
                
                int notTake = 0+prev[m];
                int take=Integer.MIN_VALUE;
                if(weight[i] <= m){
                  take = value[i] + prev[m-weight[i]];  
                }
                cur[m] = Math.max(notTake,take);
            }
            prev = cur;
        }
        return prev[maxWeight];
    }
    public static void main(String[] args) {
        
    }
    
}
