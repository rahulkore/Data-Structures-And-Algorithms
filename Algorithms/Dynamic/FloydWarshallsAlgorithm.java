package Algorithms.Dynamic;

/**
 * The Problem is to find a matrix 'A' such that 
 * A[i][j] reprsents length of the shortest path from i => j .
 * 
 * G=(V,E) => be the directed graph and 
 * c => cost adjacency matrix .
 */

public class FloydWarshallsAlgorithm {

    public static int a[][]; // cost adjacency matrix OR length matrix OR adjacency matrix
    public static int d[][]; // direction matrix for path finding
    public static int n;// no of nodes;

    static void findpath(int src, int dst){
        if(src == d[src][dst]){
            return;
        }
        System.out.print((d[src][dst]+1) + " ");
        findpath(d[src][dst], dst);
    }

    public static void main(String[] args) {
        n=4;
        a = new int[n][n];
        d = new int[n][n];

        a[0][1] = 20;
        a[0][2] = 8;
        a[1][0] = 7;
        a[2][0] = 15;
        a[2][1] = 7;
        a[2][3] = 3;
        a[3][1] = 2;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(a[i][j] == 0){
                        a[i][j] = Integer.MAX_VALUE;
                        d[i][j] = -1;
                    }else{
                        d[i][j] = i;
                    }
                }else{
                    d[i][j] = -1;
                }
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((a[i][k] + a[k][j]) < a[i][j]){
                        a[i][j] = a[i][k] + a[k][j];
                        d[i][j] = k;
                    }
                }
            }
        }

        /**
         * To display a
         */
        System.out.println("Matrix A => ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               System.out.print(a[i][j] +" ");
            }
            System.out.println();
        }
        /**
         * To display d
         */
        System.out.println("Matrix D => ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               System.out.print(d[i][j] +" ");
            }
            System.out.println();
        }

        /**
         * Path Finding stratergy
         */

        int src =2;
        int dst = 0;
        System.out.print((src+1) + " ");
        findpath(src, dst);
        System.out.print((dst+1) + " ");
    }
    
}
