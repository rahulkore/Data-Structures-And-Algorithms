package Algorithms.Arrays;

public class MoveAllNegativeToOneSideOfArray {

    public static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void Arrange(int nums[]){
        int low = 0;
        int mid = 0;
        int high = nums.length;
        while(mid < high) {
            if(nums[mid] < 0){
                mid++;
            }else{
                swap(nums, mid, low);
                low++;
                mid++;
            }
        }
    }
    public static void main(String[] args) {

        int[] nums = {3,-2,5,-4,1,6,-1,7,-9};

        /**
         * move all the negative elements to the left 
         * same can be tweaked a little bit to 
         * move all the negative element to the right
         * like i=nums.length
         * j=nums.length-1;
         * and replace ++ with --
         */
        int i = -1;
        int j =0;
        while(j<nums.length){
            if(nums[j]<0){
                swap(nums,++i,j);
            }
            j++;
        }

        for (int ele : nums) {
            System.out.print(ele + " ");
        }
        
    }
    
}
