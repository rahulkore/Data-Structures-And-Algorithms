package Algorithms.RemainingImpQuestions;



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class MergeKSortedLists {

    /**
     * Code of merge two sorted lists
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLinkedList(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        if(l1==null) return l2;
        if(l2 == null) return l1;
        if(l1.val > l2.val){
            ListNode t;
            t = l1;
            l1 = l2;
            l2 = t;
        }
        ListNode ans=l1;
        while(l1!=null && l2!=null){
            ListNode temp = null;
            // System.out.println(l1.val);
            while(l1!=null && l1.val<=l2.val){
                // System.out.println(l1.val + " " + l2.val);
                temp=l1;
                l1=l1.next;
            }
            // System.out.println(l1.val);
            temp.next=l2;
            ListNode t;
            t=l1;
            l1=l2;
            l2=t;
            // System.out.println(l2.val);
        } 
        return ans;
    } 
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        ListNode merged = lists[0];
        for(int i=1;i<lists.length;i++){
            merged = mergeTwoLinkedList(merged,lists[i]);
        }
        return merged;
    }
}
