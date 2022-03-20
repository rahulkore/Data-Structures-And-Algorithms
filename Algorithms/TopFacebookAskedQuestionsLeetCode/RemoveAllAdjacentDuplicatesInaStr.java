package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**You are given a string s consisting of lowercase English letters. A duplicate removal consists 
 * of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the 
answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this 
is the only possible move.  The result of this move is that the string is "aaca", of which only 
"aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay" */
public class RemoveAllAdjacentDuplicatesInaStr {

    /**Tc = O(2n) 
     * Brute force
    */
    public String removeDuplicates(String s) {
        LinkedList<Character> st = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()){
                if(st.peek() == s.charAt(i))
                    st.pop();
                else st.push(s.charAt(i));
            }else st.push(s.charAt(i));
        }
        
        String res = "";
        while(!st.isEmpty()){
            res += st.pollLast();
        }
        return res;
    }

    /**Tc = O(n) 
     * efficient solution
    */

    public String removeDuplicatesEfficient(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
    
}
