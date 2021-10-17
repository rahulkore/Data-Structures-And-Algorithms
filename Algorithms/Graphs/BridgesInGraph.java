package Algorithms.Graphs;
import java.util.*;
/**
 * Bridges In Graph => A bridge in a graph is an edge which on removal disconnects the graph.
 */
public class BridgesInGraph {

    private static void dfs(int node, int parent, List<List<Integer>> adj,int[] visited,int[] tin,int[] lowtime){
        visited[node] = 1;
        for(int adjnode : adj.get(node)){
            if(adjnode == parent) continue;
            if(visited[adjnode] == 0){
                lowtime[node] = Math.min(lowtime[adjnode], lowtime[node]);
                if(lowtime[adjnode] > tin[node]){
                    System.out.println(adjnode + " => " + node);
                }
            }else{
                lowtime[node] = Math.min(lowtime[node], lowtime[adjnode]);
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        Scanner t = new Scanner(System.in);
        int V = t.nextInt();
        int e = t.nextInt();
        for(int i=0;i<e;i++){
            int u = t.nextInt();
            int v = t.nextInt();
            adj.get(u).add(v);
        }
        int[] visited = new int[V];
        int[] tin = new int[V];
        int lowtime[] = new int[V];
        int timer = 0;
        tin[0] = lowtime[0] = timer++;
        t.close();
        dfs(0,-1,adj,visited,tin,lowtime);
    }
    
}
