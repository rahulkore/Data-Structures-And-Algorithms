package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**You are given a perfect binary tree where all leaves are on the same level, and every parent has 
 * two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the 
next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each 
next pointer to point to its next right node, just like in Figure B. The serialized output is in 
level order as connected by the next pointers, with '#' signifying the end of each level. */
class Node{
    Node next;
    Node left;
    Node right;
    int val;
}
public class PopulatingnxtRightPointrInEachNode {


     /**Tc = O(n) Sc = O(n) */
     public Node connectt(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return root;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(!q.isEmpty() && i != size-1) node.next = q.peek();
                else node.next = null;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return root;
    }
    /**Tc = O(n) Sc = O(1) */
    public Node connect(Node root) {
        Node level_start=root;
        while(level_start!=null){
            Node cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
    
}
