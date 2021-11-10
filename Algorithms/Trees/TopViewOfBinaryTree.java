package Algorithms.Trees;
import java.util.*;
class Pairs{
    Node node;
    int verticalLine;
    Pairs(Node _node,int _verticalLine){
        node = _node;
        verticalLine = _verticalLine;
    }
}
public class TopViewOfBinaryTree {
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> q = new LinkedList<Pairs>();
        q.add(new Pairs(root, 0)); 
        while(!q.isEmpty()) {
            Pairs it = q.remove();
            int verticalLine = it.verticalLine; 
            Node temp = it.node; 
            if(map.get(verticalLine) == null) map.put(verticalLine, temp.data); 
            if(temp.left != null) {
                q.add(new Pairs(temp.left, verticalLine - 1)); 
            }
            if(temp.right != null) {
                q.add(new Pairs(temp.right, verticalLine + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
    public static void main(String[] args) {
        
    }
    
}
