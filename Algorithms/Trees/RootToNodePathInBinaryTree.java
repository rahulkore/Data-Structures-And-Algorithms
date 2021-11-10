package Algorithms.Trees;
import java.util.*;
public class RootToNodePathInBinaryTree {

    private boolean getPath(TreeNode root, ArrayList<Integer> arr, int x) {
        if(root == null) {
            return false; 
        }
        /** Normal preorder traversal with some modifications */
        arr.add(root.val); /** If the element is found then just return the current path with true */
        if(root.val == x) {
            return true; 
        }
        if(getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true; /**If left or right any returns true then also return true with current path */
        }
        arr.remove(arr.size() - 1); /** still the element/node is not found then remove it from the path */
        return false; /** After all the recursion calls still not found then return false */
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>(); 
        if(A == null) return arr; 
        getPath(A, arr, B); 
        return arr; 
    }
    public static void main(String[] args) {
        
    }
    
}
