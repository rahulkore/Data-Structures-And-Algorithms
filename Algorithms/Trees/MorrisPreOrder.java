package Algorithms.Trees;
import java.util.*;
public class MorrisPreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) {
                preOrder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur;  /**point the right of the rightmost child to the root => create a thread*/
                    preOrder.add(cur.val); /** Insert the node in first visit => inorder */
                    cur = cur.left; 
                }
                else {
                    prev.right = null; /**it is the second visit , so remove the thread  */
                    cur = cur.right; 
                }
            }
        }
        return preOrder; 
    }
    public static void main(String[] args) {
        
    }
    
}
