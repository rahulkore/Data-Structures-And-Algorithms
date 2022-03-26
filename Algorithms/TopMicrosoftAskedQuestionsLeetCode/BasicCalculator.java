package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the 
range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical 
expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5 */
public class BasicCalculator {

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        int num = 0;
        int len = s.length();
        for(int i = 0; i<len; i++){
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + c-'0';
            if (!Character.isDigit(c) && c!=' ' || i ==len -1){
                switch(lastSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                lastSign = c;
                num = 0;
            }
        }
        while (!stack.isEmpty())
            num +=stack.pop();
        return num;
    }

    public static void main(String[] args) {
        
    }
    
}
