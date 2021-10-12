package Algorithms.BackTracking;

public class SumOfSubSet {

    public static int n; // size of weight vector
    public static int s; // current sum
    public static int r; // remaining sum
    public static int M; // sum 

    static void display(int w[]){
        for (int i : w) {
            System.out.print(i);
        }
        System.out.println();
    }

    static void sumofsubset(int s, int r, int w[], int k){
        if(k==n-1){
            return;
        }
        w[k] = 1;
        if(s + w[k] == M){
            display(w);
        }else if(s + w[k] + w[k+1] <= M){
            sumofsubset(s+w[k],r-w[k],w,k+1);
        }
        if((s+r-w[k] >= M) && (s+w[k+1]<=M)){
            w[k] = 0;
            sumofsubset(s,r-w[k],w,k+1);
        }
    }

    public static void main(String[] args) {
        n = 4;
        int w[] = {4,5,8,9};
        M=9;
        sumofsubset(0, 26, w,0);
    }
    
}
