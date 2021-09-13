package DataStructures;

class Stack {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; // Maximum size of Stack

	boolean isEmpty()
	{
		return (top < 0);
	}
	Stack()
	{
		top = -1;
	}

	boolean push(int x)
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

	int pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top--];
			return x;
		}
	}

	int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top];
			return x;
		}
	}

    boolean isOperand(char ch){
        if((ch>='a' && ch<='z') || (ch<='A' && ch>='Z'))
            return true;
        else return false;
    }
	
    int ipr(char ch){
        switch(ch){
            case '(' : return 3;
            case '*' :
            case '/' :
            case '%' : return 2;
            case '+' :
            case '-' : return 1;
        }
        return -1;
    }

    int rpr(char ch){
        switch(ch){
            case '(' : return 0;
            case '*' :
            case '/' :
            case '%' : return 2;
            case '+' :
            case '-' : return 1;
        }
        return -1;
    }

    void convert(String infix) {
        Stack s = new Stack();
        int l = infix.length();

    }

}

public class InfixToPostFix {
    
    public static void main(String[] args) {

    }
}
