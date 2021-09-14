package DataStructures;

/**
 * Separate Node class
 */
class Node {

    /**
     * data and the next pointer
     */
    int data;
    Node next;

    /**
     * Constructor to initialize the node.
     * @param d
     */
    Node(int d){
        data = d;
        next = null; 
    }
}

/**
 * Separate Head Class with start to point to the start of the 
 * linked list
 */
class Head {
    Node last;
}

public class CircularLinkedList {

    static void insertBeginning(Head h, int ele){
        Node newNode = new Node(ele);
        if(h.last == null){
            h.last = newNode;
            newNode.next = newNode;
            return;  
        }
        newNode.next = h.last.next;
        h.last.next = newNode;
        return;
    }

    static void insertEnd(Head h, int ele){
        Node newNode = new Node(ele);
        if(h.last == null){
            h.last = newNode;
            newNode.next = newNode;
            return;  
        }
        newNode.next = h.last.next;
        h.last.next = newNode;
        h.last = newNode;
        return;
    }

    static void deleteBeginning(Head h){
        if(h.last == null){
            System.out.println("Empty Linked List");
            return;  
        }
        Node q = h.last.next;
        if(q.next == q){
            h.last = null;
            return;
        }else
            h.last.next = q.next;
        return;
    }

    static void deleteEnd(Head h){
        if(h.last == null){
            System.out.println("Empty Linked List");
            return;  
        }
        Node p = h.last.next;
        if(p.next == p){
            h.last = null;
            return;
        }else{
            Node q = h.last.next;
            while(q.next != h.last){
                q=q.next;
            }
            q.next = h.last.next;
            h.last = q;
        }
        return;
    }

    public static void main(String[] args) {
        Head h = new Head();
        h.last = null;
        
    }
    
}
