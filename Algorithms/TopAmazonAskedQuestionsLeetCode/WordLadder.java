package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**A transformation sequence from word beginWord to word endWord using a dictionary 
 * wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of 
words in the shortest transformation sequence from beginWord to endWord, or 0 if no such
 sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", 
which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation
 sequence.
 */
public class WordLadder {

    /**Tc = O(mn) 
     * Sc = o(n)
     * m = individual word length
     * n = word list length
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> word=new HashSet(wordList);//it will be easy to check if wordlist contains that word
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();//to keep track of visited words;
        q.add(beginWord);
        visited.add(beginWord);
        
        int level=0;
        while(!q.isEmpty())
        {
            for(int i=q.size();i>0;i--)
            {
                String curr_word=q.poll();
                if(curr_word.equals(endWord))
                    return level+1;
                
                char[] c=curr_word.toCharArray();
                for(int j=0;j<c.length;j++)//to replace every character of that word and check if it is present in wordlist
                {
                   char temp=c[j];
                   for(char ch='a'; ch<='z'; ch++)
                   {
                       c[j]=ch;
                       String word_formed=String.valueOf(c);//if this newly formed word isnt visited and also present in the wordlist add it to the queue
                       if(!visited.contains(word_formed) && word.contains(word_formed))
                       {
                           q.add(word_formed);
                           visited.add(word_formed);
                       }
                   }
                    c[j]=temp;
                }
            }
            
            level++;//moving to the next level
        }
        
        return 0;
    }

    public static void main(String[] args) {
        
    }
    
}
