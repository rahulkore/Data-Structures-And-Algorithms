package Algorithms.InterviewExperience;

import java.util.*;

public class TernaryExpressionToBinaryTree
{
	// Class containing left and
	// right child of current
	// node and key value
	static class Node {
		
		public char data;
		public Node left, right;
		
		public Node(char data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	// Function to create a new node
	static Node createNewNode(char data)
	{
		Node node = new Node(data);
		return node;
	}

	// Function to print the preorder
	// traversal of the tree
	static void preorder(Node root)
	{
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	// Function to convert the expression to a binary tree
    //Tc = O(n)
	static Node convertExpression(String str)
	{
		Stack<Node> s = new Stack<Node>();

		// If the letter is the last letter of
		// the string or is of the type :letter: or ?letter:
		// we push the node pointer containing
		// the letter to the stack
		for (int i = str.length() - 1; i >= 0;) {
			if ((i == str.length() - 1)
				|| (i != 0 && ((str.charAt(i - 1) == ':'
								&& str.charAt(i + 1) == ':')
							|| (str.charAt(i - 1) == '?'
								&& str.charAt(i + 1) == ':')))) {
				s.push(createNewNode(str.charAt(i)));
			}

			// If we do not push the current
			// letter node to stack,
			// it means the top 2 nodes in
			// the stack currently are the
			// left and the right children of the current node
			// So pop these elements and assign them as the
			// children of the current letter node and then
			// push this node into the stack
			else {
				Node lnode = (Node)s.peek();
				s.pop();
				Node rnode = (Node)s.peek();
				s.pop();
				Node node = createNewNode(str.charAt(i));
				node.left = lnode;
				node.right = rnode;
				s.push(node);
			}
			i -= 2;
		}

		// Finally, there will be only 1 element
		// in the stack which will be the
		// root of the binary tree
		return (Node)s.peek();
	}
	
// Driver code
	public static void main(String[] args)
	{
		String str = "a?b?c:d:e";

		// Convert expression
		Node root = convertExpression(str);
	
		// Print the preorder traversal
		preorder(root);
	}

    // recursive idea is below
    // def getroot(exp):
    // global i
    // root=Node(exp[i])
    // i+=1
    // if i>=len(exp):
    //     return root
    // if exp[i]=='?':
    //     i+=1
    //     root.left=getroot(exp)
    // elif exp[i]==":":
    //     return root
    // i+=1
    // root.right=getroot(exp)
    // return root
}

// This code is contributed by divyesh072019.

