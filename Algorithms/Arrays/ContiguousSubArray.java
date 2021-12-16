package Algorithms.Arrays;
import java.util.*;
/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 */
public class ContiguousSubArray {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        int maxi = 0;
        int sum = 0; 
        for(int i = 0;i<nums.length;i++) {
            // conert 0 to -1 and the question becomes max sub array with sum 0
            sum += nums[i]==0? -1 : 1; 
            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {
                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
    public static void main(String[] args) {
        
    }
    
}
