package Algorithms.Trees;
import java.util.HashMap;
import java.util.*;

/**
 * class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 */
public class MinimumTimeTakenToBurnBinaryTree {

    private static TreeNode bfsToMapParents(TreeNode root,HashMap<TreeNode, TreeNode> mpp, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == start) res = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    private static int findMaxDistance(HashMap<TreeNode, TreeNode> mpp, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode,Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        
        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;
            
            for(int i = 0;i<sz;i++) {
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
    public static int timeToBurnTree(TreeNode root, int start)
    {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }
    public static void main(String[] args) {

    }
    
}
