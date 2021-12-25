package Algorithms.Trees;

public class DeleteInABSt {
        public TreeNode findMax(TreeNode node){
            if(node.right == null) return node;
            else return findMax(node.right);
        }
        public TreeNode findFather(TreeNode node,TreeNode q){
            while(node!=null){
                if(node.left == q || node.right == q)
                return node;
                else if(q.val < node.val)
                node = node.left;
                else node = node.right;
            }
            return null;
        }
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return null;
            /**Find the element */
            TreeNode q = root;
            while(q!=null){
                if(key == q.val)
                break;
                else if(key < q.val)
                q = q.left;
                else q = q.right;
            }
            if(q == null){ /**If element not found just return the root */
                return root;
            }
            /** First case : check if it is a leaf node 
             * 1] root
             * 2] non-root
             */
            TreeNode father  = findFather(root,q);
            if(q.left == null && q.right == null){
                if(root == q){
                    root = null;
                    return root;
                }else{
                    if(father.left == q)
                    father.left = null;
                    else father.right = null;
                    return root;
                }
            }

            /**Second Case : Has Left */
            if(q.left != null){
                TreeNode max = findMax(q.left);
                int maxval = max.val;
                deleteNode(root,maxval);
                q.val = maxval;
                return root;
            }

            /** Third Case : Has right 
             * 1] root
             * 2] non - root
            */
            if(q.right != null){
                if(q == root)
                root = root.right;
                else{
                    if(father.left == q)
                    father.left = q.right;
                    else father.right = q.right;
                }
                return root;
            }
            return root;
            
        }
    
    public static void main(String[] args) {
        
    }
    
}
