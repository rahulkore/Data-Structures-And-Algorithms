package Algorithms.Arrays;
import java.util.*;
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class TrappingRainWater {

    /** Brute check left max and right max , then minimum from those minus curr height
    optimal 1 : prefix max array and suffix max array 
    most optimal : two pointer
    */
    public int trap(int[] height) {
        /**below is the prefix max and suffix max array solution with O(3n) tc and 
        O(2n) space complexity
        */
        // int[] prefixArray = new int[height.length];
        // int[] suffixArray = new int[height.length];
        // int leftmax=height[0];
        // int rightmax=height[height.length-1];
        // prefixArray[0] = leftmax;
        // suffixArray[suffixArray.length-1] = rightmax;
        // for(int i =1 ; i<height.length;i++){
        //     if(height[i]>leftmax){
        //         leftmax = height[i];
        //     }
        //     prefixArray[i] = leftmax;
        // }
        // for(int i=height.length-2;i>=0;i--){
        //     if(height[i]>rightmax){
        //         rightmax = height[i];
        //     }
        //     suffixArray[i]=rightmax;
        // }
        // int ans = 0;
        // for(int i=0;i<height.length;i++){
        //     ans += Math.min(prefixArray[i],suffixArray[i]) - height[i];
        // }
        // return ans;
        
        // below approach is the most optimal approach using two pointer technique
        int left = 0;
        int right = height.length-1;
        int leftmax = 0;
        int rightmax = 0;
        int ans=0;
        while(left < right){
            if(height[left] <= height[right]){
                leftmax = Math.max(leftmax,height[left]);
                ans += leftmax-height[left];
                left++;
            }else{
                rightmax = Math.max(rightmax,height[right]);
                ans += rightmax-height[right];
                right--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
