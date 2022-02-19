package Algorithms.Strings;
import java.util.*;
/**Given two strings s and t of lengths m and n respectively,
 *  return the minimum window substring of s such that every character in t 
 * (including duplicates) is included in the window. If there is no such substring, 
 * return the empty string "".

The test cases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t. */
public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        int defaultNum = t.length();
        int matchedNum = 0; 
        String ret = "";
        int min = s.length();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) - 1);
                if (tMap.get(c) >= 0)
                    matchedNum++;
            }
            while (matchedNum == defaultNum && start <= end) {
                // System.out.println(s.substring(start,end+1));
                if (min >= end - start + 1) {
                    min = end - start + 1;
                    ret = s.substring(start, end + 1);
                }
                char startC = s.charAt(start++);
                if (tMap.containsKey(startC)) {
                    if (tMap.get(startC) == 0) // exceed limit
                        matchedNum--;
                    tMap.put(startC, tMap.getOrDefault(startC, 0) + 1);
                }
            }
            
        }
        return ret;

    }
    public static void main(String[] args) {
        
    }
    
}
