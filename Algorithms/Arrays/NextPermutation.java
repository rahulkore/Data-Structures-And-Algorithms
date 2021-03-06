package Algorithms.Arrays;
/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]

 */
public class NextPermutation {

     /**
    1st step : traverse from last and find the index such that a[i]<a[i+1] => ind1
    2nd step : traverse from last and find the index such that a[i] > a[ind1] => ind2
    3rd step : swap(a[ind1],a[ind2])
    4th step : reverse from a[ind+1] to last
    */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1) return;
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int nums[],int i,int j){
        while(i<j) swap(nums,i++,j--);
    }
    public static void main(String[] args) {
        
    }
    
}
