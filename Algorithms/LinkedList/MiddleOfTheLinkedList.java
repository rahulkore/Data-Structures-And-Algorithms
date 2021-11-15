package Algorithms.LinkedList;
/**
 * Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
 */
public class MiddleOfTheLinkedList {

    /** More optimized approach is to just use slow and fast pointer technique */
    public ListNode middleNodeSlowFast(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /** This will result in O(n+n) */
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode q;
        q = head;
        int count = 0;
        while(q != null){
            count++;
            q=q.next;
        }
        int pos = (count/2) + 1;
        q=head;
        for(int i =0;i<pos-2;i++){
            q = q.next;
        }
        return q.next;
    }
    public static void main(String[] args) {
        
    }
    
}
