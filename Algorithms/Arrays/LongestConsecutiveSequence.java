package Algorithms.Arrays;
import java.util.*;
/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int length = 0;
        Set<Integer> set = new HashSet<>();
        for(int ele : nums)
            set.add(ele);
        for(int ele : nums){
            if(!set.contains(ele-1)){
                int curele = ele;
                int curlen = 1;
                while(set.contains(curele+1)){
                    curlen++;
                    curele++;
                }
                length = Math.max(length,curlen);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        
    }
    
}
