package Algorithms.Trees;
/**There are two points to this problem
 * 1] Longest path between two nodes.
 * 2] The path does not need to traverse through the root.
 */
public class DiameterOfBinaryTree {
    /** method start */
    int ans=0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        ans = Math.max(lh+rh,ans);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int d = maxDepth(root);
        //System.out.println(d);
        return ans;
    }
    /** method end  */
    public static void main(String[] args) {
        
    }
    
}
