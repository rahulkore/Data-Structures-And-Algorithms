package Algorithms.Trees;

public class ConstructBSTFromPreorder {

    /** Iterative Approach O(n*n) */
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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        if(preorder == null || preorder.length == 0 ) return root;
        for(int ele : preorder)
            root = insertIntoBST(root,ele);
        return root;
        
    }

    /** Recursive Approach with bound technique  O(n)*/
    public TreeNode bstFromPreorderRecursive(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode bstFromPreorder(int[] A, int bound, int[] i) {
        if (i[0] == A.length || A[i[0]] > bound) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstFromPreorder(A, root.val, i);
        root.right = bstFromPreorder(A, bound, i);
        return root;
    }
    public static void main(String[] args) {
        
    }
    
}
