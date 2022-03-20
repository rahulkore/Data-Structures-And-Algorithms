package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**A valid number can be split up into these components (in order):

A decimal number or an integer.
(Optional) An 'e' or 'E', followed by an integer.
A decimal number can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
One of the following formats:
One or more digits, followed by a dot '.'.
One or more digits, followed by a dot '.', followed by one or more digits.
A dot '.', followed by one or more digits.
An integer can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
One or more digits.
For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", 
"2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid 
numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

Given a string s, return true if s is a valid number.

 

Example 1:

Input: s = "0"
Output: true
Example 2:

Input: s = "e"
Output: false
Example 3:

Input: s = "."
Output: false
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        Map<Integer,Map<Character,Integer>> state = new HashMap<>();
        for(int i=0;i<=10;i++) state.put(i,new HashMap<>());        
        state.get(0).put('-',1); state.get(0).put('+',2); state.get(0).put('d',3); state.get(0).put('.',4); state.get(0).put('.',10);        
        state.get(1).put('d',3); state.get(1).put('.',10);        
        state.get(2).put('d',3); state.get(2).put('.',10);        
        state.get(3).put('d',3); state.get(3).put('.',4); state.get(3).put('e',5);         
        state.get(4).put('d',6); state.get(4).put('e',5); 
        state.get(5).put('d',8); state.get(5).put('+',7); state.get(5).put('-',9);
        state.get(6).put('d',6); state.get(6).put('e',5);
        state.get(7).put('d',8);
        state.get(8).put('d',8);
        state.get(9).put('d',8);
        state.get(10).put('d',6);
        int curState = 0, nextState = 0;
        s = s.trim();
        for(char c: s.toCharArray()) {
            if(c == 'E')
            c = Character.toLowerCase(c);
            if(Character.isDigit(c)) nextState = state.get(curState).getOrDefault('d',-1);                
            else nextState = state.get(curState).getOrDefault(c,-1);                
            if(nextState==-1) return false;
            curState = nextState;            
        }
        return (curState==3 || curState==4 || curState==6 || curState==8);       
    }

    public static void main(String[] args) {
        
    }
    
}
