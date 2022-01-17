package Algorithms.slidingWindow;
/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation:c
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

 */
public class MaxConsOnesAfterKFlip {

     /**
    Sliding Technique : O(n)
    slide the right pointer till we get k no of zeroes and that will become the size of
    the window , after that until the no of zeroes becomes <= k keep incrementing left 
    and right pointer with the same window size , and again when the no of zeroes become
    <= k keep left static and increment right and we will get the new window size 
    and this way we will get the maxx consecutive 1's after flipping k zeroes
    */
    public static int longestOnes(int[] nums, int k) {
        
        int left = 0;
        int right  = 0;
        int zeroes = 0;
        while(right < nums.length){
            if(nums[right] == 0)
                zeroes++;
            if(zeroes > k){
                if(nums[left] == 0)
                    zeroes--;
                left++;
            }
            right++;
        }
        
        return right-left;
    }
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums, 3));
    }
    
}
