package Algorithms.LinkedList;
/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLinkedList {

    public ListNode insertend(ListNode h,int data){
        if(h == null){
            h = new ListNode(data,null);
            return h;
        }
        ListNode q = h;
        while(q.next!=null){
            q=q.next;
        }
        q.next = new ListNode(data,null);
        return h;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /** The below method is the optimized version 
         * which uses no extra space 
         */
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        /** 
        without any extra space 
        */
        if(l1.val > l2.val){
            ListNode t;
            t = l1;
            l1 = l2;
            l2 = t;
        }
        ListNode ans=l1;
        while(l1!=null && l2!=null){
            ListNode temp = null;
            while(l1!=null && l1.val<=l2.val){
                temp=l1;
                l1=l1.next;
            }
            temp.next=l2;
            ListNode t;
            t=l1;
            l1=l2;
            l2=t;
        }
        return ans;
        /** The below approach uses extra space and another linked list creation */
        /**
        ListNode k = null; // using extra space 
        List<Integer> elements = new ArrayList<>();
        while(i!=null && j!=null){
            if(i.val < j.val){
                elements.add(i.val);
                i = i.next;
            }else{
                elements.add(j.val);
                j=j.next;
            }
        }
        while(i!=null){
            elements.add(i.val);
            i=i.next;
        }
        while(j!=null){
            elements.add(j.val);
            j=j.next;
        }
        
        for(int ele : elements){
            //System.out.println(ele);
            k = insertend(k,ele);
        }
        return k;
        */
    }
    public static void main(String[] args) {
        
    }
    
}
