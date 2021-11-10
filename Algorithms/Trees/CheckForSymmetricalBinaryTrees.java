package Algorithms.Trees;

/** returns true if the binary tree is symmetrical / mirror image of left = right /
 * mirror image of right = left 
*/
public class CheckForSymmetricalBinaryTrees {

    public boolean isSymmetry(TreeNode left,TreeNode right){
        if(left==null || right == null) return left==right;
        if(left.val != right.val) return false;
        return isSymmetry(left.left,right.right) && isSymmetry(left.right,right.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetry(root.left,root.right);
    }
    public static void main(String[] args) {
        
    }
    
}
