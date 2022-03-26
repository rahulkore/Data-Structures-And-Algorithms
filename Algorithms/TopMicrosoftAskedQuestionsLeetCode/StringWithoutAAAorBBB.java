package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
/**Given two integers a and b, return any string s such that:

s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
The substring 'aaa' does not occur in s, and
The substring 'bbb' does not occur in s.
 

Example 1:

Input: a = 1, b = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: a = 4, b = 1
Output: "aabaa" */
public class StringWithoutAAAorBBB {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while(A + B > 0) {
            int l = sb.length();
            if (l > 1 && sb.charAt(l - 2) == sb.charAt(l - 1)) {
                if (sb.charAt(l - 1) == 'a') {
                    sb.append('b');
                    B--;
                } else {
                    sb.append('a');
                    A--;
                }
            } else {
                if (A > B) {
                    sb.append('a');
                    A--;
                } else {
                    sb.append('b');
                    B--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
    
}
