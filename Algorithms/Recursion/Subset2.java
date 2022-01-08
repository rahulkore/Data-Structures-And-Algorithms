package Algorithms.Recursion;
import java.util.*;
/**
 * Given an integer array nums that may contain duplicates, return all possible subsets
 *  (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class Subset2 {

    private void findSubsets(int ind, int[] nums, List<List<Integer>> ans , List<Integer> ds){
        
        ans.add(new ArrayList<>(ds));
        for(int i =ind ; i<nums.length;i++){
            if(ind!=i && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1,nums,ans,ds);
            ds.remove(ds.size()-1);
        }
       
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
