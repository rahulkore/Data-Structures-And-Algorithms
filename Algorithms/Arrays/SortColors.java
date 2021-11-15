package Algorithms.Arrays;
/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
 */
public class SortColors {

    /**
    Dutch flag algorithm can be used to solve this problem, with three pointers, in a 
    constant space.
    */
    public void sortColors(int[] nums) {
        int low = 0; 
        int mid = 0;
        int high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,mid,low);
                mid++;
                low++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        
    }
    
}
