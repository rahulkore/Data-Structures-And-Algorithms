package Algorithms.Recursion;
import java.util.*;
/**
 * combination sum 1 
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
 Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 
combinations for the given input.
 */
public class CombinationSum {


    public static void combinationsum(int[] candidates, int target,int n, int ind, List<List<Integer>> ans,List<Integer> ds){
        if(ind == n){
            if(target == 0){
                //System.out.println(ds);
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(candidates[ind] <= target){
            ds.add(candidates[ind]);
            combinationsum(candidates,target-candidates[ind],n,ind,ans,ds);
            ds.remove(ds.size()-1);
        }
        combinationsum(candidates,target,n,ind+1,ans,ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        combinationsum(candidates,target,n,0,ans,ds);
        //System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        int elements[] = {2,3,6,7};
        combinationSum(elements,7);
    }
    
}
