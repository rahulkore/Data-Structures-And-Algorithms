package Algorithms.Strings;

public class CountAllPalindromicSubsequences {

    public int countPalindromicSubsequences(String s) {
        int dp[][] = new int[s.length()][s.length()];
        Long ans=0L;
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j] = 1;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=3;
                    }else{
                        dp[i][j]=2;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1; // prefix + suffix + 1
                    }else{
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]; // prefix + suffix - middleString
                    }
                }
                
            }
        }
        return dp[0][s.length()-1];
    }
    public static void main(String[] args) {
        
    }
    
}
