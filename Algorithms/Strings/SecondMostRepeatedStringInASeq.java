package Algorithms.Strings;
import java.util.*;
public class SecondMostRepeatedStringInASeq {

    public static String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer> map = new HashMap<>();
        for(String ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int max = 0;
        for(String key : map.keySet()){
           max =  Math.max(max,map.get(key));
        }
        int ans=0;
        String res="";
        for(String key : map.keySet()){
            if(map.get(key) > ans && map.get(key)<max){
                ans = map.get(key);
                res= key;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
    
}
