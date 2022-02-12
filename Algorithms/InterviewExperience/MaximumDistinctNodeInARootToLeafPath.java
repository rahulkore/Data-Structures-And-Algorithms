package Algorithms.InterviewExperience;


// Java program to find count of distinct nodes
// on a path with maximum distinct nodes.
import java.util.*;
class MaximumDistinctNodeInARootToLeafPath
{

// A node of binary tree
static class Node
{
	int data;
	Node left, right;
};

// A utility function to create a new Binary
// Tree node
static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = temp.right = null;
	return temp;
}

static int largestUinquePathUtil(Node node, HashMap<Integer,
													Integer> m)
{
	if (node == null)
		return m.size();

	// put this node into hash
	if(m.containsKey(node.data))
	{
		m.put(node.data, m.get(node.data) + 1);
	}
	else
	{
		m.put(node.data, 1);
	}

	int max_path = Math.max(largestUinquePathUtil(node.left, m),
							largestUinquePathUtil(node.right, m));

	// remove current node from path "hash"
	if(m.containsKey(node.data))
	{
		m.put(node.data, m.get(node.data) - 1);
	}

	// if we reached a condition where all duplicate value
	// of current node is deleted
	if (m.get(node.data) == 0)
		m.remove(node.data);

	return max_path;
}

// A utility function to find long unique value path
static int largestUinquePath(Node node)
{
	if (node == null)
		return 0;

	// hash that store all node value
	HashMap<Integer,
			Integer> hash = new HashMap<Integer,
										Integer>();

	// return max length unique value path
	return largestUinquePathUtil(node, hash);
}

// Driver Code
public static void main(String[] args)
{
	// Create binary tree shown in above figure
	Node root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.left = newNode(6);
	root.right.right = newNode(7);
	root.right.left.right = newNode(8);
	root.right.right.right = newNode(9);

	System.out.println(largestUinquePath(root));
}
}

// This code is contributed by Princi Singh

