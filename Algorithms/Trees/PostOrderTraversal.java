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
public class PostOrderTraversal {

    public void postorder(TreeNode root,List<Integer> traversed){
        if(root !=null){
            postorder(root.left,traversed);
            postorder(root.right,traversed);
            traversed.add(root.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        if(root == null) return traversed;
        postorder(root,traversed);
        return traversed;
    }
    public List<Integer> postOrderIterativeUsingTwoStacks(TreeNode root, List<Integer> traversed){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            st2.push(node);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while(!st2.isEmpty())
            traversed.add(st2.pop().val);
        return traversed;
    }

    public List<Integer> postOrderIterativeUsingOneStack(TreeNode root, List<Integer> postOrder){
        Stack<TreeNode> st1 = new Stack<TreeNode>(); 
        if(root == null) return postOrder; 
        
        TreeNode current = root;  
        while(current != null || !st1.isEmpty()) {
            if(current != null){
                st1.push(current);
                current = current.left;
            }else{
                TreeNode temp = st1.peek().right;
                if (temp == null) {
                    temp = st1.pop();
                    postOrder.add(temp.val);
                    while (!st1.isEmpty() && temp == st1.peek().right) {
                        temp = st1.pop();
                        postOrder.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
      
        return postOrder;
    }
    public static void main(String[] args) {
        
    }
    
}
