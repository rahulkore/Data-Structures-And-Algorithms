package Algorithms.LinkedList;

public class MergeSortInLinkedList {

    public ListNode sortList(ListNode head) {
        if(null == head || null == head.next) return head;
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode node){
        if(null == node || node.next == null) return node;
        ListNode a = node;
        ListNode b = node;
        ListNode prev = null;
        while(a!=null && b!=null && b.next!=null){
            prev = a;
            a = a.next;
            b = b.next.next;
        }
        prev.next = null;
        ListNode left = mergeSort(node);
        ListNode right = mergeSort(a);
        return merge(left,right);
    }
    private ListNode merge(ListNode left,ListNode right){
        ListNode head = new ListNode(0);
        ListNode index = head;
        while(left!=null && right!=null){
            if(left.val < right.val){
                index.next = left;
                left = left.next;
            }else{
                index.next = right;
                right = right.next;
            }
            index = index.next;
        }
        while(left != null){
            index.next = left;
            left = left.next;
            index = index.next;
        }
        while(right != null){
            index.next = right;
            right = right.next;
            index = index.next;
        }
        return head.next;
    }
    
}
