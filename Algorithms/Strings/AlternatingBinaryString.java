package Algorithms.Strings;
/**
 * You are given a binary string s. You are allowed to perform two types of operations on the string 
 * in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and 
vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 

Example 1:

Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
Example 2:

Input: s = "010"
Output: 0
Explanation: The string is already alternating.
Example 3:

Input: s = "1110"
Output: 1
Explanation: Use the second operation on the second element to make s = "1010".
 */
public class AlternatingBinaryString {

    public int minFlips(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int odd = 0;
        int even = 0;
        
        for(int i = 0; i < s.length(); i = i+2){
            if(s.charAt(i) == '1'){
                odd++;
            }
        }
        
        for(int i = 1; i < s.length(); i = i+2){
            if(s.charAt(i) == '1'){
                even++;
            }
        }
        
        boolean isEvenLength = s.length() % 2 == 0;
        if(isEvenLength){
            int half = s.length() / 2;
            return Math.min(Math.abs(half - odd) + Math.abs(0 - even),
                                 Math.abs(half - even) + Math.abs(0 - odd));
        }
        
        int smallHalf = s.length() / 2;
        int bigHalf = (s.length() + 1) / 2;
        
        int result = s.length();
        for(int i = 0; i < s.length(); i++){
            int temp = odd;
            
            if(s.charAt(i) == '1'){
                odd = even + 1;
                even = temp - 1;
            }
            else{
                odd = even;
                even = temp;
            }
                  
            int currentMin = Math.min(Math.abs(bigHalf - odd) + Math.abs(0 - even),
                                 Math.abs(smallHalf - even) + Math.abs(0 - odd));
            
            result = Math.min(currentMin, result);
        }
        
        return result;
    }
    public static void main(String[] args) {
        
    }
    
}
