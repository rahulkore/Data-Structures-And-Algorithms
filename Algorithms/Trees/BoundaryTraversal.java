package Algorithms.Trees;
import java.util.*;
class Node {
    int data;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.data = val; }
    Node(int val, Node left, Node right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}
/** The below boundary traversal is for anti-clock wise 
 * But with the same logic and reversing everything we can also find out clock wise boundary traversal 
 * Anti-clock Wise =>
 * 1 -> add left boundary excluding leaves
 * 2 -> add leaves from using pre order
 * 3 -> add right boundaries in reverse excluding leaves
 * 
 * Clock-Wise =>
 * 1 -> add right boundary excluding leaves
 * 2 -> add leaves using post order 
 * 3 -> add left boundaries in reverse excluding leaves
 */
public class BoundaryTraversal {

    Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
        
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(0,cur.data); // to store in the reverse direction
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        // int i;
        // for (i = tmp.size()-1; i >= 0; --i) {
        //     res.add(tmp.get(i));
        // }
    }
    
    void addLeaves(Node root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<Integer>(); 
        if(node == null) return ans;
	    if(isLeaf(node) == false) ans.add(node.data); 
	    addLeftBoundary(node, ans); 
	    addLeaves(node, ans); 
	    addRightBoundary(node, ans); 
	    return ans;
	}
    public static void main(String[] args) {
        
    }
    
}
