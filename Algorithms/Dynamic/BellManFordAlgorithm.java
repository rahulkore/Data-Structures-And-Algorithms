package Algorithms.Dynamic;

/**
 * It is similar to dijkstras algorithm but it is capable of determining negative weight cycle 
 * 
 * Negative weight cycle => It is a cycle which has a total weight as negative 
 * 
 * 1 -> 2 (5)
 * 2 -> 3 (-10)
 * 3 -> 1 (2)
 * 
 * The graph constructed from above edges has a negative weight cycle
 */
public class BellManFordAlgorithm {

     // e=> no of edges
     public static  int E;
     // v=> no of vertices
     public static  int V;
     public static int d[];
     public static int pi[];
     public static int adjacencyMatrix[][];
     public static int weightMatrix[][]; 

    public static void main(String[] args) {

        E = 3;
        V = 3;
        d = new int[V];
        pi = new int[V];
        for(int i=0;i<V;i++){
            d[i]  = Integer.MAX_VALUE;
            pi[i] = -1;
        }

        /**
         * Initializing weight matrix and adjacency matrix
         */
        adjacencyMatrix = new int[V][V];
        weightMatrix = new int[V][V];

        /**
         * The below graph which is represented by djacency matrix has a negative weight cycle 
         */
        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[2][1] = 1;
        adjacencyMatrix[1][2] = 1;
        adjacencyMatrix[2][0] = 1;
        
        weightMatrix[0][1] = 8;
        weightMatrix[0][1] = -5;
        weightMatrix[1][2] = -10;
        weightMatrix[2][0] = 2;
        
        for(int i=0;i<V-1;i++){
            /**
             * Traverse all the edges 
             */
            for(int u=0;u<V;u++){
                for(int v=0;v<V;v++){
                    if(adjacencyMatrix[u][v] ==1 ){
                        if(d[u] + weightMatrix[u][v] < d[v]){
                            d[v] = d[u] + weightMatrix[u][v];
                            pi[v] = u;
                        }
                    }
                }
            }
        }

        /**
         * check one more time for all the edges if smaller cost is found then 
         * negative weight cycle exist or else no negative weight cycle.
         */
        for(int u=0;u<V;u++){
            for(int v=0;v<V;v++){
                if(adjacencyMatrix[u][v] ==1 ){
                    if(d[u] + weightMatrix[u][v] < d[v]){
                        System.out.println("Negative Weight Cycle is Present");
                        return;
                    }
                }
            }
        }

        System.out.println("No Negative Weight cycle present");

    }
    
}
