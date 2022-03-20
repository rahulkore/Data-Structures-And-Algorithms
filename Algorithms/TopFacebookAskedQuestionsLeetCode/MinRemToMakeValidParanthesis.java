package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**
 * Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

 */
public class MinRemToMakeValidParanthesis {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch))
                continue;
            if(ch == '(')
                stack.push(i);
            else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else stack.push(i);
            }
        }
        
        // if(stack.size() == 0) return "";
        
        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for(int i=0;i<s.length();i++)
            if(!set.contains(i))
                result.append(s.charAt(i));
        
        return result.toString();
    }
    public static void main(String[] args) {
        
    }
    
}
