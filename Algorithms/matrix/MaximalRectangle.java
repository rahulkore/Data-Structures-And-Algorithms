package Algorithms.matrix;
import java.util.*;
/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 */
public class MaximalRectangle {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();
        int maxA = 0; 
        for(int i = 0;i<=n;i++) {
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width; 
                if(st.isEmpty()) width = i; 
                else width = i - st.peek()-1; 
                maxA = Math.max(maxA, width * height); 
            }
            st.push(i); 
        }
        return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] heights  = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    heights[i][j] = matrix[i][j]=='1'?1:0;
                }
                else{
                    if(matrix[i][j] == '1'){
                        heights[i][j] = heights[i-1][j] + 1;
                    }else{
                        heights[i][j]=0;
                    }
                } 
            }
        }
        int max=0;
        /** 
         * Calculate largest rectangle in histogram for each and every row of 
         * newly calculated heights matrix
        */
        for(int i=0;i<n;i++){
            max = Math.max(max,largestRectangleArea(heights[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        
    }
    
}
