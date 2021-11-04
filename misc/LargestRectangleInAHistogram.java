package misc;
import java.util.*;
/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class LargestRectangleInAHistogram {

    // One pass solution 
    public int largestRectangleAreaOnePass(int[] heights) {
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();
        int maxA = 0; 
        for(int i = 0;i<=n;i++) {
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width; 
                if(st.isEmpty()) width = i; 
                else width = i - st.peek()-1; 
                
                // cout << i << " " << width << " " << height << endl; 
                maxA = Math.max(maxA, width * height); 
            }
            st.push(i); 
        }
        return maxA;
    }
    // Two pass solution 
    public int largestRectangleAreaTwoPass(int[] heights) {
        int n = heights.length;
        int[] leftsmaller = new int[n];
        int[] rightsmaller = new int[n];
        // to find the left next smaller element 
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftsmaller[i] = st.peek()+1;
            }else{
                leftsmaller[i] = 0;
            }
            st.push(i);
        }
        //empty the stack for next use
        while(!st.isEmpty())
            st.pop();
        
        // to find the right next smaller element
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightsmaller[i] = st.peek()-1;
            }else{
                rightsmaller[i] = n-1;
            }
            st.push(i);
        }
        int maxArea = 0;
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,heights[i]*(rightsmaller[i]-leftsmaller[i]+1));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        
    }
    
}
