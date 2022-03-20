package Algorithms.TopFacebookAskedQuestionsLeetCode;
/**You are given two strings order and s. All the words of order are unique and were sorted in
 *  some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, 
if a character x occurs before a character y in order, then x should occur before y in the permuted
 string.

Return any permutation of s that satisfies this property.

 

Example 1:

Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", 
"cdba", "cbda" are also valid outputs.
Example 2:

Input: order = "cbafg", s = "abcd"
Output: "cbad" */
public class CustomSortString {

    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) { ++count[c - 'a']; }  
        // count each char in s.
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {                            
            while (count[c - 'a']-- > 0) { sb.append(c); }    
            // sort chars both in s and order by the order of order.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }    
            // group chars in s but not in order.
        }
        return sb.toString();
   }

    public static void main(String[] args) {
        
    }
    
}
