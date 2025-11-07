// https://leetcode.com/problems/maximum-length-of-pair-chain
/*
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

 
Example 1:
Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].

Example 2:
Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 

Constraints:
n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti <= 1000

*/
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
