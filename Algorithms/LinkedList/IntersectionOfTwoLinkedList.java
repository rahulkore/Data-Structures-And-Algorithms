package Algorithms.LinkedList;
/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 */
public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1!=t2){
            t1 = t1==null ? headB : t1.next;
            t2 = t2==null ? headA : t2.next;
        }
        return t1;
    }
    public static void main(String[] args) {
        
    }
    
}
