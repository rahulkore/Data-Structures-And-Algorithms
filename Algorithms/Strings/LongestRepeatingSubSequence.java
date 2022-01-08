package Algorithms.Strings;
/**
 * str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y 
0 1 2 3 4

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.
Example 2:

Input:
str = "aab"
Output: 1
Explanation: 
The longest reapting subsequenece is "a".

Your Task:
You don't need to read or print anything. Your task is to complete the LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.


Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)

 */
public class LongestRepeatingSubSequence {

    public static int LCS(String X, String Y){

        int dp[][] = new int[X.length()+1][Y.length()+1];
        String ans = "";
        for(int i=dp.length-2; i>=0; i--){
            for(int j=dp.length-2 ; j>=0 ;j--){
                if(X.charAt(i) == Y.charAt(j) && i!=j){ // should not be of same index
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

    public static void longestRepeatingSubSeq(String s){
        System.out.println(LCS(s, s));
    }
    public static void main(String[] args) {
        
    }
    
}
