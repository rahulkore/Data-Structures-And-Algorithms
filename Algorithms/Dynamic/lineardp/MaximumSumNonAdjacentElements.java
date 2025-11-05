// Given an integer array nums of size n. Return the maximum sum possible using the elements of nums such that no two elements taken are adjacent in nums.
// TC : O(n), SC : O(n)
class Solution {
    public int nonAdjacent(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(nums, nums.length-1, dp);
    }

    private int helper(int[] nums, int ind, int[] dp) {

        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int take = nums[ind] + helper(nums, ind-2, dp);
        int not_take = 0 + helper(nums, ind-1, dp);

        return dp[ind] = Math.max(take, not_take);
    }
}
