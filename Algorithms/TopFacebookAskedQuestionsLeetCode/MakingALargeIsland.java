package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
    class Pair{
        int x;
        int y;
        Pair(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
public class MakingALargeIsland {

    /**Only 2 steps:

Explore every island using DFS, count its area, give it an island index and save the result to a
 {index: area} map.
Loop every cell == 0, check its connected islands and calculate total islands area. */

    /**Tc = O(n^2) */
    public int N = 0;
    public int largestIsland(int[][] grid) {
        N = grid.length;
        //DFS every island and give it an index of island
        int index = 3, res = 0;
        HashMap<Integer, Integer> area = new HashMap<>();
        for (int x = 0; x < N; ++x) for (int y = 0; y < N; ++y)
            if (grid[x][y] == 1) {
                area.put(index, dfs(grid, x, y, index));
                res = Math.max(res, area.get(index++));
            }

        //traverse every 0 cell and count biggest island it can conntect
        for (int x = 0; x < N; ++x) for (int y = 0; y < N; ++y)
            if (grid[x][y] == 0) {
                HashSet<Integer> seen = new HashSet<>();
                int cur = 1;
                for (Pair p : move(x, y)) {
                    index = grid[p.x][p.y];
                    if (index > 1 && !seen.contains(index)) {
                        seen.add(index);
                        cur += area.get(index);
                    }
                }
                res = Math.max(res, cur);
            }
        return res;
    }

    public List <Pair> move(int x, int y) {
        ArrayList <Pair> res = new ArrayList<>();
        if (valid(x, y + 1)) res.add(new Pair(x, y + 1));
        if (valid(x, y - 1)) res.add(new Pair(x, y - 1));
        if (valid(x + 1, y)) res.add(new Pair(x + 1, y));
        if (valid(x - 1, y)) res.add(new Pair(x - 1, y));
        return res;
    }

    public boolean valid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public int dfs(int[][] grid, int x, int y, int index) {
        int area = 0;
        grid[x][y] = index;
        for (Pair p : move(x, y))
            if (grid[p.x][p.y] == 1)
                area += dfs(grid, p.x, p.y, index);
        return area + 1;
    }
}
