package Algorithms.Graphs;
/**
 * below implementation is using kahns algorithm/bfs using indegree , we can also do toposort using dfs and stack  
 * basically run the dfs for all the nodes and keep on storing the node inside of a stack then empty the stack and 
 * you will get the toposort 
 */
public class TopologicalSorting {

    public static  int adj[][];
    public static  int visited[];
    public static  int n;
    public static  int indegree[];

    static void topoSort(){

        int q[] = new int[n];
        int f=-1,r=-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[j][i] == 1){
                    indegree[i]++;
                }
            }
        }

        while(true)
        {

            for(int i=0;i<n;i++){
                if(indegree[i] == 0 && visited[i]==0){
                    q[++r] = i;
                    visited[i] = 1;
                }
            }
            if(f==r){
                break;
            }
            int node = q[++f];
            System.out.println(node+1);
            for(int i=0;i<n;i++){
                if(adj[node][i] == 1){
                    indegree[i]--;
                }
            }

        }

    }

    public static void main(String[] args) {

        n = 5;

        adj = new int[n][n];
        visited = new int[n];
        indegree = new int[n];
        // adjacency matrix creation
        adj[0][1] = 1;
        adj[0][2] = 1;
        adj[1][3] = 1;
        adj[2][1] = 1;
        adj[2][4] = 1;
        adj[4][3] = 1;
        
        topoSort();
    }
    
}
