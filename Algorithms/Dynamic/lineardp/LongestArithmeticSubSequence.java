/**
problem link : https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference 


Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence 
such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].
 

Constraints:

1 <= arr.length <= 105
-104 <= arr[i], difference <= 104
*/

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int best = 1;
        // int[] dp = new int[arr.length];
        // for (int i = arr.length-1; i >= 0; i--) {
        //     Arrays.fill(dp, -1);
        //     best = Math.max(best, helper(i, arr, difference, dp));
        // }
        // return best;
        return helper_hashmap(arr, difference);
    }

    /**
        DP with memoization using recursive top down
        TC : O(n^2), SC : O(n) recursive stack and sp array
     */
    private int helper(int n, int[] arr, int difference, int[] dp) {
        
        if(n==0) return 1;
        if(n<0) return 0;

        if(dp[n] != -1) return dp[n];
        // pick 
        int maxi = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            int ans = 1;
            if(arr[n] - arr[i] == difference){
                ans = 1 + helper(i, arr, difference, dp);
            }
            maxi = Math.max(maxi, ans);
        }
        return dp[n] = maxi;
    }

    /**
        TC : O(n) , SC : O(n)
        This solution use hashmap to solve the problem in O(n) time complexity
        We will keep on updating the prev longest subsequence value at every node and 
        keep on updating based on that moving forward. 

        say if a[i] - difference is present in the map, then we can say that at this index i the length would be 1+(length at index i)
     */
    private int helper_hashmap(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = Integer.MIN_VALUE;
        for(int ele : arr){
            int before_ele = map.getOrDefault(ele-difference, 0); // if present then get the length uptil i else initialize as 0;
            map.put(ele, before_ele+1); // update current, if before_ele present then do a +1 or else this would be just 0+1;
            maxi = Math.max(maxi, before_ele+1);
        }
        return maxi;
    }
    
}
