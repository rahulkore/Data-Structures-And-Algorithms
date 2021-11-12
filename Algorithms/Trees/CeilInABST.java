package Algorithms.Trees;

public class CeilInABST {

    public  static int findCeil(TreeNode root, int key) {

        int ceil = -1; 
        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                return ceil;
            }

            if (key > root.val) {
                root = root.right;
            }
            else {
                ceil = root.val; 
                root = root.left;
            }
        }
        return ceil;

    }
    public static void main(String[] args) {
        
    }
    
}
