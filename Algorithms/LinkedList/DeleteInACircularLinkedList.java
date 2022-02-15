package Algorithms.LinkedList;

public class DeleteInACircularLinkedList {

    /* Function to delete a given node from the list */
    static Node deleteNode(Node head, int key)
    {
        if (head == null)
            return null;
 
        // Find the required node
        Node curr = head, prev = new Node();
        while (curr.data != key) {
            if (curr.next == head) {
                System.out.printf("\nGiven node is not found"+ " in the list!!!");
                break;
            }
 
            prev = curr;
            curr = curr.next;
        }
 
        // Check if node is only node
        if (curr == head && curr.next == head) {
            head = null;
            return head;
        }
 
        // If more than one node, check if
        // it is first node
        if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = curr.next;
            prev.next = head;
        }
 
        // check if node is last node
        else if (curr.next == head) {
            prev.next = head;
        }
        else {
            prev.next = curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
    
}
