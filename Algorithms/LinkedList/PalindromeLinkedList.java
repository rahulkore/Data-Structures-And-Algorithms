package Algorithms.LinkedList;
/**
 * Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
 */
public class PalindromeLinkedList {

    private ListNode reverse(ListNode p){
        ListNode q=null,r;
        while(p!=null){
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        return q;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        /** To find out the middle of the linked list , after the below operations slow will
        be pointing to the midde of the linked list , In even length linked list slow will be 
        pointing to left middle node , so reverse the right half and then check for palindrome
        by traversing one by one simultaneously on right and left half and return the ans */
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        while(slow != null){
            if(head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
    
}
