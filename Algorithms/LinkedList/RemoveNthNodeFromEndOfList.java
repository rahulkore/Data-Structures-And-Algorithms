package Algorithms.LinkedList;
/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /** 
        traverse and then find out the length of the linked list 
        then subtract length - n 
        then again start iterating and delete the element ahead when count becomes
        length - n 
        this will give a O(2n) solution 
        */
        
        /** 
        Below is the O(n) solution where we use fast and slow pointers 
        */
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast  = start;
        ListNode slow  = start;
        /**The below step will create a window of size n in between 
        slow and fast and once the fast pointer reaches
        the last node the window size n will be from 
        last node */
        for(int i=0;i<n;i++) fast = fast.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
    public static void main(String[] args) {
        
    }
    
}
