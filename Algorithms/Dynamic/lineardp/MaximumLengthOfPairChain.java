// https://leetcode.com/problems/maximum-length-of-pair-chain

class Solution {
    public int findLongestChain(int[][] pairs) {
        int[][] dp = new int[pairs.length][pairs.length];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        Arrays.sort(pairs, (a,b) -> a[1]-b[1]);
        // return helper_memoize(pairs, dp);
        // return helper_memoize(pairs, 0, 0, dp);
        return greedy_method(pairs);
    }

    // TC : O(2^n), SC : O(n)
    private int helper(int[][] pairs, int prevInd, int ind) {
        if(ind >= pairs.length) return 0;
        int take = 0;
        if(ind==0 || pairs[prevInd][1] < pairs[ind][0]){
            take = 1 + helper(pairs, ind, ind+1);
        } 
        int not_take = 0 + helper(pairs, prevInd, ind+1);
        return Math.max(take, not_take);
    }

    // TC : O(n^2) , SC : O(n^2)
    private int helper_memoize(int[][] pairs, int prevInd, int ind, int[][] dp) {
        if(ind >= pairs.length) return 0;
        if(dp[prevInd][ind] != -1){
            return dp[prevInd][ind];
        }
        int take = 0;
        if(ind==0 || pairs[prevInd][1] < pairs[ind][0]){
            take = 1 + helper_memoize(pairs, ind, ind+1, dp);
        } 
        int not_take = 0 + helper_memoize(pairs, prevInd, ind+1, dp);
        return dp[prevInd][ind] = Math.max(take, not_take);
    }

    // TC : O(n), SC : O(1)
    private int greedy_method(int[][] pairs) {
        int n = pairs.length;
        int mini = Integer.MIN_VALUE;
        int ans = 0 ;
        for(int[] ele : pairs) {
            if(mini < ele[0]) {
                mini = ele[1];
                ans += 1;
            }
        }
        return ans;
    }
}
