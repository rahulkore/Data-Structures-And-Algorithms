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
public class InOrderTraversal {
    
    public void inorder(TreeNode root,List<Integer> traversed){
        if(root !=null){
            inorder(root.left,traversed);
            traversed.add(root.val);
            inorder(root.right,traversed);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        if(root == null) return traversed;
        inorder(root,traversed);
        return traversed;
    }

    public List<Integer> inOrderIterative(TreeNode root, List<Integer> traversed){
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                if(st.isEmpty())
                    break;
                root = st.pop();
                traversed.add(root.val);
                root = root.right;
            }
        }
        return traversed;
    }
    public static void main(String[] args) {
        
    }
}
