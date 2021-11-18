package Algorithms.BinarySearch;
/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */
public class SingleElementInASortedArray {

    /** using Xor  */
    public int singleNonDuplicateusingXor(int[] nums) {
        int low = 0, high = nums.length - 2; 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            if(nums[mid] == nums[mid^1]) {
                low = mid + 1; 
            } 
            else {
                high = mid - 1; 
            }
        }
        return nums[low]; 
    }
    public int singleNonDuplicate(int[] nums) {
        /** left half : 1st instance even , 2nd instance odd 
        right half : 1st instance odd ,2nd instace even */
        int low = 0;
        int high = nums.length-2;
        while(low<=high){
            //System.out.println(low + " " + high);
            int mid =  (low + high) / 2;
            // check if left half 
            if(mid % 2 == 0 ){
                if(nums[mid] == nums[mid+1]){ // yes left half , then make low go to right 
                    low = mid+1;
                }else{ // not left half , then make high go to left
                    high = mid-1;
                }
            }else if(mid % 2 != 0){
                if(nums[mid] == nums[mid-1]){ // yes left half , then make low go to right 
                    low = mid+1;
                }else{// not left half , then make high go to left
                    high = mid-1;
                }
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        
    }
    
}
