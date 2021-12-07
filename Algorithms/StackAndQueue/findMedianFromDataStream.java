package Algorithms.StackAndQueue;
import java.util.*;
public class findMedianFromDataStream {

    PriorityQueue<Integer> pqLeft;
    PriorityQueue<Integer> pqRight;
    
    public findMedianFromDataStream() {
        // Initialize priority queues
        pqLeft = new PriorityQueue<>(10, Collections.reverseOrder());
        pqRight = new PriorityQueue<>(10);
    }
    
    public void addNum(int num) {
        // offer to right if left is not empty and num is greater than left
        if (pqLeft.size() > 0 && num > pqLeft.peek())
            pqRight.offer(num);
        else 
            pqLeft.offer(num);
        // Balance the queues
        if (pqLeft.size() > pqRight.size()+1)   pqRight.offer(pqLeft.poll());
        if (pqRight.size() > pqLeft.size()+1)   pqLeft.offer(pqRight.poll());
    }
    
    public double findMedian() {
        // Take from largest, else average the two
        if (pqRight.size() > pqLeft.size()) return pqRight.peek();
        if (pqRight.size() < pqLeft.size()) return pqLeft.peek();
        else return (Double.valueOf(pqRight.peek())+ Double.valueOf(pqLeft.peek()))/2;
    }
    public static void main(String[] args) {
        
    }
    
}
