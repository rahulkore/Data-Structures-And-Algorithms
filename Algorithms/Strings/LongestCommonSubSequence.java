package Algorithms.Strings;
import java.util.*;
/**
 * s1 => c1r1  _r1
 * s2 => c2r2  _r2
 * 
 * cartesian product of above with each other 
 * 
 * l(s1,s2) =>   1+l(r1,r2) if c1==c2 where c1 and c2 are the preceedings 
 * 
 *              max(l(s1,r2), l(r1,s2)) if c1 != c2 
 * 
 * Starting from bottom so if equals then will check the right diagonal 
 * or else max of down and right
 * 
 */
public class LongestCommonSubSequence {

    public static int LCS(String X, String Y){

        int dp[][] = new int[X.length()+1][Y.length()+1];
        String ans = "";
        for(int i=dp.length-2; i>=0; i--){
            for(int j=dp.length-2 ; j>=0 ;j--){
                if(X.charAt(i) == Y.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    ans += X.charAt(i);
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]); // check down and right since traversing from bottom
                }
            }
        }
        System.out.println(ans);
        return dp[0][0];
    }
    public static void main(String[] args) {
        String X = "abcd";
        String Y = "abed";
        System.out.println(LCS(X, Y));
        
    }
    
}
