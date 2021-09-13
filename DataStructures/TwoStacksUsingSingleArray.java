class Stack {
    static final int MAX = 1000;
	int top1,top2;
	int a[] = new int[MAX]; // Maximum size of Stack


    boolean isEmpty1() {
        return (top1 < 0);
    }

    boolean isEmpty2() {
        return (top2 > MAX-1);
    }
    
    boolean isStackFull() {
        return (top1 + 1 == top2);
    }

    void push1(int element) {
        if(isStackFull()){
            System.out.print("Stack1 Full");
        } else {
            a[++top1] = element;
        }
    }

    void push2(int element) {
        if(isStackFull()){
            System.out.print("Stack2 Full");
        } else {
            a[--top2] = element;
        }
    }

    int pop1()
	{
		if (top1 < 0) {
			System.out.println("Stack1 Underflow");
			return 0;
		}
		else {
			int x = a[top1--];
			return x;
		}
	}

    int pop2()
	{
		if (top2 >= MAX) {
			System.out.println("Stack2 Underflow");
			return 0;
		}
		else {
			int x = a[top2++];
			return x;
		}
	}

    int peek1()
	{
		if (top1 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top1];
			return x;
		}
	}

    int peek2()
	{
		if (top2 >= MAX) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top2];
			return x;
		}
	}

    void print1(){
        for(int i = top1;i>-1;i--){
        System.out.print(" "+ a[i]);
        }
    }

    void print2(){
        for(int i = top2;i<MAX;i++){
        System.out.print(" "+ a[i]);
        }
    }

    Stack(){
        top1=-1;
        top2=MAX;
    }
}

public class TwoStacksUsingSingleArray {
    public static void main(String args[])
	{
		Stack s = new Stack();
		s.push1(10);
		s.push2(20);
		s.push1(30);
		System.out.println(s.pop1() + " Popped from stack1");
		System.out.println("Top element of stack2 is :" + s.peek2());
		System.out.print("Elements present in stack1 :");
		s.print1();
        System.out.print("Elements present in stack2 :");
        s.print2();
	}
}
