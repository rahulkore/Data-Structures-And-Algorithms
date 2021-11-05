package misc;
import java.util.*;
/**
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepChar {

    public static int main(String[] args) {
        String s = "";
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
    
}
