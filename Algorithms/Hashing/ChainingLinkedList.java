package Algorithms.Hashing;

import org.graalvm.compiler.nodes.spi.ArrayLengthProvider.FindLengthMode;

/**
 * In hashing , the element(key) is stored on hash table using hash key
 * Hash function is used to compute hash key of the given key
 * if two or more keys have same hash key then it is called collision
 * collision can be handled using appropriate collision handling technique
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
public class ChainingLinkedList {

    public static final int N = 11;

    /**
     * Hash function  => modulo N(N=11)
     * collision handling technique => Chaining => array of linked list
     */

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

    static boolean search(Head h, int ele){
        Node q = h.start;
        if(h.start == null){
            return false;
        }
        while(q!=null){
            if(q.data == ele){
                return true;
            }else{
                q=q.next;
            }
        }
        return false;
    }

    static void fillHashTable(Head h[], int x[])
    {
        for (int ele : x) {
            int hashKey = ele % N;
            insertEnd(h[hashKey], ele);
        }
    }

    static boolean hashSearch(Head h[],int ele){
        int hashKey = ele % N;
        return search(h[hashKey], ele);
    }


    public static void main(String[] args) {

        Head h[] = new Head[N];
        int elements[]= {59,23,65,12,38,80,30,45,35};
        for (int i=0;i<h.length;i++) {
            h[i] = new Head();
            h[i].start = null;
        }
        fillHashTable(h, elements);
        System.out.println(hashSearch(h, 37));
    }
    
}
