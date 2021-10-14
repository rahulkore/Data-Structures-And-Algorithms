package Algorithms.Graphs;
import java.util.*;
/**
 * 0 1 Bfs for shortest path algorithm 
 */
public class ZeroOneBfs {

    private static void zeroOneBfs(int source,ArrayList<ArrayList<int[]>> adj, int[] dist ){
        Deque<int[]> dq = new LinkedList<>();
        dq.addFirst(new int[]{source,0});
        dist[source] = 0;
        while(!dq.isEmpty()){
            int[] data = dq.pollFirst();
            int u = data[0];
            int du = data[1];
            for(int[] it : adj.get(u)){
                int v = it[0];
                int wt = it[1];
                if(du + wt < dist[v]){
                    dist[v] = du + wt;
                    if(wt == 1){
                        dq.addLast(new int[]{v,du+wt});
                    }else{
                        dq.addFirst(new int[]{v,du+wt});
                    }
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
        zeroOneBfs(0, list, dist);
        sc.close();
    }
    
}
