package Algorithms.Arrays;
/**You are given an integer array nums. You are initially positioned at the array's first index, 
 * and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
which makes it impossible to reach the last index. */
public class JumpGame {

    /**Tc = O(n) */
    public boolean canJump(int[] nums) {
        
        int maxReachable = nums[0];
        int steps = nums[0];
        int jump=1;
        if(nums.length==0 || nums.length==1)
            return true;
        if(nums[0]==0)
            return false;
        for(int i=1;i<nums.length;i++){
            if(i==nums.length-1){
                break;
            }
            if(steps <= 0) return false;
            maxReachable = Math.max(maxReachable,i+nums[i]);
            steps--;
            if(steps==0){
                jump++;
                steps = maxReachable-i;
            }
        }
        return maxReachable>=nums.length-1 ? true : false;
        
    }

    public static void main(String[] args) {
        
    }
    
}
