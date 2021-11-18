package Algorithms.Strings;
/**
 * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
 */
public class ReverseWordsInAString {

    public static String main(String[] args) {
        String s = "the sky is blue";
        int n = s.length();
        char[] charArray = s.toCharArray(); 
        String ans = "";
        for(int i=n-1;i>=0;i--){
            if(charArray[i] != ' '){
                String str = "";
                while(i>=0 && charArray[i] != ' '){
                    str += charArray[i];
                    i--;
                }
                StringBuffer buf = new StringBuffer(str);
                ans += buf.reverse().toString() + " ";

            }
        }
        return ans.stripTrailing();
    }
    
}
