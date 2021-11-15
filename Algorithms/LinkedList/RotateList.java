package Algorithms.LinkedList;
/**
 * Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len =1;
        ListNode q = head;
        while(q.next!=null){
            q=q.next;
            len+=1;
        }
        q.next=head;
        //System.out.println(len);
        k  = k % len;
        k = len - k;
        q = head;
        while(k>1){
            q=q.next;
            k--;
        }
        head = q.next;
        q.next = null;
        return head;
    }
    public static void main(String[] args) {
        
    }
    
}
