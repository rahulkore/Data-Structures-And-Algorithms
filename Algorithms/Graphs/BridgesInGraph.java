package Algorithms.Graphs;
import java.util.*;
/**
 * Bridges In Graph => A bridge in a graph is an edge which on removal disconnects the graph.
 * 
 * timeinsertion is the time when we first visit the node.
 * lowtime of a node is the lowest time of its adjacent nodes .
 */
public class BridgesInGraph {

    private static int timer = 0;
    private static void dfs(int node, int parent, List<List<Integer>> adj,int[] visited,int[] tin,int[] lowtime){
        tin[node] = lowtime[node] = timer++;
        visited[node] = 1;
        for(int adjnode : adj.get(node)){
            if(adjnode == parent) continue;
            if(visited[adjnode] == 0){
                dfs(adjnode,node,adj,visited,tin,lowtime);
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
        
        t.close();
        dfs(0,-1,adj,visited,tin,lowtime);
    }
    
}
