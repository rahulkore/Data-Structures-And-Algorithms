package Algorithms.Graphs;
import java.util.*;
/**
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
 * The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you
 * can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are 
 * there in the matrix after each operator.You need to return an array of size K.

0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, 
we consider them in the same island. We only consider up/down/left/right adjacent.

Example
Example 1:

Input: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
Output: [1,1,2,2]
Explanation:
0.  00000
    00000
    00000
    00000
1.  00000
    01000
    00000
    00000
2.  01000
    01000
    00000
    00000
3.  01000
    01000
    00000
    00010
4.  01000
    01000
    00000
    00011
Example 2:

Input: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
Output: [1,1,2,2]
 */
class DSU{
    int[] parent;
    int [] size;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++){
            parent[i]=i;
            size[i]=1;
            rank[i]=0;
        }
    }
    public int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    public void unionBySize(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(size[pu] < size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv] = pu;
            size[pu]+=size[pv];
        }
    }
    public void unionByRank(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }else if(rank[pv] < rank[pu]){
            parent[pv]=pu;
        }else{
            parent[pu]=pv;
            rank[pv]+=1;
        }
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class NumberOfIslands2 {

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        int[][] grid = new int[n][m];
        List<Integer> ans =  new ArrayList<>();
        DSU dsu = new DSU(n*m);
        int count = 0;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        if(operators == null || operators.length ==0) return ans;
        for(Point p : operators){
            int x = p.x;
            int y = p.y;
            if(grid[x][y] == 1){
                ans.add(count);
                continue;
            }
            count++;
            grid[x][y]=1;
            int ind1 = x*m + y;
            for(int i =0 ;i<4;i++){
                int newx = x + dr[i];
                int newy = y + dc[i];
                int ind2  = newx*m + newy;
                if(newx >=0 && newx < n && newy >= 0 && newy < m && grid[newx][newy]==1 
                && dsu.findParent(ind1)!=dsu.findParent(ind2)){
                    count--;
                    dsu.unionBySize(ind1,ind2);
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
