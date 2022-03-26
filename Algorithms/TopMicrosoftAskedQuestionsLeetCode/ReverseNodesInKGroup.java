package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        /** 
        follow the below algorithm and the nodes will be reversed in k groups 
        */
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur=dummy,pre=dummy,next=dummy;
        int count=0;
        while(cur.next != null){
            count+=1;
            cur=cur.next;
        }
        //System.out.println(count);
        while(count >= k){
            cur = pre.next;
            next = cur.next;
            for(int i=1;i<k;i++){
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            pre = cur;
            count-=k;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        
    }
    
}
