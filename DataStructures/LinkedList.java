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

/**
 * ACtual implementation of the linked list 
 * with all the methods
 */
public class LinkedList {

    static void insertBeginning(Head h, int ele) {
        Node newNode = new Node(ele);
        if(h.start == null){
            h.start = newNode;
            return;
        }
        newNode.next = h.start;
        h.start = newNode;
    }

    static void insertEnd(Head h, int ele) {
        Node newNode = new Node(ele);
        if(h.start == null){
            h.start = newNode;
            return;
        }
        if(h.start.next == null){
            h.start.next = newNode;
            return;
        }
        Node q = h.start;
        while(q.next != null){
            q=q.next;
        }
        q.next = newNode;
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
    }
    public static void main(String[] args) {
        Head h = new Head();
        h.start = null;
        insertBeginning(h, 1);
        insertEnd(h, 2);
        insertEnd(h, 3);
        insertBeginning(h, 4);
        display(h);
    }
}