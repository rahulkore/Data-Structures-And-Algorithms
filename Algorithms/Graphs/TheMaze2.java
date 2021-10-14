package Algorithms.Graphs;
import java.util.*;
/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

1.There is only one ball and one destination in the maze.
2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
3.The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
4.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

Example
Example 1:
	Input:  
	(rowStart, colStart) = (0,4)
	(rowDest, colDest)= (4,4)
	0 0 1 0 0
	0 0 0 0 0
	0 0 0 1 0
	1 1 0 1 1
	0 0 0 0 0

	Output:  12
	
	Explanation:
	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)

Example 2:
	Input:
	(rowStart, colStart) = (0,4)
	(rowDest, colDest)= (0,0)
	0 0 1 0 0
	0 0 0 0 0
	0 0 0 1 0
	1 1 0 1 1
	0 0 0 0 0

	Output:  6
	
	Explanation:
	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(0,0)
	
 */
class CustomsIntegerComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[2] < o2[2] ? 1 : -1;
    }
}
public class TheMaze2 {

    private static int solve(int[][] maze,int[] start, int[] destination,int n,int m){
        PriorityQueue<int[]> q = new PriorityQueue<>(new CustomsIntegerComparator());
        int[] distance = new int[n*m];
        Arrays.fill(distance,Integer.MAX_VALUE);
        q.add(new int[]{start[0],start[1],0});
        distance[start[0]*m + start[1]] = 0;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] data = q.poll();
            int x = data[0];
            int y = data[1];
            System.out.println(x + " " + y);
            //if(x == destination[0] && y == destination[1]) return true;
            for(int i=0;i<4;i++){
                int newr = x;
                int newc = y;
                int count=0;
                while(newr >= 0 && newr < n && newc >= 0 && newc < m && maze[newr][newc]==0){
                    newr += dr[i];
                    newc += dc[i];
                    count++;
                }
                newr -= dr[i];
                newc -= dc[i];
                count--;
                if(distance[x*m + y] + count < distance[newr*m + newc]){
                    distance[newr*m + newc] = distance[x*m + y] + count;
                    q.add(new int[]{newr,newc,distance[x*m + y] + count});
                }
                
            }
        }
        if(distance[destination[0]*m + destination[1]] == Integer.MAX_VALUE){
            return -1;
        }else{
            return distance[destination[0]*m + destination[1]];
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int n = maze.length;
        int m = maze[0].length;
        return solve(maze,start,destination,n,m);
    }

    public static void main(String[] args) {
        
    }
    
}
