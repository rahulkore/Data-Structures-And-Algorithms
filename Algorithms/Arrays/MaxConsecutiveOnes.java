package Algorithms.Arrays;
/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ans = 0;
        for(int ele : nums){
            if(ele==1){
                count++;
            }else{
                count=0;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
