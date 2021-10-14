package Algorithms.Graphs;
import java.util.*;
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    private boolean cycleCheck(int node, int[] visited, int[] pathVisited,List<List<Integer>> adj){
        visited[node] = 1;
        pathVisited[node] = 1;
        for(Integer it : adj.get(node)){
            if(visited[it] == 0){
                if(cycleCheck(it,visited,pathVisited,adj)) return true;
            }else{
                if(pathVisited[it] == 1) return true;
            }
        }
        pathVisited[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited= new int[numCourses];
        int[] pathVisited = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            if(visited[i] == 0){
                if(cycleCheck(i,visited,pathVisited,adj)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
    
}
