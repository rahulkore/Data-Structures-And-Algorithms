package Algorithms.LinkedList;

/**
 * Separate Node class
 */
class Node {

    /**
     * data and the next pointer
     */
    int data;
    int val;
    Node random;
    Node next;

    /**
     * Constructor to initialize the node.
     * @param d
     */
    Node(int d){
        data = d;
        next = null; 
    }

    public Node() {
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
        return;
    }

    static void insertEnd(Head h, int ele) {
        Node newNode = new Node(ele);
        if(h.start == null){
            h.start = newNode;
            return;
        }
        Node q = h.start;
        while(q.next != null){
            q=q.next;
        }
        q.next = newNode;
        return;
    }

    static void insertPos(Head h, int ele, int pos){
        Node newNode = new Node(ele);
        if(h.start == null){
            h.start = newNode;
            return;
        }
        Node q = h.start;
        for(int i =0 ; i< pos-2 ; i++){
            q = q.next;
        }

        newNode.next = q.next;
        q.next = newNode;
        return;
    }

    static void deletePos(Head h, int pos){
        if(h.start == null){
            System.out.println("Linked List Empty");
            return;
        }
        Node q = h.start;
        for(int i =0 ; i< pos-2 ; i++){
            q = q.next;
        }
        Node p = q.next;
        q.next = p.next;
        return;
    }

    static void deleteEle(Head h, int ele){
        if(h.start == null){
            System.out.println("Linked List Empty");
            return;
        }
        if(h.start.data == ele){
            h.start = h.start.next;
            return;
        }
        Node q = h.start;
        while(q.next != null){
            if(q.next.data == ele)
                break;
            else 
                q=q.next;
        }
        if(q.next == null){
            System.out.println("Element Not Found");
            return;
        }else{
            q.next = q.next.next;
        }
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

    static void deleteEnd(Head h){
        if(h.start == null){
            System.out.println("Linked List is empty");
            return;
        }
        if(h.start.next == null){
            Node q = h.start;
            h.start = q.next;
            return;
        }
        Node q = h.start;
        while(q.next.next != null){
            q=q.next;
        }
        q.next = null;
    }

    static void sortLL(Head h){
        Node i,j;
        int t;
        for(i = h.start ; i.next!= null ; i=i.next){
            for(j = h.start ; j.next != null ; j=j.next){
                if(j.data > j.next.data){
                    t = j.data;
                    j.data = j.next.data;
                    j.next.data = t;
                }
            }
        }
    }

    static void reverse(Head h){
        Node r,p,q=null;
        p = h.start;
        while(p != null){
            r = p.next;
            p.next = q;
            q=p;
            p=r;
        }
        h.start = q;
    }

    static void merge(Head h1,Head h2){
        Node q = h1.start;
        while(q.next != null){
            q = q.next;
        }
        q.next = h2.start;
    }

    static void split(Head h1, Head h2, int ele){
        Node q = h1.start;
        if(h1.start.data == ele){
            h2.start = h1.start;
            h1.start = null;
            return;
        }
        while(q.next != null){
            if(q.next.data == ele){
                break;
            }else{
                q=q.next;
            }
        }
        h2.start = q.next;
        q.next = null;
        return;
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
        insertEnd(h, 2); 
        insertEnd(h, 3);
        insertBeginning(h, 4);
        display(h);
        sortLL(h);
        System.out.println("sort");
        display(h);
        reverse(h);
        System.out.println("reverse");
        display(h);
        System.out.println("delete element");
        deleteEle(h, 2);
        display(h);
    }
}