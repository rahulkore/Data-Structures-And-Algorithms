package misc;
import java.util.*;
/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
         for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i)) == 1){
                    map.remove(t.charAt(i));
                }else{
                    map.put(t.charAt(i), map.get(t.charAt(i))-1);
                }
            }else{
                return false;
            }
        }
        map.values().stream().reduce(0, Integer::sum);
        return map.isEmpty() ? true : false;
    }
    public static void main(String[] args) {
        
    }
    
}
