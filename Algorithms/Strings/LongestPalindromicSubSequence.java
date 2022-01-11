package Algorithms.Strings;
/**
 * Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubSequence {

    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        int ans=0;
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j] = 1;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]+2;
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
                
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        
    }
    
}
