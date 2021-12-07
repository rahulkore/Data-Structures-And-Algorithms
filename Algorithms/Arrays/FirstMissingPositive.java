package Algorithms.Arrays;
import java.util.*;
/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
          if (nums.length == 1) {
          if (nums[0] != 1) return 1;
          if (nums[0] == 1) return 2;
        }
        Arrays.sort(nums);
        int maxNumber = Arrays.stream(nums).max().getAsInt();
        if (maxNumber < 1) return 1;
          int indexPos = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] > 0 && nums[i] != 0)
            {
              nums[indexPos++] = nums[i];
            }
        }
          int negativeIndex = indexPos;
          for(int j = indexPos; j < nums.length; j++)
              nums[indexPos] = -1;
          if(nums[0] != 1) return 1;
          for(int i = 0 ; i < negativeIndex - 1; i++)
          {
              if(nums[i + 1] != nums[i] + 1 && nums[i+1] != nums[i])
                  return nums[i] + 1;
          }
        return maxNumber + 1;
      }

    public static void main(String[] args) {
        
    }
    
}
