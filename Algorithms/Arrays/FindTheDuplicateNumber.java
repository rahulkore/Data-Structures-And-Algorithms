package Algorithms.Arrays;
/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */
public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
           
        }while(slow!=fast);
       
        fast  = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
            
        }
        
        return slow;
    }

    public static void main(String[] args) {

        int nums[] = {3,2,3,4,2};
        System.out.print(findDuplicate(nums));
        
    }
    
}
