package Algorithms.Trees;
import java.util.*;
public class KthSmallestOrLargestElementInBST {

    /** Since inorder on a bst gives elements in ascending order */
    /** reverse the inorder traversal and we will get the kth largest element in a BST 
     * since reverse inorder gives elements in a descending order 
     */
    public int inOrder(TreeNode root,int k){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty())
                    break;
                root = st.pop();
                k--;
                if(k==0)
                    return root.val;
                root = root.right;
            }
        }
        return 0;
    }
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root,k);
    }
    public static void main(String[] args) {
        
    }
    
}
