package Algorithms.Arrays;
/**
 * ou are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].

The number of global inversions is the number of the different pairs (i, j) where:

0 <= i < j < n
nums[i] > nums[j]
The number of local inversions is the number of indices i where:

0 <= i < n - 1
nums[i] > nums[i + 1]
Return true if the number of global inversions is equal to the number of local inversions.

 

Example 1:

Input: nums = [1,0,2]
Output: true
Explanation: There is 1 global inversion and 1 local inversion.
 */
public class GlobalAndLocalInversions {

    /**
    O(nlogn) + O(n) Approach , count the inversions using merge sort 
    then count the local inversions using O(n) time 
    */
    public int merge(int[] x, int l, int m, int h){
        int i=l,j=m+1,k=0,inv=0;
        int temp[] = new int[x.length];
        while(i<=m && j<=h){
            if(x[i]<x[j]){
                temp[k++] = x[i++];
            }else{
                temp[k++] = x[j++];
                inv += m-i+1;
            }
        }
        while(i<=m) temp[k++] = x[i++];
        while(j<=h) temp[k++] = x[j++];
        k=0;
        for(i=l;i<=h;i++){
            x[i]=temp[k++];
        }
        return inv;
    }
    public int mergesort(int[] x,int l, int h){
        int inv=0;
        if(l<h){
            int m = (l+h)/2;
            inv+=mergesort(x,l,m);
            inv+=mergesort(x,m+1,h);
            inv+=merge(x,l,m,h);
        }
        return inv;
    }
    public boolean isIdealPermutation(int[] nums) {
        /**
        int count=0;
        for(int i =0;i<nums.length-1;i++)
            if(nums[i]>nums[i+1]) 
                count++;
        int inv = mergesort(nums,0,nums.length-1);
        System.out.println(inv + " " + count);
        return count==inv;
        */
        
        /**
        The logic is that there should only exist local inversions in the array. Global inversions apart from local inversions should be zero. That means an element at a particular position should only be at max 1 position away from it's position in the sorted array. If it is 2 or more positions away from it's position in the sorted array, that leads to existence of a global inversion which is not a local inversion. We should also make use of the fact that elements are in the range 0 to n-1. So abs(nums[i]-i) can be 1 at maximum, else we return 0.
        */
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i]-i)>1) return false;
        }
        return true;
        
    }
    public static void main(String[] args) {
        
    }
    
}
