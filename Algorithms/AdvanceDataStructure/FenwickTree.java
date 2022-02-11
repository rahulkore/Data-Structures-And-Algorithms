package Algorithms.AdvanceDataStructure;

public class FenwickTree {

    private static int N;
    int[] fen = new int[N];


    /**Tc = O(logn) */
    public void update(int i, int add){
        while(i<N){
            fen[i] += add;
            /**To get the next index that will be affected 
             * by the updation of value on i do the following steps
             * 1 -> take 2's compliment of i 
             * 2 -> perform & operation with the original i
             * 3 -> add it with the original i  
             * All three operations combined into 1 is given below*/ 
            i += (i & (-i));
        }
    }


    /**Tc = O(logn) */
    public int sum(int i){
        int s = 0;
        while(i > 0){
            s += fen[i];
            /**To get the prev index to add it to the sum 
             * perform the following operation on i 
             * 1 -> take 2's compliment of i 
             * 2 -> perform & operation with the original i
             * 3 -> subtract it with the original i
             * All three operations combined into 1 is given below
             */
            i = i - (i & (-i));
        }
        return s;
    }

    /**Tc = O(2*logn) */
    public int range(int l, int r){
        return sum(r) - sum(l-1);
    }



    /**To find the lower bound of an element 
     * Binary lifting of fenwick tree
     */
    public int find(int k){
        int curr = 0,prevsum = 0;
        for(int i = (int)(Math.log(N)-Math.log(2));i>=0;i--){
            if(fen[curr + (1<<i)] + prevsum < k){
                curr = curr + (1<<i);
                prevsum = fen[curr];
            }
        }
        return curr+1;
    }
    public static void main(String[] args) {
        
    }
    
}
