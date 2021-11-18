package Algorithms.StackAndQueue;
import java.util.*;
public class NextSmallerElement {

    public int[] nextSmallerElements(int[] nums) {
        int n = nums.length; 
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--) {
            while(st.isEmpty() == false && st.peek() >= nums[i]) {
                st.pop(); 
            }
            if(st.isEmpty() == false) nge[i] = st.peek(); 
            else nge[i] = -1; 
            
            st.push(nums[i]);
        }
        return nge; 
    }
    public static void main(String[] args) {
        
    }
    
}
