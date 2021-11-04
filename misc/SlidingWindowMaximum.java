package misc;
import java.util.*;
public class SlidingWindowMaximum {

    public static int[] main(String[] args) {
        int[] nums = new int[10];
        int k =3;
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int z =0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            // check for out of bound elements from the front 
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            //delete all the smaller elements from the back 
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){ // change to > means deleting all the greater element from the back and the output will become sliding window minimum
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1){
                ans[z++] = nums[dq.peek()];
            }
        }
        return ans;
    }
    
}
