package Algorithms.Trees;
import java.util.*;
/**
 Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.

 */

class Tuple {
    TreeNode node; 
    int vertical; // column
    int level;  // row
    public Tuple(TreeNode _node, int _vertical, int _level) {
        node = _node; 
        vertical = _vertical; 
        level = _level; 
    }
}
public class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); 
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0)); 
        while(!q.isEmpty()) {
            Tuple tuple = q.poll(); 
            TreeNode node = tuple.node; 
            int x = tuple.vertical; 
            int y = tuple.level;             
            
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            
            if(node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1)); 
            } 
            if(node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1)); 
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
    
}
