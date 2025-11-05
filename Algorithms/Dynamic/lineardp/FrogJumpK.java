// https://leetcode.com/problems/frog-jump/description/
// TC : O(n*k), SC : O(n)
class Solution {
    public int frogJump(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return helper(heights, 0, dp, k);
    }

    private int helper(int[] heights, int ind, int[] dp, int k) {
        // base case
        if(ind >= heights.length-1) return 0;
        if(dp[ind] != -1) return dp[ind];
        // Recurrence relation
        int mini = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(ind + i < heights.length) {
                int ans = Math.abs(heights[ind] - heights[i + ind]) + helper(heights, ind + i, dp, k);
                mini = Math.min(mini, ans);
            }
        }
        // return statement
        return dp[ind] = mini;
    }
}
