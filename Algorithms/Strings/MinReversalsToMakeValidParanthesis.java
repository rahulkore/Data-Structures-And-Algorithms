package Algorithms.Strings;
import java.util.*;
/**
 * Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. 
 * Find minimum number of bracket reversals to make the expression balanced.
Examples: 

Input:  exp = "}{"
Output: 2
We need to change '}' to '{' and '{' to
'}' so that the expression becomes balanced, 
the balanced expression is '{}'

Input:  exp = "{{{"
Output: Can't be made balanced using reversals

Input:  exp = "{{{{"
Output: 2 

Input:  exp = "{{{{}}"
Output: 1 

Input:  exp = "}{{}}{{{"
Output: 3
 */
public class MinReversalsToMakeValidParanthesis {

    /**
     *  One simple observation is, the string can be balanced only if total number of brackets
     *  is even
     *  (there must be equal no of ‘{‘ and ‘}’)
        A Naive Solution is to consider every bracket and recursively count number of reversals by 
        taking two cases 
        (i) keeping the bracket as it is 
        (ii) reversing the bracket. If we get a balanced 
        expression,
        we update result if number of steps followed for reaching here is smaller than 
        the minimum so 
        far.
        Time complexity of this solution is O(2^n). 
     * 
     */

    /**
     * An Efficient Solution can solve this problem in O(n) time. The idea is to first remove all 
     * balanced part of expression. For example, convert “}{{}}{{{” to “}{{{” by removing highlighted
     *  part. If we take a closer look, we can notice that, after removing balanced part, we always 
     * end up with an expression of the form }}…}{{…{, an expression that contains 0 or more number 
     * of closing brackets followed by 0 or more numbers of opening brackets. 
    How many minimum reversals are required for an expression of the form “}}..}{{..{” ?. 
        Let m be the total number of closing brackets and n be the number of opening brackets. We need ⌈m/2⌉ + ⌈n/2⌉
      reversals. For example }}}}{{ requires 2+1 reversals.
     * 
     */

    // Method count minimum reversal for
    //making an expression balanced.
    //Returns -1 if expression cannot be balanced

    //Tc = O(n)
    //Spc = O(n)
    static int countMinReversls(String expr)
    {
        int len = expr.length();
    
        // length of expression must be even to make
        // it balanced by using reversals.
        if (len%2 != 0)
        return -1;
    
        // After this loop, stack contains unbalanced
        // part of expression, i.e., expression of the
        // form "}}..}{{..{"
        Stack<Character> s=new Stack<>();
        
        for (int i=0; i<len; i++)
        {
            char c = expr.charAt(i);
            if (c =='}' && !s.empty())
            {
                if (s.peek()=='{')
                    s.pop();
                else
                    s.push(c);
            }
            else
                s.push(c);
        }
    
        // Length of the reduced expression
        // red_len = (m+n)
        int red_len = s.size();
    
        // count opening brackets at the end of
        // stack
        int n = 0;
        while (!s.empty() && s.peek() == '{')
        {
            s.pop();
            n++;
        }
    
        // return ceil(m/2) + ceil(n/2) which is
        // actually equal to (m+n)/2 + n%2 when
        // m+n is even.
        return (red_len/2 + n%2);
    }


    /**
     * Another efficient solution solve the problem in O(1) i.e. constant space. 
     * Since the expression only contains one type of brackets, the idea is to maintain two 
     * variables to keep count of left bracket as well as right bracket as we did in Length
     *  of the longest valid substring. If the expression has balanced brackets, then we decrement
     *  left variable else we increment right variable. Then all we need to return is
     *  ceil(left/2) + ceil(right/2).
     * 
     */

    static int countMinReversals(String expr)
    {
        int len = expr.length();
        int ans;
      
        // Expressions of odd lengths 
        // cannot be balanced
        if (len % 2 != 0) {
            return -1;
        }
        int left_brace = 0, right_brace = 0;
        for (int i = 0; i < len; i++) {
            char ch = expr.charAt(i);
          
            // If we find a left bracket then we simply
            // increment the left bracket
            if (ch == '{') {
                left_brace++;
            }
          
            // Else if left bracket is 0 then we find
            // unbalanced right bracket and increment
            // right bracket or if the expression
            // is balanced then we decrement left
            else {
                if (left_brace == 0) {
                    right_brace++;
                }
                else {
                    left_brace--;
                }
            }
        }
        ans = (int)(Math.ceil((0.0 + left_brace) / 2)
                    + Math.ceil((0.0 + right_brace) / 2));
        return ans;
    }


    int countMinReversalss(String str)
    {
        int temp=0, res=0, n=str.length();
        char[] s = str.toCharArray();
        if(n%2!=0)
                return -1;
        for(int i=0;i<n;i++){
            if(s[i]=='{')
                temp++;
            else{
                    if(temp==0){
                        res++;
                        temp++;
                }
                else
                    temp--;
            }
        }
        if(temp>0)
            res += temp/2;
        return res;
    }
    public static void main(String[] args) {
        
    }
    
}
