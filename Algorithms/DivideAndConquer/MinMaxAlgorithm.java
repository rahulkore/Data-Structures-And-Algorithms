package Algorithms.DivideAndConquer


class MinMax {
    int min;
    int max;
}

public class MinMaxAlgorithm {

    static MinMax minmax(int x[], int i,int j){
        MinMax mm = new MinMax();
        MinMax mml = new MinMax();
        MinMax mmr = new MinMax();

        if(i == j){
            mm.min = x[i];
            mm.max = x[i];
            return mm;
        }

        if(i == j-1){
            if(x[i] < x[j]){
                mm.min = x[i];
                mm.max = x[j];
            }else{
                mm.min = x[j];
                mm.max = x[i];
            }
            return mm;
        }
        int m = (i+j) / 2;
        mml = minmax(x,i,m);
        mmr = minmax(x,m+1,j);

        if(mml.min < mmr.min){
            mm.min = mml.min;
        }else{
            mm.min = mmr.min;
        }

        if(mml.max > mmr.max){
            mm.max = mml.max;
        }else{
            mm.max = mmr.max;
        }

        return mm;

    }

    public static void main(String args[]){

        int elements[]= {59,23,65,12,38,80,30,45,35};
        MinMax mm = minmax(elements,0,elements.length-1);
        System.out.println(mm.min);
        System.out.println(mm.max);

    }
}