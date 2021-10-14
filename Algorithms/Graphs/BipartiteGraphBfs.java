package Algorithms.Graphs;
import java.util.*;
/**
 * Bipartite graph implementation using bfs 
 */
public class BipartiteGraphBfs {


    private static boolean checkBipartiteGraph(int node, int color,int[] colorArray,ArrayList<ArrayList<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node,color});
        colorArray[node] = color;
        while(!q.isEmpty()){
            int[] data = q.poll();
            int nod = data[0];
            int colr  = data[1];
            for(int it : adj.get(nod)){
                if(colorArray[it] == -1){
                   colorArray[it] = 1-colr;
                   q.offer(new int[]{it,1-colr});
                }else{
                    if(colorArray[it] == colr){
                        return false;
                    }
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
