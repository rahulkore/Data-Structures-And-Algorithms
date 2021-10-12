package Algorithms.Recursion;
import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {

    /**
     * Not efficient code , which will end up in tle 
     *   public static void combinationsum(int[] candidates, int target,int n, int ind, Set<List<Integer>> ans,List<Integer> ds){
        if(ind == n){
            if(target == 0){
                //System.out.println(ds);
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(candidates[ind] <= target){
            ds.add(candidates[ind]);
            combinationsum(candidates,target-candidates[ind],n,ind+1,ans,ds);
            ds.remove(ds.size()-1);
        }
        combinationsum(candidates,target,n,ind+1,ans,ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        combinationsum(candidates,target,n,0,ans,ds);
        //System.out.println(ans);
        return new ArrayList<>(ans);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates,target);
    }
     * 
     */

    /**
     * The below approach wont end up in tle
     * 
     */

    public static void combinationsum(int[] candidates, int target,int n, int ind, List<List<Integer>> ans,List<Integer> ds){
        
        if(target == 0){
            //System.out.println(ds);
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        
        for(int i=ind;i<n;i++){
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            ds.add(candidates[i]);
            combinationsum(candidates,target-candidates[i],n,i+1,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        combinationsum(candidates,target,n,0,ans,ds);
        //System.out.println(ans);
        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {
        
    }
    
}
