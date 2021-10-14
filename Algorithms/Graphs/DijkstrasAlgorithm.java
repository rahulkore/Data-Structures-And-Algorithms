package Algorithms.Graphs;
import java.util.*;
/**
 * Dijkstras algorithm for shortest path
 */
public class DijkstrasAlgorithm {

    private static void zeroOneBfs(int source,ArrayList<ArrayList<int[]>> adj, int[] dist,int[] parent ){
        PriorityQueue<int[]> dq = new PriorityQueue<>();
        dq.add(new int[]{source,0});
        dist[source] = 0;
        while(!dq.isEmpty()){
            int[] data = dq.poll();
            int u = data[0];
            int du = data[1];
            for(int[] it : adj.get(u)){
                int v = it[0];
                int wt = it[1];
                if(du + wt < dist[v]){
                    dist[v] = du + wt;
                    parent[v] = u;
                    dq.add(new int[]{v,du+wt});
                }
            }
        }
        for(int d : dist){
            System.out.println(d);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        int V = sc.nextInt();
        int E = sc.nextInt();
        for(int i = 0; i < V+1; i++)
            list.add(i, new ArrayList<int[]>());
        for(int i = 0; i < E; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[V];
        int[] parent= new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        zeroOneBfs(0, list, dist,parent);
        sc.close();
    }
}
