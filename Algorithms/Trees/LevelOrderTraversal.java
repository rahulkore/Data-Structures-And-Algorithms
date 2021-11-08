package Algorithms.Trees;
import java.util.*;
/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]

 */


//Definition for a binary tree node.
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
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversed = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return traversed;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            traversed.add(subList);
        }
        return traversed;
    }
    public static void main(String[] args) {
        
    }
    
}
