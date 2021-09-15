package DataStructures;

/**
 * Node having one data and two child which is pointed by two pointers left and right
 */
class Node {
    char data;
    Node left,right;

    Node(char ele){
        data = ele;
        left = null;
        right = null;
    }
}

/**
 * Head class having root which will point to the root of the 
 * BST (Binary Search Tree)
 */
class Head {
    Node root;
}
               
class Stack {
	static final int MAX = 1000;
	int top;
	Node a[] = new Node[MAX]; // Maximum size of Stack

	boolean isEmpty()
	{
		return (top < 0);
	}
	Stack()
	{
		top = -1;
	}

	boolean push(Node x)
	{
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	Node pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return null;
		}
		else {
			Node x = a[top--];
			return x;
		}
	}

    boolean isOperand(char ch){
        if((ch>='a' && ch<='z') || (ch<='A' && ch>='Z'))
            return true;
        else return false;
    }

}

public class ExpressionTreeUsingPostFix {

    static void construct(Head h, Stack s, String postFix){
		char postfix[] = postFix.toCharArray();
		for(char ele : postfix){
			Node p = new Node(ele);
			if(s.isOperand(ele)){
				s.push(p);
			}else{
				p.right = s.pop();
				p.left = s.pop();
				s.push(p);
			}
		}
		h.root = s.pop();
    }
	static void inorder(Node x){
        if(x != null){
            inorder(x.left);
            System.out.println(x.data);
            inorder(x.right);
        }
    }

    static void preorder(Node x){
        if(x != null){
            System.out.println(x.data);
            preorder(x.left);
            preorder(x.right);
        }
    }

    static void postorder(Node x){
        if(x != null){
            postorder(x.left);
            postorder(x.right);
            System.out.println(x.data);
        }
    }

    public static void main(String[] args) {
        String postFix = "abc*+";
        Head h = new Head();
        h.root = null;
        Stack s = new Stack();
        construct(h, s, postFix);

		System.out.println("Inorder");
        inorder(h.root);
        System.out.println("Preorder");
        preorder(h.root);
        System.out.println("PostOrder");
        postorder(h.root);
    }
    
}
