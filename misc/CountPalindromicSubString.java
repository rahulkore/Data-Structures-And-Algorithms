package misc;
import java.util.*;
public class CountPalindromicSubString {

    public static void main(String[] args) {
        String s = "";
        int ans = 0;
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
            }
        }
    }
    
}
