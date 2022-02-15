package Algorithms.InterviewExperience;
import java.util.*;
/**
 * Given the root of a binary tree and an integer targetSum,
 *  return all root-to-leaf paths where the sum of the node values 
 * in the path equals targetSum. Each path should be returned as a 
 * list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at 
any leaf node. A leaf is a node with no children.
 */
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
public class PathSum2 {

    public void getPaths(TreeNode root, int target, List<List<Integer>> ans, List<Integer> ds){
        
        if(root != null){
            ds.add(root.val);
            if(root.left == null && root.right == null && root.val == target){
                ans.add(new ArrayList<>(ds));
            }
            if(root.left != null)
            getPaths(root.left,target-root.val,ans,ds);
            if(root.right != null)
            getPaths(root.right,target-root.val,ans,ds);
            ds.remove(ds.size()-1);
            
        }
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        getPaths(root,targetSum,ans,ds);
        return ans;
        
    }

    public static void main(String[] args) {
        
    }
    
}
