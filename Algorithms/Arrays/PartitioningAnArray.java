package Algorithms.Arrays;
/**
 * Partitioning an array 
 * 
 */
public class PartitioningAnArray {
    public static void swap(int nums[], int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void partition(int nums[], int p){
        /**
         * 0 to j-1 ->  <=p
         * j to i-1 ->  >p
         * i to end ->  unknown
         * 
         * It is almost similar to dutch flag algorithm 
         */

         int i=0,j=0;
         while(i<nums.length){
            if(nums[i] > p){
                i++;
            }else {
                swap(nums,i++,j++);
            }
         }
    }
    public static void main(String[] args) {
        int[] nums = {7,9,4,8,3,6,2,1};
        int p = 5;
        partition(nums, p);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    
}
