package Algorithms.Graphs;

public class Bfs {

    public static  int adj[][];
    public static  int visited[];
    public static  int n;

    static void bfs(int node){
        int q[] = new int[n];
        int f=-1,r=-1;
        q[++r] = node;
        visited[node] = 1;
        while(f!=r){
            node = q[++f];
            System.out.print(node+1);
            for(int i=0;i<n;i++){
                if(adj[node][i] == 1 && visited[i]==0){
                    visited[i] =1;
                    q[++r] = i;
                }
            }
        }
    }

    public static void main(String[] args) {

        // n = > no of nodes to be declared as 4
        n = 4;

        adj = new int[n][n];
        visited = new int[4];
        // adjacency matrix creation
        adj[0][1] = 1;
        adj[0][2] = 1;
        adj[0][3] = 1;
        adj[1][0] = 1;
        adj[1][2] = 1;
        adj[2][0] = 1;
        adj[2][1] = 1;
        adj[3][0] = 1; 
        
        bfs(0);
        visited = new int[4];
        System.out.println();
        bfs(1);
        visited = new int[4];
        System.out.println();
        bfs(2);
        visited = new int[4];
        System.out.println();
        bfs(3);
    }
    
}
