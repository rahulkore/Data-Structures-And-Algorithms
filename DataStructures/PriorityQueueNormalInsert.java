package DataStructures;
/**
 * 
There are two types of priority queue => 1] descending priority queue 
                                         2] ascending priority queue
we will be implementing descending priority queue
Same implementation can be followed to make ascending priority queue 
In descending priority queue will be implementing both normal insert and normal delete.
 */
class PriorityQueue {
    static final int MAX = 4;
    int r,f;
    int q[] = new int[MAX];

    PriorityQueue() {
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

    /**
     * delete method will be modified to delete the maximum element first 
     * since priority takes more precedence over FIFO in priority queue
     * @return
     */
    int deQueue(){
        if(isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        int pos = f;
        int max = q[f];
        for(int i =f+1 ; i<=r ;i++){
            if(q[i]>max){
                max=q[i];
                pos=i;
            }
        }
        for(int i = pos ; i<r ; i++){
            q[i] = q[i+1];
        }
        r-=1;
        return max;
    }

    void dispay() {
        for(int i =f ; i<=r; i++){
            System.out.print(q[i]);
        }
    }
}
public class PriorityQueueNormalInsert {

    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue();

        pq.push(3);
        pq.push(7);
        pq.push(2);
        pq.dispay();
        pq.deQueue();
        pq.dispay();
        pq.deQueue();
        pq.dispay();
        
    }
    
}
