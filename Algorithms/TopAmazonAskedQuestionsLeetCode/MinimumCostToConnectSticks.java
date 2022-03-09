package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**You are given an array/list ‘ARR’ of ‘N’ positive integers where each element describes the
 *  length of the stick. You have to connect all sticks into one. At a time, you can join any 
 * two sticks by paying a cost of ‘X’ and ‘Y’ where ‘X’ is the length of the first stick and 
 * ‘Y’ is the length of the second stick and the new stick we get will have a length equal to 
 * (X+Y). You have to find the minimum cost to connect all the sticks into one. 
 * Sample Input 1:
2
3  
2 4 3
4
1 8 3 5 
Sample Output 1:
14
30*/
public class MinimumCostToConnectSticks {

    public static long minimumCostToConnectSticks(ArrayList<Integer> arr) {
	    // Wrtie your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : arr)
            pq.add(ele);
        int ans=0;
        while(pq.size() != 1){
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int cost = stick1+stick2;
            ans += cost;
            pq.add(cost);
        }
        return ans;
	}

    
    
}
