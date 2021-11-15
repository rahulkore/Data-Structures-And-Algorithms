package Algorithms.Arrays;
import java.util.*;
/**
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubStringWithoutRepeatingCharacters {
/** In brute we can only store the character and once 
 * repeat is found then we can remove from top until the repeated ele is not found
 * 
 * And 
 * 
 * In optimized just store the indices as well 
 * and calculate the left based upon that and after that keep on updating the indexes of 
 * elements .
 */
    public int lengthOfLongestSubstring(String s) {
        int left  = 0;
        int right = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(right < s.length()){
            if(map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right))+1);
            map.put(s.charAt(right),right);
            max = Math.max(max, right-left+1);
            right += 1;
        }
        return max;
    }
    public static void main(String[] args) {
        
    }
    
}
