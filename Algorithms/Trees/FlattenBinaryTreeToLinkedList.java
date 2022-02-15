package Algorithms.Trees;
import java.util.*;
/**
 * Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 */
public class FlattenBinaryTreeToLinkedList {
    /**Tc  =O(n) */
    /**Approach 1 => Recursive */
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev  = root;
    }

    /**Approach 2 => Iterative */
    public void flattenIterative(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            if(cur.right != null) st.push(cur.right);
            if(cur.left != null) st.push(cur.left);
            if(!st.isEmpty()) cur.right = st.peek();
            cur.left = null;
        }
        
    }
    /** Approach 3 => Morris traversal technique */
    public void flattenMorris(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left != null){
                TreeNode prev = cur.left;
                while(prev.right != null)
                    prev=prev.right;
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur=cur.right;
        }
    }
    public static void main(String[] args) {
        
    }
    
}
