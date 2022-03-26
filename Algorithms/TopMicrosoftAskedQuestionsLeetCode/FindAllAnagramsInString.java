package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
 * You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab". */
public class FindAllAnagramsInString {

    /**TC = O(26*n) */
    public List<Integer> findAnagrams(String s, String p) {
        int start=0;
        if(s.length()<p.length()) return new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int[] sArray = s.chars().map(i->i-97).toArray(); //For String "abcz"; sArray=[0,1,2,25] 
        int[] hashTable = new int[26];
        for(int i=0;i<p.length();i++) hashTable[p.charAt(i)-97]++;
        int end = p.length()-1;
        for(int i=0;i<p.length();i++) --hashTable[sArray[i]]; //Inital window
        while(end<s.length()-1){
            if(isZeros26(hashTable)) answer.add(start);
            ++hashTable[sArray[start++]];
            --hashTable[sArray[++end]];
        }
        if(isZeros26(hashTable)) answer.add(start); //Last window
        return answer;
    }
    public boolean isZeros26(int[] arr){
        int z = 0;
        for(int i: arr) if(i==0) z++;
        return z==26;
    }
    public static void main(String[] args) {
        
    }
    
}
