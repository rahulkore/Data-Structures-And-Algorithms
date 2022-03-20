package Algorithms.TopFacebookAskedQuestionsLeetCode;
/**A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
 * and removing all non-alphanumeric characters, it reads the same forward and backward. 
 * Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome. */
public class ValidPalindrome {

    /**Brute Force  */
    public boolean isPalindromeCheck(String s){
        int left = 0;
        int right = s.length()-1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        
        String data = "";
        for(char c : s.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                data += Character.toLowerCase(c);
            }else if((c >= '0' && c <= '9')){
                data += c;
            }
        }
        System.out.println(data);
        if(isPalindromeCheck(data))
            return true;
        else return false;
    }

    /** Optimal solution  */

    public boolean isPalindromeEfficient(String s) {
        if (s.isEmpty()) {
             return true;
         }
         int head = 0, tail = s.length() - 1;
         char cHead, cTail;
         while(head <= tail) {
             cHead = s.charAt(head);
             cTail = s.charAt(tail);
             if (!Character.isLetterOrDigit(cHead)) {
                 head++;
             } else if(!Character.isLetterOrDigit(cTail)) {
                 tail--;
             } else {
                 if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                     return false;
                 }
                 head++;
                 tail--;
             }
         }
         
         return true;
     }

    public static void main(String[] args) {
        
    }
    
}
