package Algorithms.Arrays;
import java.util.*;
/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        /** 
        Time complexity will be O(nlogn)
        */
        Arrays.sort(nums);
        List<List<Integer>> ans =  new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){//to skip the same element which is selected 
                //for the ith element
                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[left] + nums[right] + nums[i] == 0){
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        // this is to skip the same element which is selected for left pointer
                        while(left < right && nums[left]==nums[left+1]) left++;
                        //this is to skip the same element which is selected for right pointer
                        while(left < right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] < 0-nums[i]) left++;
                    else right--;
                }
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
