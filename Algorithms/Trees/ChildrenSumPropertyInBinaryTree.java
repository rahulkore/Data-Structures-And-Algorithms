package Algorithms.Trees;

public class ChildrenSumPropertyInBinaryTree {

    public static void childrenSum(TreeNode root){
        if(root == null) return;
        int child=0;
        if(root.left != null) child+=root.left.val;/**calculate the left child sum */
        if(root.right != null) child+=root.right.val;/** calculate the right child sum */
        if(child >= root.val){/** if greater then assign to cur node */
            root.val = child;
        }else{
            if(root.left != null) root.left.val = root.val;/** if less then assign to left child the cur node val */
            else if(root.right != null) root.right.val = root.val;
        }

        childrenSum(root.left);/** go to left */
        childrenSum(root.right);/** go to right */

        int tot = 0;
        if(root.left != null) tot += root.left.val;/** backtrack and sum left child val */
        if(root.right != null) tot += root.right.val;/** backtrack and sum right child val */
        if(root.left != null || root.right != null) root.val = tot; /**if not leave then update  */

    }
    public static void main(String[] args) {
        
    }
    
}
