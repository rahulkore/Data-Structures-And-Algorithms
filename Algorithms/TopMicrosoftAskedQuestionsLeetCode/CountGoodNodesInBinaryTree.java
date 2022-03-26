package Algorithms.TopMicrosoftAskedQuestionsLeetCode;

public class CountGoodNodesInBinaryTree {

    int count=0;
    public void traverse(TreeNode root,int max){
        if(root == null) return;
        if(root.val >= max){
            count+=1;
            max = root.val;
        }
        traverse(root.left,max);
        traverse(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        traverse(root,Integer.MIN_VALUE);
        return count;
    }
    public static void main(String[] args) {
        
    }
    
}
