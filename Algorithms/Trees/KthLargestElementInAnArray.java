package Algorithms.Trees;
/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */
public class KthLargestElementInAnArray {

    private class TreeNode {
        int val;
        int count = 1;
        TreeNode left, right;
        public TreeNode(){};
        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode root;
    private int findNthLargest(int n, TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int rightCount = 0;
        if (node.right != null) {
            rightCount = node.right.count;
        }
        if (rightCount == n - 1) return node.val;
        if (rightCount < n - 1) {
            return findNthLargest(n - rightCount - 1, node.left);
        } else {
            return findNthLargest(n, node.right);
        }
        
    }
    private TreeNode addNumToBST(TreeNode node, int num) {
        if (node == null) {
            return new TreeNode(num);
        }
        
        node.count = node.count + 1;
        if (num < node.val) {
            node.left = addNumToBST(node.left, num);
        } else {
            node.right = addNumToBST(node.right, num);
        }
        return node;
    }

    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            root = addNumToBST(root, num);
        }
        return findNthLargest(k,root);
    }
    public static void main(String[] args) {
        
    }
    
}
