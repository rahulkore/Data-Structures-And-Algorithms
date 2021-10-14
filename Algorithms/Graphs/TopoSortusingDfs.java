package Algorithms.Graphs;
import java.util.*;

/**
 * DAG = > directed acyclic graph can only have a toposort .
 */
public class TopoSortusingDfs {
    private static Stack<Integer> stack;
    private static void topoDfs(int node,  ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[node] = 1; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                topoDfs(it, adj, vis);
            }
        }
        stack.push(node);
        return; 
    }

    public static void topo(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N];
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                topoDfs(i, adj, vis);
            }
        }
        return; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            stack = new Stack<>();
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
            topo(V, list);
            while(!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }
        sc.close();

       
    }
    
}
