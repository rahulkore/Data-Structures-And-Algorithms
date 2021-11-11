package Algorithms.Trees;
import java.util.*;
public class MorrisInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) { /**if left is null then just visit and go to right */
                inorder.add(cur.val); 
                cur = cur.right; 
            }
            else { /**if left is not null then find the right most child of left sub tree */
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur; /**point the right of the rightmost child to the root => create a thread*/
                    cur = cur.left; 
                }
                else {
                    prev.right = null; /**it is the second visit , so remove the thread  */
                    inorder.add(cur.val); /** Insert the node in second visit => inorder */
                    cur = cur.right; 
                }
            }
        }
        return inorder; 
    }
    public static void main(String[] args) {
        
    }
    
}
