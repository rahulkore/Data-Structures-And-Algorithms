package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**
 * Definition for a binary tree node.
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
public class ZigZagTraversal {

    public List<List<Integer>> ZigZag(TreeNode root) {
        List<List<Integer>> traversed = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return traversed;
        boolean flag = true;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                if (flag) subList.add(q.poll().val);
                else subList.add(0,q.poll().val);
            }
            flag=!flag;
            traversed.add(subList);
        }
        return traversed;
    }
    public static void main(String[] args) {
        
    }
    
}
