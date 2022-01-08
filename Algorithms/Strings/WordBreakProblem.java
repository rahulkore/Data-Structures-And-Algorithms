package Algorithms.Strings;
import java.util.*;
/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */
public class WordBreakProblem {

     /**
      * most optimal approach 
      Tc = O(n2)
      Sc = O(n)
    The below code can count the number of possible segmented words too 
    and based upon that we will return true or false 
    like if dp[n-1] > 0 then return true else return false
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(wordDict.contains(s.substring(j,i+1))){
                   dp[i] += j>0 ? dp[j-1] : 1; 
                }
            }
        }
        return dp[n-1] > 0;
    }

     /** Below is the brute approach */
     public static boolean wordBreakCheck(String word,List<String> dictionary)
     {
         int size = word.length();
         if (size == 0)
         return true;
          
         //else check for all words
         for (int i = 1; i <= size; i++)
         {
             // Now we will first divide the word into two parts ,
             // the prefix will have a length of i and check if it is
             // present in dictionary ,if yes then we will check for
             // suffix of length size-i recursively. if both prefix and
             // suffix are present the word is found in dictionary.
  
             if (dictionary.contains(word.substring(0,i)) &&
                     wordBreakCheck(word.substring(i,size),dictionary))
             return true;
         }
          
         // if all cases failed then return false
         return false;
     }



     /**Below is the dp approach  */
    public boolean wordBreakDpCheck(String word,List<String> dictionary){
        int size = word.length();
        if (size == 0)
        return true;
        
        boolean[] dp = new boolean[size + 1];
        // if dp[i] is false, then check if current prefix can make it true.
        // Current prefix is "str.substr(0, i)"
        for (int i=1; i<=size; i++){
            if (dp[i] == false && dictionary.contains(word.substring(0, i) ))
            dp[i] = true;
            if(dp[i] == true){
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update dp[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j-i'
                    if (dp[j] == false && dictionary.contains(word.substring(i, j) ))
                        dp[j] = true;

                    // If we reached the last character
                    if (j == size && dp[j] == true)
                        return true;
                }
            } 
        }
        
        
        return false;
    }

    public static void main(String[] args) {
        
    }
    
}
