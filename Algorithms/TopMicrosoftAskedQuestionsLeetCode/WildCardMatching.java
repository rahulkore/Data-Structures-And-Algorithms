package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
/**Given an input string (s) and a pattern (p), implement wildcard pattern matching with support 
 * for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'. */
public class WildCardMatching {


    /**Tc = O(n^2) 
     * Sc = O(n^2)
    */
    public boolean isMatch(String s, String p) {
        
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        /**plot pattern on row and string on column */
        /**start from the bottom most cell */
        for(int i = dp.length-1 ; i >= 0 ; i--){
            for(int j = dp[0].length-1 ; j>=0 ; j--){
                if(i == dp.length-1 && j == dp[0].length-1){ /**this means last cell , always true 
                    blank with blank , since we append blank in the last of pattern and string  */
                    dp[i][j] = true;
                }else if(i == dp.length-1){ /**Last row , all false since blank of pattern won't 
                match with any character from string */
                    dp[i][j] = false; 
                }else if(j == dp[0].length-1){ /**Last column all false , except for * , if * then 
                    populate the below cell , since * can take any form  */
                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{ /** Inner Cells */
                    if(p.charAt(i) == '?'){ /** If ? then check the diagonal since ? can take any
                        one character place except blank */
                        dp[i][j] = dp[i+1][j+1];
                    }else if(p.charAt(i) == '*'){ /** If * then check all the cells in below row
                        from its position till last => In optimized version just check down cell 
                        and right cell */
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }else{/** This means its a character */
                        if(p.charAt(i) == s.charAt(j)){ /** If the characters match then populate
                            diagonal */
                            dp[i][j] = dp[i+1][j+1];
                        }else{ /**If characters does not match then its clearly false  */
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        
    }
    
}
