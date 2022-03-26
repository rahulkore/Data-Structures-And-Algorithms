package Algorithms.TopMicrosoftAskedQuestionsLeetCode;

public class LongestPalindromicSubString {

    public static String main(String[] args) {
        String s = "";
        int ans = 0; // for counting the palindromic substring
        int ansRow = 0; // maintaining the initial index for the longest palindromic substring
        int ansCol = 0;// maintaining the final index for the longest palindromic substring
        int longestLength = 0; // maintaining the length of the longest palindromic substring
        boolean dp[][] = new boolean[s.length()][s.length()];
        int gap; // for traversing diagonally and increasing the string length 
        for(gap =0 ; gap < s.length() ; gap++){
            for(int row = 0,col = gap; col < s.length(); row++,col++){
                if(gap==0){
                    dp[row][col] = true;                        
                    ans+=1;
                }
                else if(gap == 1){
                    dp[row][col] = s.charAt(row) == s.charAt(col);
                    if(dp[row][col])
                        ans+=1;
                }
                else{
                    if(s.charAt(row) == s.charAt(col) && dp[row+1][col-1]==true){
                        dp[row][col] = true;
                        ans += 1;
                    }else{
                        dp[row][col] = false;
                    }
                }
                if(dp[row][col]){
                    if(col-row+1 > longestLength){
                        longestLength = col-row+1;
                        ansRow = row;
                        ansCol = col;
                    }
                }
            }
        }
        //System.out.println(ans);
        return s.substring(ansRow, ansCol+1);
    }
    
}
