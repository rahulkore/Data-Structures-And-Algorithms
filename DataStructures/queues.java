package DataStructures;

class Queue {
    static final int MAX = 4;
    int r,f;
    int q[] = new int[MAX];

    Queue() {
        r = -1;
        f = 0;
    }

    boolean isEmpty() {
        return (f == r+1);
    }

    void push(int ele) {
        if(r >= MAX-1){
            System.out.print("queue overflow");
        }else {
            q[++r] = ele;
        }
    }

    int deQueue(){
        if(isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }else{
            return q[f++];
        }
    }

    void dispay() {
        for(int i =f ; i<=r; i++){
            System.out.print(q[i]);
        }
    }
}

public class Queues {


    public static void main(String[] args) {

        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.dispay();

        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();

        q.dispay();

        q.push(5);
    }
    
}
