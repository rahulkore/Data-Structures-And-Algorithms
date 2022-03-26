package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
public class CinemaSeatAllocation {
    
    /**From the beginning I used a Map<Integer, Set<Integer>> to represent reserved seats as a graph.
But then I realized that we can use a bit vector instead of Set<Integer>.

Also, seats 2,3,4,5 can be represented as (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) = 60, 
for example.
So, I use this value to check whether the seats 2,3,4,5 are available when traversing the graph 
(together with 6,7,8,9 and 4,5,6,7). */


/**I want to add some explanations for the last line max + 2 * (n - graph.size()). We don't 
 * necessarily have reserved seats for each row. If we don't have any reserved seats in that 
 * particular row, we can maximum possibly allocate 2 families with a group of 4 people each. 
 * For example, there are seats we can allocate for these two families with seats 2, 3, 4, 5 and 
 * seats 6, 7, 8, 9, seat 1 and seat 10 dose not matter.

From the code, max means the maximum allocations we can do for the rows with reserved seats.
 After that, we also need to count the rows won't have any reserved seats. The graph.size() 
 contains all rows which have seats reserved. n - graph.size() contains all rows don't have 
 any seats reserved, and we can allocate 2 families with a group of 4 people each, 
 so 2 * (n - graph.size()) is the total number of allocations we can do for rows don't have any
  seats reserved.

Finally, we have maximum number of allocations:
Maximum Allocations = Total number allocations for rows with reserved seats + 
Total number allocations for rows don't have any reserved seats
= max + 2 * (n - graph.size()). */

public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, Integer> graph = new HashMap<>();
    for (int[] reserved : reservedSeats) {
        int row = reserved[0];
        int col = reserved[1];
        graph.put(row, graph.getOrDefault(row, 0) | (1 << col)); // create a bit vector of reserved seats
    }
    int max = 0;
    // for(int row : graph.keySet()){
    //     System.out.println(row + " " + graph.get(row));
    // }
    for (int row : graph.keySet()) {
        int reserved = graph.get(row);
        int cnt = 0;
        if ((reserved &  60) == 0) cnt += 1; // check if seats 2,3,4,5 are available
        if ((reserved & 960) == 0) cnt += 1; // check if seats 6,7,8,9 are available
        if ((reserved & 240) == 0 && cnt == 0) cnt = 1; // check if seats 4,5,6,7 are available
        max += cnt;
    }
    
    return max + 2 * (n - graph.size()); // n-graph.size() means rows that do not have any reserved seats 
}
    public static void main(String[] args) {
        
    }
    
}
