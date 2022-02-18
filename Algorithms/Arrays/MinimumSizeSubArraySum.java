package Algorithms.Arrays;
/**Given an array of positive integers nums and a positive integer target, return the 
 * minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which 
 * the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint. */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int k = target;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int i=0, j=0;
        int s=0;
        while(i<=j && j<n){
            while(s<k && j<n){
                s += nums[j++];
            }
            while(s>=k && i<j){
                ans = Math.min(ans,j-i);
                s -= nums[i++];
            }
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
        
    }
    
}
