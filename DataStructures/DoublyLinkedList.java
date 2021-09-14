package DataStructures;

import org.graalvm.compiler.graph.Node;

/**
 * Separate Node class
 */
class Node {

    /**
     * data and the next pointer
     */
    int data;
    Node next;
    Node prev;

    /**
     * Constructor to initialize the node.
     * @param d
     */
    Node(int d){
        data = d;
        next = null; 
        prev = null;
    }
}

/**
 * Separate Head Class with start to point to the start of the 
 * linked list
 */
class Head {
    Node start;
    Node last;
}

public class DoublyLinkedList {

    static void insertBeginning(Head h, int ele){
        Node newNode = new Node(ele);
        if(h.start == null){
            h.start = newNode;
            h.last = newNode;
            return;
        }else{
            
        }
    }

    static void insertEnd(Head h, int ele){

    }

    static void deleteBeginning(Head h){

    }

    static void deleteEnd(Head h){

    }

    static void display(Head h){

    }

    public static void main(String[] args) {

        Head h = new Head();
        h.last = null;
        h.start = null;
        
    }
    
}
