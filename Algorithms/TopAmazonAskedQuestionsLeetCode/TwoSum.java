package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**
 * Given an array of integers nums and an integer target,
 *  return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
    
}
