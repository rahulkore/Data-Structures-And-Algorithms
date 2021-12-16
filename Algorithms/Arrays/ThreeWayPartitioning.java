package Algorithms.Arrays;
/**
 * Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.


Example 1:

Input: 
n = 5
A[] = {1, 2, 3, 3, 4}
[a, b] = [1, 2]
Output: 1
Explanation: One possible arrangement is:
{1, 2, 3, 3, 4}. If you return a valid
arrangement, output will be 1.

 */
public class ThreeWayPartitioning {


    public static void swap(int nums[], int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    /**
     * Dutch flag algorithm
     * @param nums
     * @param a
     * @param b
     */
    public static void threeWayPartition(int nums[], int a, int b){
        int l=0,m=0,h=nums.length-1;
        while(m<=h){
            if(nums[m] >=a && nums[m]<=b){
                m++;
            }else if(nums[m]<a){
                swap(nums,l++,m++);
            }else{
                swap(nums,m,h--);
            }
        }
    } 

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4,0};
        int p = 5;
        threeWayPartition(nums, 1,3);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    
}
