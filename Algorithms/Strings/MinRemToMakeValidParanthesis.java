package Algorithms.Strings;
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

    class Pos{
        int ind;
        char val;
        Pos(int _ind, char _val){
            ind = _ind;
            val = _val;
        }
    }
    public String minRemoveToMakeValid(String s) {
        
        Stack<Pos> st = new Stack<>();
        int n = s.length();
        String ans="";
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                st.push(new Pos(i,'('));

            }else{
                if(s.charAt(i) == ')'){
                    if(!st.isEmpty() && st.peek().val == '('){
                        st.pop();
                       
                    }else{
                        st.push(new Pos(i,')'));
                    }
                }
            }
        }
        char[] arr = s.toCharArray();
        while(!st.isEmpty()){
            arr[st.peek().ind] =  ' ';
            st.pop();
        }
        for(char c : arr){
            if(c==' ')
                continue;
            ans+=c;
        }
        return ans;
        
    }
    public static void main(String[] args) {
        
    }
    
}
