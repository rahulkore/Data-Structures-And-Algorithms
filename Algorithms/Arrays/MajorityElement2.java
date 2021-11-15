package Algorithms.Arrays;
import java.util.*;
/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
 */
public class MajorityElement2 {

    /** 
    Boyer Moore voting algorithm.
    */
    public List<Integer> majorityElement(int[] nums) {
        int count1=0,count2=0,ele1=0,ele2=0;
        for(int i : nums){
            if(ele1 == i) count1++;
            else if(ele2 == i) count2++;
            else if(count1 == 0) {
                ele1=i;
                count1=1;
            }
            else if(count2 == 0) {
                ele2=i;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1=0;
        count2=0;
        for(int i : nums){
            if(ele1==i) count1++;
            if(ele2==i) count2++;
        }
        if(count1 > Math.floor(nums.length/3)) ans.add(ele1);
        if(ele1!=ele2)
        if(count2 > Math.floor(nums.length/3)) ans.add(ele2);
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
