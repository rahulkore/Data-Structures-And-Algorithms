package Algorithms.Trees;
import java.util.*;
/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
 */
class BSTiterator{
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true; 
    
    public BSTiterator(TreeNode root, boolean isReverse) {
        reverse = isReverse; 
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left); 
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        while(node != null) {
             stack.push(node);
             if(reverse == true) {
                 node = node.right; 
             } else {
                 node = node.left; 
             }
        }
    }
}

public class TwoSumInBST {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false; 
        BSTiterator l = new BSTiterator(root, false); 
        BSTiterator r = new BSTiterator(root, true); 
        
        int i = l.next(); 
        int j = r.next(); 
        while(i<j) {
            if(i + j == k) return true; 
            else if(i + j < k) i = l.next(); 
            else j = r.next(); 
        }
        return false; 
    }
    public static void main(String[] args) {
        
    }
    
}
