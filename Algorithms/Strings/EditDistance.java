package Algorithms.Strings;
/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance {

    /**
     * 
     * Tc = O(n2)
     * Sc = O(n2)
     */

    public int minDistance(String word1, String word2) {

        /**s1 = a
         * s2 = am
         * 
         * when comparing => we have three options as listed below
         * 
         * insert         => s1 = am s2 = am => cancelling m => s1=a , s2 =a => left => [i][j-1]
         * 
         * replace        => s1 = m s2 = am => cancelling m => s1=_ , s2=a => diagonal=> [i-1][j-1]
         * 
         * delete         => s1 = _ s2 = am => s1 = _ s2 = am => up => [i-1][j]
         */
        
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]; //left diagonal
                    }else{
                        //last one will be matching so give the ans of prev strings that are formed 
                        //plus 1 because of the new operations that was done 
                        int insertCost = dp[i][j-1]; //left
                        int replaceCost = dp[i-1][j-1]; //left diagonal
                        int deleteCost = dp[i-1][j]; // up
                        dp[i][j] = 1+Math.min(insertCost , Math.min(replaceCost,deleteCost));
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        
    }
    
}
