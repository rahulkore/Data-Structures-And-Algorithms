package Algorithms.Trees;
/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

 */
public class KthLargestElementInAStream {

    private class TreeNode {
        int val;
        int count = 1;
        TreeNode left, right;
        public TreeNode(){};
        public TreeNode(int val) {
            this.val = val;
        }
    }
    int k;
    TreeNode root;
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        // Build a BST with given array
        for (int num : nums) {
            root = addNumToBST(root, num);
        }
    }
    
    public int add(int val) {
        root = addNumToBST(root, val);
        return findNthLargest(k, root);
    } 
    
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
    public static void main(String[] args) {
        
    }
    
}
