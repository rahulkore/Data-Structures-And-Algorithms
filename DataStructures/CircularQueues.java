package DataStructures;
class CircularQueue {
    static final int MAX = 4;
    int r,f;
    int count = 0;
    int q[] = new int[MAX];

    CircularQueue() {
        r = MAX-1;
        f = 0;
    }

    boolean isEmpty() {
        return (count == 0);
    }

    void push(int ele) {
        if(count == MAX){
            System.out.print("queue overflow");
        }else {
            r = (r+1)%MAX;
            count += 1;
            q[r] = ele;
        }
    }

    int deQueue(){
        if(isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }else{
            int x = q[f];
            f = (f+1) % MAX;
            count -= 1;
            return x;
        }
    }

    void dispay() {
        if(isEmpty()){
            System.out.println("Queue empty");
            return;
        }
        int i=f;
        while(true){
            System.out.print(q[i]);
            if(i==r){
                break;
            }
            i=(i+1) % MAX;
        }
    }
}

public class CircularQueues {

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue();
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
        // this push will happen because of circular queue implementation
        q.dispay();

        q.deQueue();
        q.dispay();
        q.push(5);
        q.dispay();
        q.deQueue();
        q.dispay();
    }
    
}
