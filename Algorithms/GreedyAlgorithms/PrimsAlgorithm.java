package Algorithms.GreedyAlgorithms;

public class PrimsAlgorithm {

    // e=> no of edges
    public static  int E;
    // v=> no of vertices
    public static  int V;
    public static int d[];
    public static int pi[];
    public static int visitedNodeList[];
    public static int adjacencyMatrix[][];
    public static int weightMatrix[][]; 


    static int EXTRACTMIN(){
        int minVal;
        int minIndex;
        minVal = 99999999;
        minIndex = -1;
        for(int i=0;i<V;i++){
            if((d[i] < minVal) && visitedNodeList[i]==0){
                minVal = d[i];
                minIndex = i;
            }
        }
        if(minIndex != -1){
            visitedNodeList[minIndex]=1;
            return minIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        E = 5;
        V = 4;
        d = new int[V];
        pi = new int[V];
        visitedNodeList = new int[V];
        for(int i=0;i<V;i++){
            d[i]  = 99999999;
            pi[i] = -1;
            visitedNodeList[i] = 0; // array values in java are always initialized with 0 anyways.
        }

        /**
         * Initializing weight matrix and adjacency matrix
         */
        adjacencyMatrix = new int[V][V];
        weightMatrix = new int[V][V];

        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[0][2] = 1;
        adjacencyMatrix[1][2] = 1;
        adjacencyMatrix[1][3] = 1;
        adjacencyMatrix[2][3] = 1;

        adjacencyMatrix[1][0] = 1;
        adjacencyMatrix[2][0] = 1;
        adjacencyMatrix[2][1] = 1;
        adjacencyMatrix[3][1] = 1;
        adjacencyMatrix[3][2] = 1;

        weightMatrix[0][1] = 25;
        weightMatrix[0][2] = 20;
        weightMatrix[1][2] = 5;
        weightMatrix[1][3] = 15;
        weightMatrix[2][3] = 10;

        weightMatrix[1][0] = 25;
        weightMatrix[2][0] = 20;
        weightMatrix[2][1] = 5;
        weightMatrix[3][1] = 15;
        weightMatrix[3][2] = 10;

        d[0] = 0;
        while(true){
            int u = EXTRACTMIN();
            if(u == -1){
                break;
            }
            for(int v=0;v<V;v++){
                if(adjacencyMatrix[u][v] == 1 && visitedNodeList[v]==0){
                    //System.out.println(u + "-" + v);
                    if(weightMatrix[u][v] < d[v]){
                        d[v] = weightMatrix[u][v];
                        pi[v] = u;
                    }
                }
            }
        }

        /**
         * To display the result of array d and pi
         */
        // for(int i=0;i<V;i++){
        //     System.out.print(d[i]);
        // }
        // System.out.println();
        // for(int i=0;i<V;i++){
        //     System.out.print(pi[i]);
        // }

        /**
         * print all the nodes that are considered with their cost 
         */
        for(int i =0 ;i<V;i++){
            if(pi[i] != -1){
                System.err.println("Edge " + (i+1) +" - " + (pi[i]+1) + " with cost " + d[i]);
            }
        }
    }
    
}
