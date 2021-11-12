package Algorithms.Trees;

public class InsertInABST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode toInsert = new TreeNode(val);
        if(root == null){
            root = toInsert;
            return root;
        }
        TreeNode q = root;
        while(q!=null){
            if(val < q.val){
                if(q.left == null){
                    q.left = toInsert;
                    return root;
                }else{
                    q=q.left;
                }
            }else{
                if(q.right == null){
                    q.right = toInsert;
                    return root;
                }else{
                    q=q.right;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
    
}
