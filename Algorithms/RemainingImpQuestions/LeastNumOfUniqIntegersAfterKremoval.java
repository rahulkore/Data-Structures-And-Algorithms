package Algorithms.RemainingImpQuestions;
import java.util.*;
/**Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left. */
class Pair{
    int key;
    int value;
    Pair(int k, int v){
        key = k;
        value = v;
    }
}
public class LeastNumOfUniqIntegersAfterKremoval {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.value-b.value);
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        while(!pq.isEmpty() && k!=0){
            
            if(pq.peek().value - k <= 0){
                k -= pq.peek().value;
                pq.poll();
            }
            else {
                pq.peek().value -= k;
                k=0;
            }
        }
        return pq.size();
    }
    
}
