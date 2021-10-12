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
 */
public class FindAllPermutations {

    private void findAllPermutations(int ind, int nums[], List<List<Integer>> ans, List<Integer> ds,boolean[] freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                findAllPermutations(i,nums,ans,ds,freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[]= new boolean[nums.length];
        findAllPermutations(0,nums,ans,new ArrayList<>(),freq);
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
