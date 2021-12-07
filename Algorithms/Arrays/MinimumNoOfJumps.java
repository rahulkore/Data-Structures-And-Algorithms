package Algorithms.Arrays;
/**
 * leetcode => jump game 45
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

 */
public class MinimumNoOfJumps {

    public int jump(int[] nums) {
        int maxReachable = nums[0];
        int steps = nums[0];
        int jump=1;
        if(nums.length==0 || nums.length==1)
            return 0;
        if(nums[0]==0)
            return -1;
        for(int i=1;i<nums.length;i++){
            if(i==nums.length-1){
                return jump;
            }
            maxReachable = Math.max(maxReachable,i+nums[i]);
            steps--;
            if(steps==0){
                jump++;
                //if i overtakes maxReachable in case of no solution , but the question states that
                // there is a solution , so need to check the below ,
                // else , we can keep the check if it is not possible to reach the last index.
                // if(i>maxReachable){
                //     return -1;
                // }
                steps = maxReachable-i;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        
    }
    
}
