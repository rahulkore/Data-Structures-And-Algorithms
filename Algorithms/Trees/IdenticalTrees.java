package Algorithms.Trees;
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class IdenticalTrees {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return (p==q);
        return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String[] args) {
        
    }
    
}
