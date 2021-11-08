package Algorithms.Trees;
import java.util.*;
/**
 * class TreeNode {
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
 */
public class PreOrderTraversal {

    /**recursive  approach */
    public void preorder(TreeNode root,List<Integer> traversed){
        if(root !=null){
            traversed.add(root.val);
            preorder(root.left,traversed);
            preorder(root.right,traversed);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        if(root == null) return traversed;
        preorder(root,traversed);
        return traversed;
    }

    /** Iterative Approach */
    public List<Integer> preOrderIterativeTraversal(TreeNode root,List<Integer> traversed){

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            traversed.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
            
        }
        return traversed;
    }
    public static void main(String[] args) {
        
    }
    
}
