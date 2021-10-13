package Algorithms.Graphs;
import java.util.*;
/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
Input:
map = 
[
 [0,0,1,0,0],
 [0,0,0,0,0],
 [0,0,0,1,0],
 [1,1,0,1,1],
 [0,0,0,0,0]
]
start = [0,4]
end = [3,2]
Output:
false 

*/
public class TheMaze {

    private static boolean solve(int[][] maze,int[] start, int[] destination){
        Queue<int[]> q = new LinkedList<>();
        int n = maze.length;
        int m = maze[0].length;
        int[][] visited = new int[n][m];
        q.offer(new int[]{start[0],start[1]});
        visited[start[0]][start[1]] = 1;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] data = q.poll();
            int x = data[0];
            int y = data[1];
            System.out.println(x + " " + y);
            if(x == destination[0] && y == destination[1]) return true;
            for(int i=0;i<4;i++){
                int newr = x;
                int newc = y;
                while(newr >= 0 && newr < n && newc >= 0 && newc < m && maze[newr][newc]==0){
                    newr += dr[i];
                    newc += dc[i];
                }
                newr -= dr[i];
                newc -= dc[i];
                if(visited[newr][newc]==0){
                    visited[newr][newc] = 1;
                    q.offer(new int[]{newr,newc});
                }
            }
        }
        return false;
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        return solve(maze,start,destination);
    }
    public static void main(String[] args) {
        
    }
    
}
