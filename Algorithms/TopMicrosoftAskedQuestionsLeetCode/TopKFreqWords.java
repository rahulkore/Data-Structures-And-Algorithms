package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same 
frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of 
occurrence being 4, 3, 2 and 1 respectively. */
class Word{
    String ele;
    int count;
    
    Word(String _ele, int _count){
        ele = _ele;
        count = _count;
    }
    
    int getCount(){return count;}
    String getEle(){return ele;}
    
}
public class TopKFreqWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
     
        PriorityQueue<Word> pq = new PriorityQueue<>(Comparator.comparing(Word::getCount).reversed().thenComparing(Word::getEle));
        for(String word : words)
            map.put(word,map.getOrDefault(word,0)+1);
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.add(new Word(entry.getKey(),entry.getValue()));
        }
        

        for(int i=0;i<k;i++){
            ans.add(pq.poll().getEle());
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
