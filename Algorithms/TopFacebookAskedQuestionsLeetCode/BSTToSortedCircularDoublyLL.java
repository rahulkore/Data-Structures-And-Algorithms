package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers
 in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is
  the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree 
node should point to its predecessor, and the right pointer should point to its successor. 
You should return the pointer to the smallest element of the linked list.

 

Example 1:



Input: root = [4,2,5,1,3]


Output: [1,2,3,4,5]

Explanation: The figure below shows the transformed BST. The solid line indicates the successor 
relationship, while the dashed line means the predecessor relationship.

Example 2:

Input: root = [2,1,3]
Output: [1,2,3]
 */

 class Node{
     int val;
     Node left;
     Node right;
      
     Node(int _val){
         val = _val;
         left = null;
         right = null;
     }
 }
public class BSTToSortedCircularDoublyLL {


    /**Tc = O(n) */
    public Node treeToDoublyList(Node root) {
        
        if(root == null) return root;
        Stack<Node> st = new Stack<>();
        Node trav = root;
        Node head = new Node(0);
        Node prev = null;
        
        while(trav != null || !st.isEmpty()){
            while(trav != null){ // inorder traversal loop
                st.push(trav);
                trav = trav.left;
            }
            trav = st.pop(); // inorder pop when trav = null
            
            /** START : 
            Below is the extra checks and lines to make is circular Doubly linked list */
            if(head.right == null) head.right = trav;
            
            if(prev != null){
                prev.right = trav;
                trav.left = prev;
            }
            prev = trav;
            /** END : 
            Below is the extra checks and lines to make is circular Doubly linked list */
            
            trav = trav.right; // inorder traversal move to right 
        }
        
        /**Below lines handle/makes the linked list circular */
        prev.right = head.right;
        head.right.left = prev;
        
        return head.right;
    }

    public static void main(String[] args) {
        
    }
    
}
