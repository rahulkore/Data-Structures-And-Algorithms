package Algorithms.Dynamic;

public class MultiStageGraph {

    public static int k; // no of stages
    public static int n;// no of nodes
    public static int c[][]; // cost matrix
    public static int COST[];// cost array
    public static int d[];// decision array
    public static int p[];// path array
    static void multiStageGraph(){
        COST[n-1] = 0;
        for(int j=n-2;j>=0;j--){
            int min = Integer.MAX_VALUE;
            int minpos = -1; 
            for(int r=0;r<n;r++){
                
                if(c[j][r] != 0 && c[j][r] + COST[r] < min){
                    //System.out.println(j +"->"+r);
                    min = c[j][r] + COST[r];
                    minpos = r;
                }
            }
            COST[j] = min;
            d[j] = minpos;
        }
        p[0]=0;
        p[k-1]=n-1;
        for(int j=1;j<k-1;j++){
            p[j]=d[p[j-1]];
        }

        for(int j=0;j<k;j++){
            System.out.print((p[j]+1) + " " );
        }
        return;
    }
    public static void main(String[] args) {
        k=5;
        n=12;
        COST = new int[n];
        d = new int[n];
        p = new int[k];

        c = new int[n][n];
        c[0][1] = 9;
        c[0][2] = 7;
        c[0][3] = 3;
        c[0][4] = 2;

        c[1][5] = 4;
        c[1][6] = 2;
        c[1][7] = 1;

        c[2][5] = 2;
        c[2][6] = 7;

        c[3][7]= 11;

        c[4][6] = 11;
        c[4][7] = 8;

        c[5][8] = 6;
        c[5][9] = 5;

        c[6][8] = 4;
        c[6][9] = 3;

        c[7][9] = 5;
        c[7][10] = 6;

        c[8][11] = 4;

        c[9][11] = 2;

        c[10][11] = 5;

        multiStageGraph();
    }
    
}
