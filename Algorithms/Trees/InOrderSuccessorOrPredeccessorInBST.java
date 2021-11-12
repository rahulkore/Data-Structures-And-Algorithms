package Algorithms.Trees;

public class InOrderSuccessorOrPredeccessorInBST {


    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                successor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return successor;
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
