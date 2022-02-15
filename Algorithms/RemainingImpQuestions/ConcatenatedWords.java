package Algorithms.RemainingImpQuestions;
import java.util.*;
/**Given an array of strings words (without duplicates), return all the concatenated words 
 * in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter
 words in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". */
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
   
        //sort the array in asc order of word length, since longer words are formed by shorter words.
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        List<String> result = new ArrayList<>();
        
        //list of shorter words 
        HashSet<String> preWords = new HashSet<>();
        
        for(int i=0; i< words.length; i++){
            //Word Break-I problem.
            if(wordBreak(words[i], preWords)) result.add(words[i]);
            preWords.add(words[i]);
        }
        return result;
       }
       
       public boolean wordBreak(String s, HashSet<String> wordDict) {
            int n = s.length();
            int dp[] = new int[n];
            if(n==0){
                return false;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    if(wordDict.contains(s.substring(j,i+1))){
                       dp[i] += j>0 ? dp[j-1] : 1; 
                    }
                }
            }
            return dp[n-1] > 0;
        }


    public static void main(String[] args) {
        
    }
    
}
