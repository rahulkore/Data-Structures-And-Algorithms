package Algorithms.Arrays;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
public class SubArraySumEqualsk {

    static int findSubarraySum(int arr[], int n, int sum)
    {
       
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int currsum = 0;
        for (int i = 0; i < n; i++) {
            currsum += arr[i];
            if (currsum == sum)
                res++;
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }
 
        return res;
    }
    public int subarraySum(int[] nums, int k) {
       return findSubarraySum(nums,nums.length,k);
    }
    public static void main(String[] args) {
        
    }
    
}
