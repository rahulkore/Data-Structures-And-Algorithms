package Algorithms.Dynamic;
import java.util.*;
/**You are a professional robber planning to rob houses along a street. Each house has a
 *  certain amount of money stashed. All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses
 *  have a security system connected, and it will automatically contact the police if two 
 * adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum 
amount of money you can rob tonight without alerting the police. */
public class HouseRobber2 {

    public int hs(int[] nums, int n){
        int prev2,prev;
        prev2 = nums[0];
        prev = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int cur = Math.max(nums[i]+prev2,prev);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        int tempwithoutfirst[] = new int[nums.length-1];
        int tempwithoutlast[] = new int[nums.length-1];
        int k=0;
        int z=0;
        for(int i=0;i<nums.length;i++){
            if(i != 0){
                tempwithoutfirst[k++] = nums[i];
            }
            if(i != nums.length-1){
                tempwithoutlast[z++] = nums[i];
            }
        }
        return Math.max(hs(tempwithoutfirst,tempwithoutfirst.length),hs(tempwithoutlast,tempwithoutlast.length));
    }

    public static void main(String[] args) {
        
    }
    
}
