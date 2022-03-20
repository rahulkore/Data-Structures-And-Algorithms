package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeOverLappingSubIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if(intervals == null || intervals.length==0)
            return ans.toArray(new int[0][]);
        Arrays.sort(intervals ,(a,b)-> a[0]-b[0]);
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int[] i : intervals){
            if(i[0]<=temp[1]){
                temp[1] = Math.max(i[1],temp[1]);
            }else{
                ans.add(temp);
                temp = new int[2];
                temp[0] = i[0];
                temp[1] = i[1];
            }
        }
        ans.add(temp);
        return ans.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        
    }
    
}
