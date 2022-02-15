package Algorithms.Dynamic;
import java.util.*;
/**Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1 */
public class PalindromePartitioning {

    /**Tabulation method
     * Tc = O(n*3)
     * Sc = O(n*2)
     */
    public int minCut(String s) {
        
        int[][] dp = new int[s.length()][s.length()];
        boolean [][] bp = new boolean[s.length()][s.length()];
        
        for(int g =0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();j++,i++){
                if(g==0){
                    bp[i][j] = true;
                }else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        bp[i][j] = true;
                    }else{
                        bp[i][j] = false;;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && bp[i+1][j-1]){
                        bp[i][j] = true;
                    }else{
                        bp[i][j] = false;
                    }
                }
            }
        }
        
        for(int[] ele : dp)
            Arrays.fill(ele,Integer.MAX_VALUE);
        
        for(int g =0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();j++,i++){
                if(g==0){
                    dp[i][j] = 0;
                }else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(bp[i][j]){
                        dp[i][j] = 0;
                        continue;
                    }
                    for(int k=i;k<j;k++){
                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+1);
                    }
                }
            }
        }
        return dp[0][dp[0].length-1];
    }


    /**Tabulation method 
     * Tc = O(n*2)
     * Sc = o(n*2)
     */

    public int minCutnSquare(String s) {
        
       
        boolean [][] bp = new boolean[s.length()][s.length()];
        
        for(int g =0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();j++,i++){
                if(g==0){
                    bp[i][j] = true;
                }else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        bp[i][j] = true;
                    }else{
                        bp[i][j] = false;;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && bp[i+1][j-1]){
                        bp[i][j] = true;
                    }else{
                        bp[i][j] = false;
                    }
                }
            }
        }
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j=1;j<s.length();j++){
            if(bp[0][j]){
                dp[j] = 0;
                continue;
            }
            for(int i=j;i>=1;i--){
                if(bp[i][j]){
                    dp[j] = Math.min(dp[j],dp[i-1]+1);
                }
            }
        }
        return dp[s.length()-1];
       
    }

    public static void main(String[] args) {
        
    }
    
}
