package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**Given an array of strings strs, group the anagrams together. You can return the answer in any 
 * order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]] */
public class GroupAnagrams {

    private static List<List<String>> solver( List<String> list)
    {
 
        // Inner hashmap counts frequency
        // of characters in a string.
        // Outer hashmap for if same
        // frequency characters are present in
        // in a string then it will add it to
        // the arraylist.
        HashMap<HashMap<Character, Integer>, List<String> > map = new HashMap<HashMap<Character, Integer>,List<String>>();
        for (String str : list) {
            HashMap<Character, Integer>
                tempMap = new HashMap<Character, Integer>();
 
            // Counting the frequency of the
            // characters present in a string
            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                }
                else {
                    tempMap.put(str.charAt(i), 1);
                }
            }
 
            // If the same frequency of characters
            // are already present then add that
            // string into that arraylist otherwise
            // created a new arraylist and add that string
            if (map.containsKey(tempMap))
                map.get(tempMap).add(str);
            else {
                ArrayList<String>
                    tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }
 
        // Stores the result in a arraylist
        List<List<String> >
            result = new ArrayList<>();
        for (HashMap<Character, Integer>
                 temp : map.keySet())
            result.add(map.get(temp));
        return result;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = new ArrayList<>();
        for(String str : strs)
            list.add(str);
        return solver(list);
    }

    public static void main(String[] args) {
        
    }
    
}
