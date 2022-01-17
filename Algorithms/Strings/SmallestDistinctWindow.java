package Algorithms.Strings;
import java.util.*;
public class SmallestDistinctWindow {

    public String findSubString( String str) {
        // Your code goes here
        if (str.length() == 0)
            return "";
        String s = str;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            tMap.put(c,  1);
        }
        
        int defaultNum = tMap.size();
        int matchedNum = 0; 
        String ret = "";
        int min = s.length();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) - 1);
                if (tMap.get(c) >= 0)
                    matchedNum++;
            }
            while (matchedNum == defaultNum && start <= end) {
                // System.out.println(s.substring(start,end+1));
                if (min >= end - start + 1) {
                    min = end - start + 1;
                    ret = s.substring(start, end + 1);
                }
                char startC = s.charAt(start++);
                if (tMap.containsKey(startC)) {
                    if (tMap.get(startC) == 0) // exceed limit
                        matchedNum--;
                    tMap.put(startC, tMap.getOrDefault(startC, 0) + 1);
                }
            }
            
        }
        return ret;
    }
    public static void main(String[] args) {
        
    }
    
}
