package Algorithms.LinkedList;
/**
 * 430. Flatten a Multilevel Doubly Linked List
Medium

3143

238

Add to List

Share
You are given a doubly linked list, which contains Nodees that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special Nodees. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the Nodees appear in a single-level, doubly linked list. Let curr be a Nodee with a child list. The Nodees in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The Nodees in the list must have all of their child pointers set to null.

 

Example 1:


Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation: The multilevel linked list in the input is shown.
After flattening the multilevel linked list it becomes:

 */
class Nodee {
    public int data;
    public Nodee prev;
    public Nodee next;
    public Nodee child;
    public Nodee bottom;
    Nodee(int _val){
        data = _val;
    }
}
public class FlattenAMultiLevelDoublyLinkedList {

    static Nodee last;// to keep the track of last visited Nodee 
    public Nodee recur(Nodee Nodee){
        last = Nodee;
        Nodee next  = Nodee.next;
        if(Nodee.child != null){
            Nodee.next = recur(Nodee.child);
        }
        if(next != null){
            last.next = recur(next);
        }
        return Nodee;
    }
    /** The below one is for doubly multilevel linked list */
    public Nodee flatten(Nodee head) {
        if(head==null) return head;
        /**Use the above recur method for flatening a multilevel single linke list */
        head  = recur(head);
        Nodee start = head;
        /**Now make the prev and child pointers to point properly */
        while(head.next!=null){
            head.next.prev=head;
            head.child=null;
            head.next.child=null;
            head = head.next;
        }
        return start;
    }

    /** The below one is for single linked list */

    Nodee mergeTwoLists(Nodee a, Nodee b) {
        
        Nodee temp = new Nodee(0);
        Nodee res = temp; 
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.bottom = a; 
                temp = temp.bottom; 
                a = a.bottom; 
            }
            else {
                temp.bottom = b;
                temp = temp.bottom; 
                b = b.bottom; 
            }
        }
        
        if(a != null) temp.bottom = a; 
        else temp.bottom = b;
        return res.bottom; 
    
    }
    Nodee flattenSingle(Nodee root)
    {
       
            if (root == null || root.next == null) 
                return root; 
      
            // recur for list on right 
            root.next = flattenSingle(root.next); 
      
            // now merge 
            root = mergeTwoLists(root, root.next); 
      
            // return the root 
            // it will be in turn merged with its left 
            return root; 
    }

    public static void main(String[] args) {
        
    }
    
}
