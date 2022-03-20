package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1] */
class points {
    int ele;
    int freq;
    
    points(int _ele, int _freq){
        ele = _ele;
        freq = _freq;
    }
}
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        
        int[] ans = new int[k];
        
        PriorityQueue<points> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int ele : nums)
            map.put(ele,map.getOrDefault(ele,0)+1);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new points(entry.getKey(),entry.getValue()));
        }
        
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().ele;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
