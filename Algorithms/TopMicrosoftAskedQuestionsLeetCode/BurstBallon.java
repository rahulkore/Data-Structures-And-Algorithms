package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a 
 * number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins.
If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon
with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10 */
public class BurstBallon {

    /**Recursive memoization method 
     * Tc = O(n*3)
     * Sc = O(n*2) + O(n)
    */
    public int helper(int i, int j, int[] nums, int[][] dp){
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int k=i;k<=j;k++){
            int left = k==i ? 0 : helper(i,k-1,nums,dp);
            int right = k==j ? 0 : helper(k+1,j,nums,dp);
            int val = (i==0 ? 1 : nums[i-1]) * nums[k] * (j==nums.length-1 ? 1 : nums[j+1]);
            
            int profit = left + right + val;
            maxi = Math.max(maxi,profit);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoinsMemoization(int[] nums) {
        
        int dp[][] = new int[nums.length][nums.length];
        for(int[] ele : dp){
            Arrays.fill(ele,-1);
            
        }
        return helper(0,nums.length-1,nums,dp);
    }


    /**Tabulation method
     * Tc = O(n*3)
     * Sc = O(n*2)
     */
    public int maxCoins(int[] nums) {
        
        int dp[][] = new int[nums.length][nums.length];
        for(int g=0;g<nums.length;g++){
            for(int i=0,j=g;j<nums.length;i++,j++){
                int maxi = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int left = k==i ? 0 : dp[i][k-1]; // k==i means no left 
                    int right = k==j ? 0 : dp[k+1][j]; // k==j means no rigth
                    int val = (i==0 ? 1 : nums[i-1]) * nums[k] * (j==nums.length-1 ? 1 : nums[j+1]);
                    
                    int profit = left + right + val;
                    maxi = Math.max(maxi,profit);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[0][nums.length-1];
    }
    public static void main(String[] args) {
        
    }
    
}
