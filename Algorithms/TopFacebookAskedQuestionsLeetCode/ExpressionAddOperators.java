package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**Given a string num that contains only digits and an integer target, return all possibilities to 
 * insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant 
 * expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6. */
public class ExpressionAddOperators {

    /**Tc = O(n*4^(n-1))
       Sc = O(n)
       DFS Approach serves better space complexity in this problem
    */
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    /** 5-3+4+5*2*3
    
        total = 5
              = total - 3 = 5 - 3 = 2
              = total + 4 = 2 + 4 = 6
              = total + 5 = 6 + 5 = 11
              = total - 5 + 5 * 2 = 16 for multiplication need to remember the prev addition to evaluate the correct ans
              = total - 5 * 2 + 5 * 2 * 3 = 36
    */
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1)); // concatenation of numbers 
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur); // initial point i.e. pos = 0
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
    public static void main(String[] args) {
        
    }
    
}
