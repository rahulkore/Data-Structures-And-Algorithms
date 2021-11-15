package Algorithms.Arrays;
import java.util.*;
/**
 * Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 */
public class ReversePairs {

    public int merge(int[] x, int l, int m, int h){
        int j = m+1,inv=0;
        int i;
        for(i =l;i<=m;i++){
            while(j<=h && x[i]>(2* (long) x[j])){ // for x[i] > 2 * x[j]
                j++;
            }
            inv += (j-(m+1));
        }
        i=l;
        j=m+1;
        int k=0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i<=m && j<=h){
            if(x[i]<=x[j]){
                temp.add(x[i++]);
            }else{
                temp.add(x[j++]);
                //inv += m-i; for normal inversions ,or global inversions.
            }
        }
        while(i<=m) temp.add(x[i++]);
        while(j<=h) temp.add(x[j++]);
        k=0;
        for(i=l;i<=h;i++){
            x[i]=temp.get(k++);//temp.get(i-l);
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
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
    public static void main(String[] args) {
        
    }
    
}
