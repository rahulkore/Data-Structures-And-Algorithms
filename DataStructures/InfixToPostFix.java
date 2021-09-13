package DataStructures;

class Stack {
	static final int MAX = 1000;
	int top;
	char a[] = new char[MAX]; // Maximum size of Stack

	boolean isEmpty()
	{
		return (top < 0);
	}
	Stack()
	{
		top = -1;
	}

	void push(char x)
	{
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
		}
		else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
		}
	}

	char pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			char x = a[top--];
			return x;
		}
	}

	char peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			char x = a[top];
			return x;
		}
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

	boolean isOperand(char ch){
        if((ch>='a' && ch<='z') || (ch<='A' && ch>='Z'))
            return true;
        else return false;
    }

	static String convert(String infix) {
        Stack s = new Stack();
		char in[] = infix.toCharArray();
		String postFix = "";
		for(char ele : in){
			if(ele == '('){
				s.push(ele);
			}
			else if(ele == ')'){
				while(true){
					char x = s.pop();
					if(x == '(')
						break;
					postFix += x;
				}
			}
			else if(s.isOperand(ele)){
				postFix += ele;
			}
			else if(s.isEmpty()){
				s.push(ele);
			}
			else if(s.ipr(ele) > s.rpr(s.peek())){
				s.push(ele);
			}
			else{
				while(!s.isEmpty() && (s.ipr(ele) <= s.rpr(s.peek()))){
					char x = s.pop();
					postFix += x;
				}
				s.push(ele);
			}
		}

		while(!s.isEmpty()){
			postFix += s.pop();
		}

		return postFix;
    }
   
}

public class InfixToPostFix {

	public static void main(String[] args) {
		//String infix = "a+b*c";
		String infix = "m*j-(n+d)/f*w+z";
		System.out.print(Stack.convert(infix));
    }

}
