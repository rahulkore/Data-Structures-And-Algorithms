// https://leetcode.com/problems/house-robber/description/ 

// TC : O(n)
// SC : O(n)

class Solution {
    public int houseRobber(int[] money) {
        int n = money.length;
        if(n == 1) return money[0];
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int max_without_first_house = helper(money,n-1,dp,1);
        Arrays.fill(dp, -1);
        int max_without_last_house = helper(money,n-2,dp,0);
        return Math.max(max_without_first_house, max_without_last_house);
    }
    

    private int helper(int[]nums, int ind, int[] dp, int end) {
        if(ind == end) return nums[ind];
        if(ind < end) return 0;
        if(dp[ind] != -1) return dp[ind];
        int rob_current_house = nums[ind] + helper(nums, ind-2, dp, end);
        int not_rob_current_house = helper(nums, ind-1, dp, end);
        return dp[ind] = Math.max(rob_current_house, not_rob_current_house);
    }
}
