package Algorithms.Trees;
import java.util.*;
/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 */
public class ValidateBST {

    /** Using Iterative technique */
    public boolean inOrder(TreeNode root,List<Integer> traversed){
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty())
                    break;
                root = st.pop();
                if(traversed.size() != 0){
                    if(traversed.get(traversed.size()-1) >= root.val){
                         System.out.println(traversed.get(traversed.size()-1) + " "+ root.val);
                         return false;
                    }
                }
                traversed.add(root.val);
                root = root.right;
            }
        }
        return true;
    }

    /** Using Recursive Technique */
    private boolean checkBST(TreeNode node, long min, long max) {
        if(node == null) return true; 
        if(node.val <= min || node.val >= max) return false; 
        
        if(checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max)) {
            return true; 
        }
        return false; 
    }
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE); 
    }
    public static void main(String[] args) {
        
    }
    
}
