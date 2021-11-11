package Algorithms.Trees;

public class SearchInABST {

    public TreeNode searchBST(TreeNode root, int val) {
        while(root !=null && root.val!=val){
            root = val<root.val ? root.left : root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
    
}
