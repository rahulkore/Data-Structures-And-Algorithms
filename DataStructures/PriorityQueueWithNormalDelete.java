package DataStructures;
/**
 * 
There are two types of priority queue => 1] descending priority queue 
                                         2] ascending priority queue
we will be implementing descending priority queue
Same implementation can be followed to make ascending priority queue 
In descending priority queue will be implementing both normal insert and normal delete.
 */

class PriQueue {
    static final int MAX = 4;
    int r,f;
    int q[] = new int[MAX];

    PriQueue() {
        r = -1;
        f = 0;
    }

    boolean isEmpty() {
        return (f == r+1);
    }

    /**
     * insert / push will modified in this case .
     * @param ele
     */
    void push(int ele) {
        if(r >= MAX-1){
            System.out.print("queue overflow");
            return;
        }
        int i;
        for(i=f;i<=r;i++){
            if(ele>q[i]){
                break;
            }
        }
        for(int j=r;j>=i;j--){
            q[j+1] = q[j];
        }
        q[i] = ele;
        r+=1;
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
public class PriorityQueueWithNormalDelete {

    public static void main(String[] args) {
        PriQueue pq = new PriQueue();
        pq.push(6);
        pq.push(2);
        pq.push(7);
        pq.push(1);

        pq.dispay();
    }
    
}
