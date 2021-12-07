package Algorithms.Arrays;
import java.util.*;
/**
 * LEETCODE QUESTION => 910 smallest range II
 * You are given an integer array nums and an integer k.

For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after changing the values at each index.

 

Example 1:

Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
Example 2:

Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
Example 3:

Input: nums = [1,3,6], k = 3
Output: 3
Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.


GFG => minimize the maximum difference between heights 
Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer. 
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

A slight modification of the problem can be found here.


Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.
Example 2:

Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between 
the largest and the smallest is 17-6 = 11. 

 */
public class MinimizeTheMaxDefBetHeights {
    
    class Pair{
        int value;
        int index;
        Pair(int _value, int _index){
            value = _value;
            index = _index;
        }
        public int getIndex(){
            return this.index;
        }
        public int getValue(){
            return this.value;
        }
    }
    
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        List<Pair> ph = new ArrayList<>();
        int visited[] = new int[n];
        for(int i=0;i<n;i++){
            // considering negative heights also 
            // if we want to discard the negative heights then just uncomment the check condition
            //if(nums[i]-k>=0)
                ph.add(new Pair(nums[i]-k,i));
            ph.add(new Pair(nums[i]+k,i));
        }
        Collections.sort(ph,new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.getValue() - p2.getValue();
            }
        });
        int ele=0;
        int left = 0;
        int right=0;
        int size = ph.size();
        while(ele<n && right<size){
            if(visited[ph.get(right).getIndex()] == 0)
                ele++;
            visited[ph.get(right).getIndex()]++;
            right++;
        }
        int ans = ph.get(right-1).getValue() - ph.get(left).getValue();
        while(right<size){
            if(visited[ph.get(left).getIndex()] == 1)
                ele--;
            visited[ph.get(left).getIndex()]--;
            left++;
            while(ele<n && right<size){
                if(visited[ph.get(right).getIndex()] == 0)
                    ele++;
                visited[ph.get(right).getIndex()]++;
                right++;
            }
            if(ele==n){
                ans = Math.min(ans,ph.get(right-1).getValue() - ph.get(left).getValue());
            }else{
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
