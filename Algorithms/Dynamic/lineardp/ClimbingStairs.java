
// https://leetcode.com/problems/climbing-stairs/description/

// TC : O(n), SC : O(n)
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n, n-1, dp);
    }

    private int helper(int n, int ind, int[] dp) {

        if(ind <= 0) return 1;
        if(dp[ind] != -1) return dp[ind];
        return dp[ind] = helper(n, ind-1, dp) + helper(n, ind-2, dp);
    } 
}
