package misc.medium;
/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        int maxProd=1;
        int minProd=1;
        int ans=Integer.MIN_VALUE;
        if(nums.length==1) return nums[0];
        for(int ele:nums){
            if(ele<0){
                int t = maxProd;
                maxProd = minProd;
                minProd = t;
            }
            maxProd = Math.max(maxProd*ele,ele);
            minProd = Math.min(minProd*ele,ele);
            ans = Math.max(ans,maxProd);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
