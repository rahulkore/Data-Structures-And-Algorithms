package Algorithms.Strings;

import java.util.*;

/**
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 
 * opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

 

Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:

Input: s = "[]"
Output: 0
Explanation: The string is already balanced.

 */
public class MinSwapsToMakeStringBalanced {

    public static long swapCount(String s)
    {
    
        // Keep track of '['
        List<Integer> pos = new ArrayList<>(); 
        for(int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '[')
                pos.add(i);
                
        // To count number of encountered '['
        int count = 0; 
        
        // To track position of next '[' in pos
        int p = 0;  
        
        // To store result
        int sum = 0; 
        
        char[] S = s.toCharArray(); 
        
        for(int i = 0; i < s.length(); ++i)
        {
            
            // Increment count and move p 
            // to next position
            if (S[i] == '[')
            {
                ++count;
                ++p;
            }
            else if (S[i] == ']')
                --count;
    
            // We have encountered an 
            // unbalanced part of string
            if (count < 0)
            {
                
                // Increment sum by number of 
                // swaps required i.e. position 
                // of next '[' - current position
                sum += pos.get(p) - i;
                char temp = S[i];
                S[i] = S[pos.get(p)];
                S[pos.get(p)] = temp;
                ++p;
    
                // Reset count to 1
                count = 1;
            }
        }
        return sum;
    }




    /**
     * stack solution of leetcode 1963
     * 
     * Algorithm :  

        Take a sample input : "] ] [ [ ] [ [ ]"
        Remove the balanced sub-portions from the given string using stack.
        We are left with a string of following format :
        ] [
        ] ] ] [ [ [
        see the pattern ?
        # of closing parenthesis followed by # of opening parenthesis
        The stack contains only the unbalanced string now. ( of even length )
        Take some smaller cases and see the pattern :
        ] [ : need 1 swap
        ] ] [ [ : need 1 swap to be made of 0th and 3rd index.
        ] ] ] [ [ [ : need 2 swap to be made
        1st swap between 0th and 5th index. The string becomes : [ ] ] [ [ ]
        2nd swap between 2nd and 3rd index.
        ✔️ Observations :

        Observation 1: If we are left with a string of length n in stack then, # of swaps needed:
        n=2 : 1 swap
        n=4 : 1 swap
        n=6 : 2 swap
        n=8 : 2 swap
        n=10 : 3 swap
        and so on.
     */
    public int minSwaps(String s) {
        // remove the balanced part from the given string
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '[')
                stack.push(ch);
            else {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(ch);
            }
        }
        int unb = stack.size()/2; // # of open or close bracket
        return (unb+1)/2;
    }   

    /**
     * If after removing balanced portions, we are left with a string of length n then, after 1 
     * swap we are left with an unbalanced string of length n-4 because 2 pairs got balanced.
        eg: n=6 i.e. "] ] ] [ [ ["
        1st swap : swap(0, 5) -> "[ ] ] [ [ ]" ( 2 pairs got created and unbalanced string has lengthn-4 )
        We need to keep swaping until this n becomes neg. i.e. no parenthesis is left for swapping.
     */

    public int minSwaps2(String s) {
        // remove the balanced part from the given string
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '[')
                stack.push(ch);
            else {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(ch);
            }
        }
        
        int n = stack.size();
        int swap = 0;
        while(n > 0) {
            swap++;
            n-=4;
        }
        return swap;
    }

    /**
     * 
     * As I mentioned above, using stack might not always be the optimal solution to the parenthesis
     *  problems.

        We are using stack to retain the unbalanced portions of the string. Or we can say, to get the number
        of open and close parenthesis that are out of order and needs swapping. Is it possible to find this
        number without using a stack ?
        Remember earlier, after removing balanced sub-portions the stack size = open brackets + close brackets.

        ✔️ Observations :

        As we only have two chars in our input string ( [ & ] ), we can use two variables.
     */

    public int minSwapsWithoutStack(String s) {
        int open = 0, unbalanced = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '[')
                open++;
            else {
                // check if we have found an open bracket before
                if(open > 0) {
                    // we have a proper pair
                    open--; // we used one open bracket for this pair
                } 
                else unbalanced++;
            }
        }
        // add the remaining open bracket which are left out for a pair
        unbalanced += open;
        unbalanced /= 2; // # of open brackets or # of close brackets
        return (unbalanced+1)/2;
    }
    public static void main(String[] args) {
        
    }
    
}
