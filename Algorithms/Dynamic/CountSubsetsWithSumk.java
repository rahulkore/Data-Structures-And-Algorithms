package Algorithms.Dynamic;
import java.util.*;
/**You are given an array (0-based indexing) of positive integers and you have to tell how 
 * many different ways of selecting the elements from the array are there such that the sum 
 * of chosen elements is equal to the target number “tar”. */
public class CountSubsetsWithSumk {

    /**Recursiv Memoization solution
     * Tc = O(n*k)
     * Sc = O(n*k) + O(n)
     */
    static int subsetSumUtil(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return 1;
        if(ind == 0)
            return arr[0] == target ? 1 : 0;
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int notTaken = subsetSumUtil(ind-1,target,arr,dp);
        int taken = 0;
        if(arr[ind]<=target)
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        return dp[ind][target]=taken+notTaken;
    }

    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int dp[][] = new int[n][tar+1];
        for(int[] ele : dp)
        Arrays.fill(ele,-1);
        return subsetSumUtil(n-1,tar,num,dp);
        
    }

    /**Tabulation method
     * Tc = O(n*k)
     * Sc = O(n*k)
     */

    public static int findWaysTabulation(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int dp[][] = new int[n][tar+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        if(num[0]<=tar) dp[0][num[0]] = 1;
        for(int i=1;i<n;i++){
            for(int t=1;t<=tar;t++){
                int notTaken = dp[i-1][t];
                int taken = 0;
                if(num[i] <= t)
                    taken = dp[i-1][t-num[i]];
                dp[i][t] = taken + notTaken;
            }
        }

        return dp[n-1][tar];
        
    }

    /**Space Optimized */
    public static int findWaysSpaceOptimized(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int prev[] = new int[tar+1];
		prev[0] = 1;
        if(num[0]<=tar) prev[num[0]] = 1;
        for(int i=1;i<n;i++){
            int cur[] = new int[tar+1];
            cur[0] = 1;
            for(int t=1;t<=tar;t++){
                int notTaken = prev[t];
                int taken = 0;
                if(num[i] <= t)
                    taken = prev[t-num[i]];
               cur[t] = taken + notTaken;
            }
            prev = cur;
        }

        return prev[tar];
        
    }

    public static void main(String[] args) {
        
    }
    
}
