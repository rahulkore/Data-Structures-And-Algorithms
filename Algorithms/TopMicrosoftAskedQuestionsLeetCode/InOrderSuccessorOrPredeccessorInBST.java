package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class InOrderSuccessorOrPredeccessorInBST {


    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        while (root != null) {
            if (p.val >= root.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    public static void main(String[] args) {
        
    }
    
}
