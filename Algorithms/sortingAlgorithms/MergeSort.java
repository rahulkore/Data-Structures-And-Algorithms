package Algorithms.sortingAlgorithms;

public class MergeSort {

    static void merge(int x[], int lb, int m, int ub){
        int temp[],i=lb,j=m+1,k=0;
        temp = new int[x.length];
        while(i <= m  && j <= ub){
            if(x[i]<x[j]){
                temp[k++] = x[i++];
            }else{
                temp[k++] = x[j++];
            }
        }
        while(i <= m){
            temp[k++] = x[i++];
        }
        while(j <= ub){
            temp[k++] = x[j++];
        }
        k=0;
        for(i = lb ; i <= ub ; i++){
            x[i] = temp[k++];
        }
    }

    static void mergeSort(int a[],int lb,int ub){
       int m;
        if(lb < ub){
           m = (lb + ub) / 2;
           mergeSort(a,lb,m);
           mergeSort(a,m+1,ub);
           merge(a, lb, m, ub);
       } 
    }

    public static void main(String[] args) {
        int elements[]= {59,23,65,12,38,80,30,45,35};
        mergeSort(elements,0,elements.length-1);
        for (int i : elements) {
            System.out.println(i);   
        }
    }
    
}
