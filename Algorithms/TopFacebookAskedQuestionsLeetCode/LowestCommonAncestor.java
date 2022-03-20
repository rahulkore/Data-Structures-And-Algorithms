package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestor {

    public TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return null;
        if(root == p){
            return root;
        }
        if(root == q){
            return root;
        }
        /**The above can also be written as 
         * if(root == null || root == p || root == q) return root;
         */
        TreeNode leftTemp = LCA(root.left,p,q);
        TreeNode rightTemp = LCA(root.right,p,q);
        if(leftTemp!=null && rightTemp!=null) /**If both are not null means that is the lca so return root */
            return root;
        else if(leftTemp!=null)/**if left not null then return left */
            return leftTemp;
        else if(rightTemp!=null)/**If right not null then return right */
            return rightTemp;
        else return null;/**If both left & right null then return null */
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        return LCA(root,p,q);/**Finally gives/returns the LCA itself  */
    }
    public static void main(String[] args) {
        
    }
    
}
