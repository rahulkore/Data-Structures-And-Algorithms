package Algorithms.Recursion;
import java.util.*;
/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class Subset1 {

    private void findSubsets(int ind, int[] nums, List<List<Integer>> ans , List<Integer> ds){
        
        ans.add(new ArrayList<>(ds));
        for(int i =ind ; i<nums.length;i++){
            ds.add(nums[i]);
            findSubsets(i+1,nums,ans,ds);
            ds.remove(ds.size()-1);
        }
       
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
