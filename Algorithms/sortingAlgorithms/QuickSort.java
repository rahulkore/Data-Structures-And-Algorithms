package Algorithms.sortingAlgorithms;

public class QuickSort {

    static int partition(int x[], int lb, int ub){
        int val = x[lb] , down = lb+1 , up = ub;
        while(down <= up){
            while(down <= up && x[down]<= val)
                down++;
            while(x[up] > val)
                up--;
            if(down < up){
                int t = x[down];
                x[down] = x[up];
                x[up] = t; 
            }
        }
        x[lb] = x[up];
        x[up] = val;
        return up;
    }

    static void quickSort(int x[],int lb ,int ub){
        if(lb < ub){
            int p = partition(x, lb, ub);
            quickSort(x, lb, p-1);
            quickSort(x, p+1, ub);
        }
    }

    public static void main(String[] args) {
        int elements[]= {59,23,65,12,38,80,30,45,35};
        quickSort(elements,0,elements.length-1);
        for (int i : elements) {
            System.out.println(i);   
        }
    }
    
}
