package Algorithms.Graphs;
import java.util.*;
/**
 * Bipartite graphs : If you can color a graph using two different colors such that no two adjacent nodes
 * have the same color , then the graoh is known to be as bipartite graph.
 * 
 * odd length cycle : => If graph is not bipartite then there will be odd length cycle 
 * 
 * cycle of odd length can be detected easily using bipartite graphs
 */
public class BipartiteGraphsDfs {

    private static boolean checkBipartiteGraph(int node, int color,int[] colorArray,ArrayList<ArrayList<Integer>> adj){
        colorArray[node] = color;
        for(int it : adj.get(node)){
            if(colorArray[it] == -1){
                if(checkBipartiteGraph(it, 1-color, colorArray, adj)){
                    return true;
                }
            }else{
                if(colorArray[it] == color){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isBipartite(int v,  ArrayList<ArrayList<Integer>> adj){
        int[] colorArray = new int[v];
        Arrays.fill(colorArray, -1);
        if(checkBipartiteGraph(0, 1, colorArray, adj)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(isBipartite(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
        sc.close();
    }
    
}
