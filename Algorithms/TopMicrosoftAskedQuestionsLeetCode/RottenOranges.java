package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 
 */
class oranges {
    int r,c,time;
    oranges(int r,int c,int time){
        this.r=r;
        this.c=c;
        this.time=time;
    }
}
public class RottenOranges {

    private static int rottenOranges(int[][] grid){
        Queue<oranges> q = new LinkedList<oranges>();
        int oranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new oranges(i,j,0));
                }
                if(grid[i][j] != 0){
                    oranges+=1;
                }
            }
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};
        int rottenoranges=0;
        int tm=0;
        while(!q.isEmpty()){
            oranges orange = q.poll();
            int r = orange.r;
            int c = orange.c;
            int time = orange.time;
            rottenoranges+=1;
            tm = Math.max(time,tm);
           // System.out.println(dr.length + " " +dc.length);
            for(int i=0;i<4;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];
                if(newr >= 0 && newr < n && newc >=0 && newc < m && grid[newr][newc]==1){
                    grid[newr][newc] = 2;
                    q.offer(new oranges(newr,newc,time+1));
                }
            }
        }
       // System.out.println(rottenoranges+ " " +oranges + " "+tm);
        if(rottenoranges != oranges){
            return -1;
        }else{
            return tm;
        }
    }
    public static int orangesRotting(int[][] grid) {
        return rottenOranges(grid);
    }
    public static void main(String[] args) {
        int[][] grid = new int [4][4];
        int time = orangesRotting(grid);
    }
    
}
