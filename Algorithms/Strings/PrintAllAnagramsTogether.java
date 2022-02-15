package Algorithms.Strings;
import java.util.*;
public class PrintAllAnagramsTogether {

    /**
     * 
     * Tc = O(nm)
     */

    private static ArrayList<ArrayList<String>> solver( ArrayList<String> list)
    {
 
        // Inner hashmap counts frequency
        // of characters in a string.
        // Outer hashmap for if same
        // frequency characters are present in
        // in a string then it will add it to
        // the arraylist.
        HashMap<HashMap<Character, Integer>, ArrayList<String> > map = new HashMap<HashMap<Character, Integer>,ArrayList<String>>();
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
        ArrayList<ArrayList<String> >
            result = new ArrayList<>();
        for (HashMap<Character, Integer>
                 temp : map.keySet())
            result.add(map.get(temp));
        return result;
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("ogd");
        list.add("god");
        list.add("atc");
 
        System.out.println(solver(list));
        
    }
    
}
