package Algorithms.TopFacebookAskedQuestionsLeetCode;

public class InsertIntoASortedCircularLinkedList {

    /**SOLUTION 1 ONE PASS
Just need to be super clear about all the edge cases, especially when start is null, single node or 
has duplicates, and need to be able to divide the problem up clearly into categories

CASE 1 if there is tipping point in the list, which means that there are at least 2 distinct values, 
we name the node that has the max value to be the tipping point, the node after tipping point has 
the min value (min != max)

CASE 1A: if the to be inserted value x is in a climbing stage, which means there is a node 
satisfying node.val <= x <= node.next.val, we insert x after this node
CASE 1B: if the to be inserted value x is the new min or max value after its insertion, x needs 
to be inserted after the tipping point
CASE 2 if there is NO tipping point in the list, which means that all nodes in the list have the 
same value

we just insert x before we traverse back to start node
 */

class Node{
    int val;
    Node next;

    Node(int _val, Node _next){
        val = _val;
        next = _next;
    }
}
public Node insert(Node start, int x) {
    // if start is null, create a node pointing to itself and return
    if (start == null) {
        Node node = new Node(x, null);
        node.next = node;
        return node;
    }
    // is start is NOT null, try to insert it into correct position
    Node cur = start;
    while (true) {
        // case 1A: has a tipping point, still climbing
        if (cur.val < cur.next.val) { 
            if (cur.val <= x && x <= cur.next.val) { // x in between cur and next
                insertAfter(cur, x);
                break;
            }
        // case 1B: has a tipping point, about to return back to min node
        } else if (cur.val > cur.next.val) { 
            if (cur.val <= x || x <= cur.next.val) { // cur is the tipping point, x is max or min val
                insertAfter(cur, x);
                break;
            }
        // case 2: NO tipping point, all flat
        } else {
            if (cur.next == start) {  // insert x before we traverse all nodes back to start
                insertAfter(cur, x);
                break;
            }
        }
        // None of the above three cases met, go to next node
        cur = cur.next;
    }
    return start;
}

// insert value x after Node cur
private void insertAfter(Node cur, int x) {
    cur.next = new Node(x, cur.next);
}

    public static void main(String[] args) {
        
    }
    
}
