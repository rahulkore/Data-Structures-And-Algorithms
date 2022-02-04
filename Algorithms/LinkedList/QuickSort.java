package Algorithms.LinkedList;

public class QuickSort {

    static Node head;
 
    static void addNode(int data)
    {
        if (head == null) {
            head = new Node(data);
            return;
        }
 
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
 
        Node newNode = new Node(data);
        curr.next = newNode;
    }
 
    static void printList(Node n)
    {
        while (n != null) {
            System.out.print(n.data);
            System.out.print(" ");
            n = n.next;
        }
    }
 
    // takes first and last node,
    // but do not break any links in
    // the whole linked list
    static Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;
 
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
 
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }
 
        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
 
        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }
 
    static void sort(Node start, Node end)
    {
        if(start == null || start == end|| start == end.next )
            return;
 
        // split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);
 
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);
 
        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                 && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }
 
    // Driver Code
public static void main(String[] args)
    {
        addNode(30);
        addNode(3);
        addNode(4);
        addNode(20);
        addNode(5);
 
        Node n = head;
        while (n.next != null)
            n = n.next;
 
        System.out.println("Linked List before sorting");
        printList(head);
 
        sort(head, n);
 
        System.out.println("\nLinked List after sorting");
        printList(head);
    }
    
}
