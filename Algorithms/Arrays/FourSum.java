package Algorithms.Arrays;
import java.util.*;
/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
public class FourSum {

    /** 
    The first solution for this problem can be =>
    sort 
    use three pointers i.e. i=0->n-1 j=i+1->n-1 k=j+1->n-1 then apply binary search for the 4th
    element , which will result in O(n^3log(n))
    n^3 for three loops and log(n) for binary serach
    
    The second solution can be done using 
    sort
    use two pointers i.e. i=0->n-1 j=i+1->n-1 and then since the array is sorted use 
    left right -> two pointer technique to find the remaining two elements from the right
    side of the array i.e. left = j+1 and right = n-1;
    O(n^3) at max which is the more optimal approach.
    
    
    we will be implementing the more optimal approach .
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int left = j+1;
                int right = n-1;
                while(left < right){
                    int sum = nums[left] + nums[right];
                    if(sum == target - nums[i] - nums[j]){
                        List<Integer> ds = new ArrayList<>();
                        ds.add(nums[i]);
                        ds.add(nums[j]);
                        ds.add(nums[left]);
                        ds.add(nums[right]);
                        ans.add(ds);
                        while(left < right && nums[left]==ds.get(2)) left++;
                        while(left < right && nums[right] == ds.get(3)) right--;
                    }else if(sum < target - nums[i] - nums[j]){
                        left++;
                    }else{
                        right--;
                    }
                }
                while(j+1<n && nums[j+1]==nums[j]) j++;
            }
            while(i+1<n && nums[i+1]==nums[i]) i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
