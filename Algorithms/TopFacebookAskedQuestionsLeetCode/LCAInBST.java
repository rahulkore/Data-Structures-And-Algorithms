package Algorithms.TopFacebookAskedQuestionsLeetCode;

public class LCAInBST {

    /** Iterative */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        if(root == null) return null;
        while(node!=null){
            if((p.val < node.val && q.val < node.val)){
                node = node.left;
            }else if((p.val > node.val && q.val > node.val)){
                node  = node.right;
            }else{
                return node;
            }
        }
        return node;
    }

    /**Recursive */

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int curr = root.val; 
        if(curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root; 
    }
    public static void main(String[] args) {
        
    }
    
}
