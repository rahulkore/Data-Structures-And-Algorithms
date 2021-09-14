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
    Node start;
}

public class StacksUsingLinkedList {

    static void insertBeginning(Head h, int ele) {
        Node newNode = new Node(ele);
        if(h.start == null){
            h.start = newNode;
            return;
        }
        newNode.next = h.start;
        h.start = newNode;
        return;
    }

    static void deleteBeginning(Head h){
        if(h.start == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node q = h.start;
        h.start = q.next;
    }

    static void display(Head h) {
        if(h.start == null){
            System.out.println("Linked List empty");
            return;
        }
        Node q = h.start;
        while(q != null){
            System.out.println(q.data);
            q=q.next;
        }
        return;
    }

    public static void main(String[] args) {
        Head h = new Head();
        h.start = null;
        insertBeginning(h, 1);
        insertBeginning(h, 4);
        deleteBeginning(h);
        display(h);
    }
    
}
