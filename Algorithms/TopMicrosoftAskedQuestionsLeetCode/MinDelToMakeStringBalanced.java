package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**LC 1653 */
/**You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair
 of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

 

Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
Example 2:

Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters. */
public class MinDelToMakeStringBalanced {

    /** TC = O(n) */
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == 'b') st.push(c);
            else if(!st.isEmpty() && st.peek() == 'b') st.pop();
            else st.push(c);
        }
        // System.out.println(st.size());
        return (s.length() - st.size()) / 2;
    }
    public static void main(String[] args) {
        
    }
    
}
