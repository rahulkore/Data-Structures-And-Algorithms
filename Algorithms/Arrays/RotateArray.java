package Algorithms.Arrays;
import java.util.*;
/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]    
 */
public class RotateArray {

    public void reverse(int[] nums,int i, int j){
        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k<0){ // if k is negative then it means left rotation 
            // instead we do k+nums.length times right rotation 
            k=k+nums.length;
        }
        int p = nums.length-k;
        reverse(nums,0,p-1); // first reverse the left partition
        reverse(nums,p,nums.length-1); // then reverse the right partition
        reverse(nums,0,nums.length-1); // last reverse the whole array 
    }
    public static void main(String[] args) {
        
    }
    
}
