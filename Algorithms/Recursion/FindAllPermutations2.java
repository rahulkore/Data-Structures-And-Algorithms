package Algorithms.Recursion;
import java.util.*;
/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

without freq an extra space 
 */
public class FindAllPermutations2 {

    private void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void findAllPermutations(int ind, int nums[], List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i =0 ; i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        for(int i=ind;i<nums.length;i++){
           swap(nums,i,ind);
           findAllPermutations(ind+1,nums,ans);
           swap(nums,i,ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findAllPermutations(0,nums,ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
