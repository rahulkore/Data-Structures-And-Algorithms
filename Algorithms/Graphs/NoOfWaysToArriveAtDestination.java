package Algorithms.Graphs;
import java.util.*;
/**
 * 1976. Number of Ways to Arrive at Destination    
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 */
public class NoOfWaysToArriveAtDestination {

    private int solve(List<List<int[]>> adj,int n){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int mod = (int)Math.pow(10 , 9) + 7;
        int distance[] = new int[n];
        int ways[] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        q.add(new int[]{0,0});
        distance[0]=0;
        ways[0]=1;
        while(!q.isEmpty()){
            int[] data = q.poll();
            int u = data[0];
            int du = data[1];
            System.out.println(u+" "+du);
            for(int[] it : adj.get(u)){
                int v = it[0];
                int wt = it[1];
                if(du + wt < distance[v]){
                    distance[v] = du + wt;
                    ways[v] = ways[u];
                    q.add(new int[]{v,distance[v]});
                    System.out.println("lessthan"+v+" "+distance[v]+" "+ways[v]);
                }else{
                    if(du+wt == distance[v]){
                        ways[v] = (ways[v]+ways[u]);
                        ways[v] = ways[v] % mod;
                        System.out.println("equals"+v+" "+distance[v]+" "+ways[v]);
                    }
                }
                
            }
        }
        // for(int i : ways)
        // System.out.println(i);
        return ways[n-1];
    }
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int[] data : roads){
            adj.get(data[0]).add(new int[]{data[1],data[2]});
            adj.get(data[1]).add(new int[]{data[0],data[2]});
        }
        return solve(adj,n);
    }
    public static void main(String[] args) {
        
    }
    
}
