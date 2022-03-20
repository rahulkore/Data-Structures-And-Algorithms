package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
public class RightViewOfBinaryTree {

    /** Level order traversal method */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = -1;
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            int levelSize = q.size();
            level++;
            for(int i =0 ;i<levelSize;i++){
                TreeNode temp = q.poll();
                map.put(level, temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    /**Recursive method  */
    public List<Integer> rightSideViews(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
    public static void main(String[] args) {
        
    }
    
}
