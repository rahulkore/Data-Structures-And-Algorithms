package Algorithms.LinkedList;
/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

 */
class ListNode {
         int val;
         ListNode next;
         ListNode random;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
public class ReverseALinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode p,q,r;
        p = head;
        q = null;
        while(p!=null){
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        head = q;
        return head;
    }
    public static void main(String[] args) {
        
    }
    
}
