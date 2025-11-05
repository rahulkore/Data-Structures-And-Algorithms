/*
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. 
The frog can jump from any step either one or two steps, provided it exists.
Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.

TC : O(n), SC : O(n)
*/
class Solution {
    public int frogJump(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return helper(heights, heights.length-1, dp);
    }

    private int helper(int[] heights, int ind, int[] dp) {
        // base case
        if(ind <= 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        // Recurrence relation
        int one_step = Math.abs(heights[ind] - heights[ind-1]) + helper(heights, ind-1, dp);
        int two_step = Integer.MAX_VALUE; 
        if(ind-2 >= 0)
            two_step = Math.abs(heights[ind] - heights[ind-2]) + helper(heights, ind-2, dp);
        // return statement
        return dp[ind] = Math.min(one_step, two_step);
    }
}
