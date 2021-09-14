package DataStructures;

/**
 * Separate Nodee class
 */
class Nodee {

    /**
     * data and the next pointer
     */
    int data;
    Nodee next;
    Nodee prev;

    /**
     * Constructor to initialize the Nodee.
     * @param d
     */
    Nodee(int d){
        data = d;
        next = null; 
        prev = null;
    }
}

/**
 * Separate Head Class with start to point to the start of the 
 * linked list
 */
class Heads {
    Nodee start;
    Nodee last;
}

public class DoublyLinkedList {

    static void insertBeginning(Heads h, int ele){
        Nodee newNodee = new Nodee(ele);
        if(h.start == null){
            h.start = newNodee;
            h.last = newNodee;
        }else{
            newNodee.next = h.start;
            h.start.prev = newNodee;
            h.start = newNodee;
        }
        return;
    }

    static void insertEnd(Heads h, int ele){
        Nodee newNodee = new Nodee(ele);
        if(h.start == null){
            h.start = newNodee;
            h.last = newNodee;
        }else{
            h.last.next = newNodee;
            newNodee.prev = h.last;
            h.last = newNodee;
        }
        return;
    }

    static void deleteBeginning(Heads h){
        if(h.start == null){
            System.out.println("Linked List is empty");
            return;
        }
        if(h.start == h.last){
            h.start = null;
            h.last = null;
            return;
        }
        h.start = h.start.next;
        h.start.prev = null;
        return;
    }

    static void deleteEnd(Heads h){

        if(h.start == null){
            System.out.println("Linked List is empty");
            return;
        }
        if(h.start == h.last){
            h.start = null;
            h.last = null;
            return;
        }
        h.start = h.start.prev;
        h.start.next = null;
        return;
    }

    static void display(Heads h){
        Nodee q = h.start;
        while(q!=null){
            System.out.println(q.data);
            q=q.next;
        }
        return;
    }

    public static void main(String[] args) {

        Heads h = new Heads();
        h.last = null;
        h.start = null;
        insertBeginning(h, 1);
        insertEnd(h, 2);
        insertBeginning(h, 3);
        insertEnd(h, 4);
        display(h);
    }
    
}
