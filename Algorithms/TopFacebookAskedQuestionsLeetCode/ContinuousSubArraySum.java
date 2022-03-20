package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**Given an integer array nums and an integer k, return true if nums has a continuous subarray 
 * of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a 
multiple of k.

 

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 */
public class ContinuousSubArraySum {

    /**We iterate through the input array exactly once, keeping track of the running sum mod k 
     * of the elements in the process. If we find that a running sum value at index j has been 
     * previously seen before in some earlier index i in the array, then we know that the sub-array 
     * (i,j] contains a desired sum. */

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k; 
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
    
}
