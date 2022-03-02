package Algorithms.Strings;

public class CountAllPalindromicSubsequences {

    /**S = pre+r+suf
     * seq(s) = seq(_ r _)          => c1
     *          seq(_ r suf)        => c2
     *          seq(pre r _)        => c3
     *          seq(pre r suf)      => c4
     * 
     * if(pre == suf) => total = c1 + c2 + c3 + c4 => c1 + c2 + c3 + c1 +1 => (c1+c2) + (c1+c3) + 1
     *                => suffix + prefix + 1
     * 
     * if(pre != suf) => total = c1 + c2 + c3 => (c1+c2) + (c1+c3) - c1
     *                => suffix + prefix + middle part
     */

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
